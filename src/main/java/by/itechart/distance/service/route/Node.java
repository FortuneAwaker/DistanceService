package by.itechart.distance.service.route;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public class Node {

    private Long cityId;

    private List<Node> shortestPath = new LinkedList<>();

    private Double distance = Double.MAX_VALUE;

    Map<Node, Double> adjacentNodes = new HashMap<>();

    public void addRoad(Node destination, Double distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(final Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return cityId.equals(node.getCityId());
    }

    @Override
    public int hashCode() {
        return cityId.intValue();
    }

}
