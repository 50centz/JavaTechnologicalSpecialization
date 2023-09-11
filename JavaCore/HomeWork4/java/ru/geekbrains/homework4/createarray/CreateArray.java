package ru.geekbrains.homework4.createarray;

import java.util.Random;

public class CreateArray {

    private final String string = "7498448F1454F87461d84464h764sdAf686?168468B684!64654464643+54186487164G1654";

    public String[][] createArray(int i, int j){
        int a = 0;
        String[][] result = new String[i][j];

        for (int k = 0; k < result.length; k++) {
            for (int l = 0; l < result[k].length; l++) {
                int number = (int)(Math.random() * (string.length() - a) + a);
                char c = string.charAt(number);
                result[k][l] = String.valueOf(c);
            }
        }
        return result;
    }
}
