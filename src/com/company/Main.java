package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Nazar Lytvyn
 */

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int iterations = 200;

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Locale loc = Locale.ENGLISH;
        Locale.setDefault(loc);
        System.out.println("Enter 1 to change path to TRAIN from.");
        System.out.println("Enter 2 to change path to TEST from.");
        System.out.println("Enter 3 to change number of iterations.");
        System.out.println("Enter 4 to input manually");
        System.out.println("Enter 5 to start training");
        System.out.println("Enter 6 to start test");
        System.out.println("Enter 7 to exit");
        String trainingExample = "perceptron.data.txt";
        String testExample = "perceptron.test.data.txt";
        int fromUser = sc.nextInt();
        switch (fromUser) {
            case 1 -> {
                System.out.println("Path to TRAIN file");
                trainingExample = sc.nextLine();
            }
            case 2 -> {
                System.out.println("Path to TEST file");
                testExample = sc.nextLine();
            }
            case 3 -> {
                System.out.println("New number of iterations");
                iterations = sc.nextInt();
            }
            case 4 -> new vectorsFromUser(trainingExample, testExample);
            case 5 -> new DataReader(trainingExample, iterations);
            case 6 -> new DataReader(testExample);
            case 7 -> System.exit(1);
        }
        start();
    }
}
