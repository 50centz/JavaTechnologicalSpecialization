package ru.geekbrains.homework4.exception;

public class MyArraySizeException extends MyException {
    public MyArraySizeException(String message, int lengthArray1, int lengthArray2) {
        super(message, lengthArray1, lengthArray2);
    }

//    private final int lengthArray1;
//    private final int lengthArray2;
//    public MyArraySizeException(String message, int lengthArray1, int lengthArray2) {
//        super(message);
//        this.lengthArray1 = lengthArray1;
//        this.lengthArray2 = lengthArray2;
//    }
//
//    public int getLengthArray1() {
//        return lengthArray1;
//    }
//
//    public int getLengthArray2() {
//        return lengthArray2;
//    }
}
