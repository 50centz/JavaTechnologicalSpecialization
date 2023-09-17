package ru.geekbrains.homework5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Backup {


    public void backup(File file, String nameFolder) throws IOException {
        File file1 = new File(nameFolder);
        System.out.println(file1);
        if (!file1.exists()){
            file1.mkdir();
        }


        File[] files = file.listFiles();
        if (files == null){
            return;
        }

        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()){
                String nameFile = files[i].getName();
                Files.copy(Path.of(files[i].getCanonicalPath()), Path.of(nameFolder, nameFile), REPLACE_EXISTING);
            }
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()){
                String name = nameFolder;
                nameFolder += "\\" + files[i].getName();
                backup(files[i], nameFolder);
                nameFolder = name;
            }
        }
    }
}
