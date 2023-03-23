package com.nulp.neuron;

public class Main {
    public static void main(String[] args) {
        double[][] data = {{1.88, 4.52, 1.91},
                {4.52, 1.91, 5.66},
                {1.91, 5.66, 1.23},
                {5.66, 1.23, 5.50},
                {1.23, 5.50, 1.14},
                {5.50, 1.14, 5.29},
                {1.14, 5.29, 1.60},
                {5.29, 1.60, 4.31},
                {1.60, 4.31, 0.06},
                {4.31, 0.06, 5.33},
                {0.06, 5.33, 0.07}};
        double[] answers = {5.66, 1.23, 5.50, 1.14, 5.29, 1.60, 4.31, 0.06, 5.33, 0.07, 4.62};

        Network network = new Network();
        network.train(data, answers);
        System.out.println("RESULT: " + network.predict(1.88, 4.52, 1.91));
        System.out.println("RESULT: " + network.predict(4.52, 1.91, 5.66));
        System.out.println("RESULT: " + network.predict(1.91, 5.66, 1.23));
        System.out.println("RESULT: " + network.predict(5.66, 1.23, 5.50));
        System.out.println("RESULT: " + network.predict(1.23, 5.50, 1.14));
        System.out.println("RESULT: " + network.predict(5.50, 1.14, 5.29));
        System.out.println("RESULT: " + network.predict(1.14, 5.29, 1.60));
        System.out.println("RESULT: " + network.predict(5.29, 1.60, 4.31));
        System.out.println("RESULT: " + network.predict(1.60, 4.31, 0.06));
        System.out.println("RESULT: " + network.predict(0.06, 5.33, 0.07));
        System.out.println("RESULT: " + network.predict(5.33, 0.07, 4.62));
    }
}