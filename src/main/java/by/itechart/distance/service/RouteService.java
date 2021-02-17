package by.itechart.distance.service;

import by.itechart.distance.dto.CityDto;
import by.itechart.distance.dto.FindRouteRequest;
import by.itechart.distance.dto.RouteDto;
import by.itechart.distance.service.route.Graph;
import by.itechart.distance.service.route.GraphInitializer;
import by.itechart.distance.service.route.Node;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RouteService {

    private final GraphInitializer graphInitializer;
    private final CityService cityService;

    public RouteDto findRoutes(final FindRouteRequest request) {
        // добавить проверку на валидность городов в request
        Graph graph = graphInitializer.initializeGraphFromDB();
        Node startPoint = new Node(request.getFirstCityDto().getId());
        graph = calculateShortestPathFromSource(graph, startPoint);
        Node destination = graph.getNodes().stream()
                .filter((node -> node.getCityId() == request.getSecondCityDto().getId()))
                .collect(Collectors.toList()).get(0);
        List<CityDto> visitedCities = new LinkedList<>();
        for (Node visitedNode: destination.getShortestPath()
             ) {
            visitedCities.add(cityService.findById(visitedNode.getCityId()));
        }
        return new RouteDto(destination.getDistance(), visitedCities);
    }

    private Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0.0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry< Node, Double> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Double edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        Double lowestDistance = Double.MAX_VALUE;
        for (Node node: unsettledNodes) {
            Double nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private void calculateMinimumDistance(Node evaluationNode,
                                  Double edgeWeigh, Node sourceNode) {
        Double sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
