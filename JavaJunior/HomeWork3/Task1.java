import java.io.*;

public class Task1 {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Vladimir", 25, 90);



        try(FileOutputStream fileOutputStream = new FileOutputStream("task1.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(student);
            System.out.println("Объект Student сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("task1.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            student = (Student) objectInputStream.readObject();
            System.out.println("Объект Student десериализован.");
        }

        System.out.println(student);

    }
}
