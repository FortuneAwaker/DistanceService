package by.itechart.distance.service.route;

import by.itechart.distance.dto.CityDto;
import by.itechart.distance.dto.RoadDto;
import by.itechart.distance.service.CityService;
import by.itechart.distance.service.RoadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class GraphInitializer {

    private final CityService cityService;
    private final RoadService roadService;


    public Graph initializeGraphFromDB() {
        Graph graph = new Graph();
        List<Node> nodes = createNodeListFromCityList(cityService.getAllCities());
        fillNodeListWithRoads(nodes, roadService.getAllRoads());
        addNodesToGraph(graph, nodes);
        return graph;
    }

    private List<Node> createNodeListFromCityList(final List<CityDto> cities) {
        List<Node> nodes = new ArrayList<>();
        for (CityDto city: cities) {
            nodes.add(new Node(city.getId()));
        }
        return nodes;
    }

    private void fillNodeListWithRoads(final List<Node> nodes, final List<RoadDto> roads) {
        for (RoadDto road: roads) {
            Node first = findNodeByCityId(nodes, road.getFirstCityId());
            Node second = findNodeByCityId(nodes, road.getSecondCityId());
            first.addRoad(second, road.getDistance());
            second.addRoad(first, road.getDistance());
        }
    }

    private Node findNodeByCityId(final List<Node> nodes, final Long cityId) {
        Node found = null;
        for (Node node: nodes) {
            if (node.getCityId().equals(cityId)) {
                found = node;
                break;
            }
        }
        return found;
    }

    private void addNodesToGraph(Graph graph, final List<Node> nodes) {
        for (Node node: nodes) {
            graph.addNode(node);
        }
    }
}
