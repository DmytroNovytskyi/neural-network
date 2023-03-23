package com.nulp.neuron;

import java.util.Random;

public class Neuron {
    private Random random = new Random();
    private Double oldBias = random.nextDouble(-1, 1);
    private Double oldWeight1 = random.nextDouble(-1, 1);
    private Double oldWeight2 = random.nextDouble(-1, 1);
    private Double oldWeight3 = random.nextDouble(-1, 1);
    private Double bias = oldBias;
    private Double weight1 = oldWeight1;
    private Double weight2 = oldWeight2;
    private Double weight3 = oldWeight3;

    public double compute(double input1, double input2, double input3) {
        double preActivation = bias
                + weight1 * input1
                + weight2 * input2
                + weight3 * input3;
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
