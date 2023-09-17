package ru.geekbrains.homework5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Program {
    public static void main(String[] args) throws IOException{
        /**
         * destination Куда копируем
         * source      Откуда копируем
         */
        String destination = "C:\\Users\\admin\\Desktop\\JavaTechnologicalSpecialization\\Java Core\\HomeWorks\\backup";
        String source = "C:\\Users\\admin\\Desktop\\JavaTechnologicalSpecialization\\Java Core\\HomeWorks\\HomeWork5";

        Backup backup = new Backup();
        try {
            backup.backup(new File(source), destination);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
