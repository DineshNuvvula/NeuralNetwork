package network;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of layers: ");
        int layers = input.nextInt();

        int[] nodesInEachLayer = new int[layers];
        for (int i = 0; i < layers; i++) {
            System.out.print("Enter the number of nodes in layer " + i + ": ");
            nodesInEachLayer[i] = input.nextInt();
        }

        // Create a NNetwork object
        Network Network = new Network(layers, nodesInEachLayer);

        // Query weight for a specific edge
        System.out.print("Enter the starting layer: ");
        int initialLayer = input.nextInt();
        System.out.print("Enter the starting node: ");
        int initialNode = input.nextInt();
        System.out.print("Enter the ending layer: ");
        int finalLayer = input.nextInt();
        System.out.print("Enter the ending node: ");
        int finalNode = input.nextInt();

        double weight = Network.getWeight(initialLayer, initialNode, finalLayer, finalNode);
        System.out.println("Weight of edge between (" + initialLayer + ", " + initialNode + ") to (" + finalLayer + ", " + finalNode + "): " + weight);
    }
}
