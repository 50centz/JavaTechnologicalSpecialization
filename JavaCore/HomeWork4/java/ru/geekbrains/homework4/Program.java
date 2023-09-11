package ru.geekbrains.homework4;


import ru.geekbrains.homework4.checkingarray.CheckArray;
import ru.geekbrains.homework4.checkingarray.CheckingSizeArray;
import ru.geekbrains.homework4.checkingarray.SumArray;
import ru.geekbrains.homework4.createarray.CreateArray;
import ru.geekbrains.homework4.exception.MyArrayDataException;
import ru.geekbrains.homework4.exception.MyArraySizeException;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while (flag){
            System.out.println("Enter the array dimensions: ");
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            CreateArray createArray = new CreateArray();
            String[][] array = createArray.createArray(i, j);

            try {
                CheckingSizeArray checkingSizeArray = new CheckingSizeArray();
                checkingSizeArray.checkSizeArray(array);
                CheckArray checkArray = new CheckArray();
                checkArray.checkArray(array);
                SumArray sumArray = new SumArray();
                int result = sumArray.sumArray(array);
                System.out.printf("Sum of array elements = %d", result);
                flag = false;
            }catch (MyArraySizeException | MyArrayDataException e){
                System.out.printf(e.getMessage(), e.getLengthArray1(), e.getLengthArray2());
            }

        }
    }
}
