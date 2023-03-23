package com.nulp.neuron;

public class LogicGates {
    public static int and(int in1, int in2) {
        return in1 + in2 < 1.5 ? 0 : 1;
    }

    public static int or(int in1, int in2) {
        return in1 + in2 < 0.5 ? 0 : 1;
    }

    public static int not(int in) {
        return -1.5 * in < -1 ? 0 : 1;
    }

    public static int xor(int in1, int in2) {
        int out1 = in1 - in2 < 0.5 ? 0 : 1;
        int out2 = in2 - in1 < 0.5 ? 0 : 1;
        return out1 + out2 < 0.5 ? 0 : 1;
    }
}
