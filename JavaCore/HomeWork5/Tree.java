package ru.geekbrains.seminar5;

import java.io.File;

public class Tree {
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());


        File[] files = file.listFiles();
        if (files == null){
            return;
        }


        //Добавил цикл для вывода файлов

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                if (i == files.length - 1) {
                    System.out.print(indent);
                    System.out.print("└─");
                    System.out.println(files[i].getName());
                } else {
                    System.out.print(indent);
                    System.out.print("├─");
                    System.out.println(files[i].getName());
                }
            }
        }
        


        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
        }



        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()){
                subDirCounter++;
                print(files[i], indent,subDirCounter == subDirTotal);
            }

        }
    }
}
