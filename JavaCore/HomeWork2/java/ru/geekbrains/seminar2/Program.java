package ru.geekbrains.seminar2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static int winCount;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field;

    private static int fieldSizeX;
    private static int fieldSizeY;


    public static void main(String[] args) {
        while (true){
            initialize();
            printField();

            while (true){
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "You win!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Computer win!"))
                    break;
            }
            System.out.println("Would you like to play again ? (Y - yes) or (N - no):");
            if(!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    private static void initialize(){

        int w = 0;
        int z = 0;

        while (true){
            System.out.printf("Введите размеры игрового поля: ");
            if (scanner.hasNextInt()){
                w = scanner.nextInt();
                scanner.nextLine();
                break;
            }else {
                System.out.println("Entered an incorrect number, try again!");
                scanner.nextLine();
            }
        }

        System.out.println();

        while (true){
            System.out.printf("Введите количество фишек для выигрышной комбинации\nКоличество фишек " +
                    "не должно быть меньше двух и больше размера поля: ");
            if (scanner.hasNextInt()){
                z = scanner.nextInt();
                scanner.nextLine();
                if (z <= w && z > 2)
                    break;
            }else {
                System.out.println("Entered an incorrect number, try again!");
                scanner.nextLine();
            }
        }

        fieldSizeX = w;
        fieldSizeY = w;
        winCount = z;

        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY ; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    private static void printField(){
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++){
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        }

        System.out.println();

        for (int x = 0; x < fieldSizeX; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int x = 0; x < fieldSizeX * 2 + 2; x++){
            System.out.print("-");
        }

        System.out.println();
    }

    private static void humanTurn(){
        int x, y;

        do{
            while (true){
                System.out.printf("Введите координату Х  (1 до %d): ", fieldSizeX);
                if (scanner.hasNextInt()){
                    x = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                }else {
                    System.out.println("Entered an incorrect number, try again!");
                    scanner.nextLine();
                }
            }

            while (true){
                System.out.printf("Введите координату Y  (1 до %d): ", fieldSizeY);
                if (scanner.hasNextInt()){
                    y = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                }else {
                    System.out.println("Entered an incorrect number, try again!");
                    scanner.nextLine();
                }
            }
        }while (!isCellValid(x, y) || !isCellEmpty(x, y) );

        field[x][y] = DOT_HUMAN;

    }

    private static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    private static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static void aiTurn(){
        int x, y;

        do{
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }while (!isCellEmpty(x, y));

        field[x][y] = DOT_AI;
    }

    private static boolean checkGameState(char c, String s){
        if (checkWin(c)){
            System.out.println(s);
            return true;
        }
        if (checkDraw()){
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char c){
        // Проверка горизонтали

        int count = winCount - 1;

        for (int x = 0; x < fieldSizeX; x++){
            int a = 0;
            for (int y = 1; y < fieldSizeY; y++){
                if (field[x][y - 1] == c && field[x][y] == c){
                    a++;
                }else {
                    a = 0;
                }
                if (a == count){
                    return true;
                }
            }
        }

        // Проверка вертикали

        for (int y = 0; y < fieldSizeX; y++){
            int a = 0;
            for (int x = 1; x < fieldSizeY; x++){
                if (field[x - 1][y] == c && field[x][y] == c){
                    a++;
                }else {
                    a = 0;
                }
                if (a == count){
                    return true;
                }
            }
        }

        // Проверка по диагонали

        for (int q = 0; q < 1; q++){
            int a = 0;
            for (int x = 1; x < fieldSizeX; x++){
                for (int y = x; y < x + 1; y++){
                    if (field[x - 1][y - 1] == c && field[x][y] == c){
                        a++;
                    }else {
                        a = 0;
                    }
                }
                if (a == count){
                    return true;
                }
            }
        }

        for (int q = 0; q < 1; q++){
            int a = 0;
            for (int x = 1; x < fieldSizeX; x++){
                for (int y = fieldSizeY - x; y >= fieldSizeY - x; y--){
                    if (field[x - 1][y] == c && field[x][y - 1] == c){
                        a++;
                    }else {
                        a = 0;
                    }
                }
                if (a == count){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (isCellEmpty(x, y)) return false;
            }
        }
        return  true;
    }
}
