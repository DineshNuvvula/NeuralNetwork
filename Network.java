package network;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Network {
    private int layers;
    private int[] nodesInEachLayer;
    private Map<Edge, Double> weights;

    public Network(int layers, int[] nodesInEachLayer) {
        this.layers = layers;
        this.nodesInEachLayer = nodesInEachLayer;
        this.weights = new HashMap<>();

        // Initialize weights based on user input
        initializeWeights();
    }

    private void initializeWeights() {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < layers - 1; i++) {
            for (int node1 = 0; node1 < nodesInEachLayer[i]; node1++) {
                for (int node2 = 0; node2 < nodesInEachLayer[i + 1]; node2++) {
                    System.out.print("Enter weight for edge (" + i + ", " + node1 + ") to (" + (i + 1) + ", " + node2 + "): ");
                    double weight = input.nextDouble();
                    weights.put(new Edge(i, node1, i + 1, node2), weight);
                }
            }
        }
    }

    public double getWeight(int initialLayer, int initialNode, int finalLayer, int finalNode) {
        Edge edge = new Edge(initialLayer, initialNode, finalLayer, finalNode);
        return weights.getOrDefault(edge, 0.0);
    }
}

class Edge {
    private int initialLayer, initialNode, finalLayer, finalNode;

    public Edge(int initialLayer, int initialNode, int finalLayer, int finalNode) {
        this.initialLayer = initialLayer;
        this.initialNode = initialNode;
        this.finalLayer = finalLayer;
        this.finalNode = finalNode;
    }

    @Override
    public int hashCode() {
        return (initialLayer * 31 + initialNode) * 31 + (finalLayer * 31 + finalNode);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge edge = (Edge) obj;
        return initialLayer == edge.initialLayer && initialNode == edge.initialNode && finalLayer == edge.finalLayer && finalNode == edge.finalNode;
    }
}
