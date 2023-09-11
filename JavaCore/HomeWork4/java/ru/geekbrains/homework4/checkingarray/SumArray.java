package ru.geekbrains.homework4.checkingarray;

public class SumArray {

    public int sumArray(String[][] array){
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result += Integer.parseInt(array[i][j]);
            }
        }
        return result;
    }
}
