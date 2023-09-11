package ru.geekbrains.homework4.checkingarray;

import ru.geekbrains.homework4.exception.MyArrayDataException;

public class CheckArray {

    public CheckArray(){}

    public void checkArray(String[][] array) throws MyArrayDataException {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("The element under index %d, %d is not a number\n" +
                            "It is not possible to sum the array elements\n" +
                            "Pass the correct array\n", i, j);
                }
            }
        }
    }
}
