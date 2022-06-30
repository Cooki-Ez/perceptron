package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    final List<Iris> training;
    int iterations;
    final static List<Double> list_of_weights = new ArrayList<>();
    static double LEARNING_RATE = 0.01;
    static double THRESHOLD = 0;


    public Algorithm(List<Iris> training, int iterations) {
        this.training = training;
        this.iterations = iterations;
        peekRandomWeights();
    }

    private void peekRandomWeights() {
        for (int i = 0; i < training.get(0).getCoordinates().size(); i++)
            list_of_weights.add(Math.random());
        begin();
    }

    public void begin(){
        for (int k = 0; k < iterations; k++) {
            for (Iris iris : training) {
                for (int j = 0; j < iris.getCoordinates().size(); j++) {
                    double newWeight = iris.getCoordinates().get(j) + LEARNING_RATE
                            * (iris.getNumber_of_type() - getResult(iris))
                            * iris.getCoordinates().get(j);
                    list_of_weights.set(j, newWeight);
                }
                THRESHOLD = THRESHOLD - LEARNING_RATE * (iris.getNumber_of_type() - getResult(iris));
                THRESHOLD = Double.parseDouble(new DecimalFormat("##.##").format(THRESHOLD));
            }
        }
    }

    private int getResult(Iris iris) {
        int result = 0;
        for (int i = 0; i < iris.getCoordinates().size(); i++) {
            result += iris.getCoordinates().get(i)*list_of_weights.get(i);
        }
        return result >= THRESHOLD ? 1 : 0;
    }

    static void test(List<Iris> test){
        double error = 0;
        double total = 0;
        for (Iris iris : test) {
            int result = 0;
            for (int j = 0; j < iris.getCoordinates().size(); j++) {
                result += iris.getCoordinates().get(j) * list_of_weights.get(j);
            }
            if (result >= THRESHOLD) {
                System.out.println("Found: virginica, real: " + iris.getName());
                if (!"virginica".equals(iris.getName())) error++;
            } else {
                System.out.println("Found: versicolor, real: " + iris.getName());
                if (!"versicolor".equals(iris.getName())) error++;
            }
            total++;
        }
        System.out.println("Error: " + Double.parseDouble(new DecimalFormat("##.##").format(error * 100 / total)) + "%");
    }

}
