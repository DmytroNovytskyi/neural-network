package com.nulp.neuron;

import java.util.Random;

public class Network {
    private final int epochs;
    private final int epochsLogged;
    private final Neuron[] neurons;

    public Network(int numberOfNeurons, int epochs, int epochsLogged) {
        if (numberOfNeurons < 1 || (numberOfNeurons - 1) % 3 != 0) {
            throw new IllegalArgumentException("wrong number of neurons");
        }
        if (epochs < 1) {
            throw new IllegalArgumentException("wrong number of epochs");
        }
        if (epochsLogged < 1) {
            throw new IllegalArgumentException("wrong number of logged epochs");
        }
        this.epochs = epochs;
        this.epochsLogged = epochsLogged;
        neurons = new Neuron[numberOfNeurons];
        for (int i = 0; i < neurons.length; i++) {
            neurons[i] = new Neuron();
        }
    }

    public double predict(double input1, double input2, double input3) {
        double temp1 = input1;
        double temp2 = input2;
        double temp3 = input3;
        for (int i = 0; i < (neurons.length - 1) / 3; i += 3) {
            double res1 = neurons[i].compute(temp1, temp2, temp3);
            double res2 = neurons[i + 1].compute(temp1, temp2, temp3);
            double res3 = neurons[i + 2].compute(temp1, temp2, temp3);
            temp1 = res1;
            temp2 = res2;
            temp3 = res3;
        }
        return neurons[neurons.length - 1].compute(temp1, temp2, temp3);
    }

    public void train(double[][] data, double[] answers) {
        int logFactor = epochs / epochsLogged;
        double bestEpochLoss = testPredictions(data, answers);
        for (int epoch = 0; epoch < epochs; epoch++) {
            Neuron epochNeuron = neurons[epoch % neurons.length];
            epochNeuron.mutate();
            double thisEpochLoss = testPredictions(data, answers);
            if (thisEpochLoss < bestEpochLoss) {
                bestEpochLoss = thisEpochLoss;
                epochNeuron.remember();
            } else {
                epochNeuron.forget();
            }

            if (epoch % logFactor == 0) {
                System.out.printf("Epoch: %3s | bestEpochLoss: %.15f | thisEpochLoss: %.15f%n",
                        epoch, bestEpochLoss, thisEpochLoss);
            }
        }
    }

    private double testPredictions(double[][] data, double[] answers) {
        double[] predictions = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            predictions[i] = predict(data[i][0], data[i][1], data[i][2]);
        }
        return Util.meanSquareLoss(answers, predictions);
    }

    private static class Neuron {
        private final Random random = new Random();
        private double oldBias = random.nextDouble(-1, 1);
        private double oldWeight1 = random.nextDouble(-1, 1);
        private double oldWeight2 = random.nextDouble(-1, 1);
        private double oldWeight3 = random.nextDouble(-1, 1);
        private double bias = oldBias;
        private double weight1 = oldWeight1;
        private double weight2 = oldWeight2;
        private double weight3 = oldWeight3;

        public double compute(double input1, double input2, double input3) {
            double preActivation = bias + weight1 * input1 + weight2 * input2 + weight3 * input3;
            return Util.sigmoid(preActivation);
        }

        public void mutate() {
            int propertyToChange = random.nextInt(0, 4);
            double changeFactor = random.nextDouble(-1, 1);
            if (propertyToChange == 0) {
                bias += changeFactor;
            } else if (propertyToChange == 1) {
                weight1 += changeFactor;
            } else if (propertyToChange == 2) {
                weight2 += changeFactor;
            } else {
                weight3 += changeFactor;
            }
        }

        public void forget() {
            bias = oldBias;
            weight1 = oldWeight1;
            weight2 = oldWeight2;
            weight3 = oldWeight3;
        }

        public void remember() {
            oldBias = bias;
            oldWeight1 = weight1;
            oldWeight2 = weight2;
            oldWeight3 = weight3;
        }
    }
}
