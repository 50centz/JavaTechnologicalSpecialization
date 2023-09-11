package ru.geekbrains.homework4.exception;

public class MyArrayDataException extends MyException{
    public MyArrayDataException(String message, int lengthArray1, int lengthArray2) {
        super(message, lengthArray1, lengthArray2);
    }
}
