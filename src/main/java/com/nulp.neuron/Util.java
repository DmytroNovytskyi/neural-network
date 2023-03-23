package com.nulp.neuron;

public class Util {
    public static double sigmoid(double in) {
        return (1 / (1 + Math.exp(-in))) * 10;
    }

    public static Double meanSquareLoss(double[] correctAnswers, double[] predictedAnswers) {
        double sumSquare = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            double error = correctAnswers[i] - predictedAnswers[i];
            sumSquare += (error * error);
        }
        return sumSquare / (correctAnswers.length);
    }
}
