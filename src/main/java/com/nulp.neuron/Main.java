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
                {4.31, 0.06, 5.33}};
        double[] answers = {5.66, 1.23, 5.50, 1.14, 5.29, 1.60, 4.31, 0.06, 5.33, 0.07};

        Network network = new Network(10, 2000000, 10);
        network.train(data, answers);
        System.out.printf("EXPECTED: 5.66 ACTUAL: %.2f\n", network.predict(1.88, 4.52, 1.91));
        System.out.printf("EXPECTED: 1.23 ACTUAL: %.2f\n", network.predict(4.52, 1.91, 5.66));
        System.out.printf("EXPECTED: 5.50 ACTUAL: %.2f\n", network.predict(1.91, 5.66, 1.23));
        System.out.printf("EXPECTED: 1.14 ACTUAL: %.2f\n", network.predict(5.66, 1.23, 5.50));
        System.out.printf("EXPECTED: 5.29 ACTUAL: %.2f\n", network.predict(1.23, 5.50, 1.14));
        System.out.printf("EXPECTED: 1.60 ACTUAL: %.2f\n", network.predict(5.50, 1.14, 5.29));
        System.out.printf("EXPECTED: 4.31 ACTUAL: %.2f\n", network.predict(1.14, 5.29, 1.60));
        System.out.printf("EXPECTED: 0.06 ACTUAL: %.2f\n", network.predict(5.29, 1.60, 4.31));
        System.out.printf("EXPECTED: 5.33 ACTUAL: %.2f\n", network.predict(1.60, 4.31, 0.06));
        System.out.printf("EXPECTED: 0.07 ACTUAL: %.2f\n", network.predict(4.31, 0.06, 5.33));
        System.out.printf("EXPECTED: 4.62 ACTUAL: %.2f\n", network.predict(0.06, 5.33, 0.07));
        System.out.printf("EXPECTED: 0.69 ACTUAL: %.2f\n", network.predict(5.33, 0.07, 4.62));

//        network.printWeights();

        testLogicGates();
    }

    private static void testLogicGates(){
        System.out.println("-----------------------LOGIC GATES-----------------------");
        System.out.println("0 AND 0 = " + LogicGates.and(0, 0));
        System.out.println("0 AND 1 = " + LogicGates.and(0, 1));
        System.out.println("1 AND 0 = " + LogicGates.and(1, 0));
        System.out.println("1 AND 1 = " + LogicGates.and(1, 1));
        System.out.println("----------------------------------------------------------");
        System.out.println("0 OR 0 = " + LogicGates.or(0, 0));
        System.out.println("0 OR 1 = " + LogicGates.or(0, 1));
        System.out.println("1 OR 0 = " + LogicGates.or(1, 0));
        System.out.println("1 OR 1 = " + LogicGates.or(1, 1));
        System.out.println("----------------------------------------------------------");
        System.out.println("NOT 0 = " + LogicGates.not(0));
        System.out.println("NOT 1 = " + LogicGates.not(1));
        System.out.println("----------------------------------------------------------");
        System.out.println("0 XOR 0 = " + LogicGates.xor(0, 0));
        System.out.println("0 XOR 1 = " + LogicGates.xor(0, 1));
        System.out.println("1 XOR 0 = " + LogicGates.xor(1, 0));
        System.out.println("1 XOR 1 = " + LogicGates.xor(1, 1));
    }
}