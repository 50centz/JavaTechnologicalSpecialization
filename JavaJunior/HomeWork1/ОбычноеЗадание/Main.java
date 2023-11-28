package ru.geekbrains.lesson1.task3;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        double average = Stream.of(1, 2, 3, 4, 5, 6, 10, 40)
                .filter(x -> x % 2 == 0).mapToDouble(x -> x).average().orElse(Double.NaN);


        System.out.println(average);
    }

}
