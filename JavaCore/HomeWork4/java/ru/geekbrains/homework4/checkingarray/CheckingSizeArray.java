package ru.geekbrains.homework4.checkingarray;

import ru.geekbrains.homework4.exception.MyArraySizeException;

public class CheckingSizeArray {

    public CheckingSizeArray(){

    }

    public void checkSizeArray(String[][] array) throws MyArraySizeException {
        if (array.length != 4 && array[0].length != 4){
            throw new MyArraySizeException("Invalid array, the array should be 4 by 4," +
                    " and yours is %d by %d\nTry creating a new array\n", array.length, array[0].length);
        }
    }
}
