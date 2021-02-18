package by.itechart.distance.service.route;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

}
