import com.google.gson.Gson;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Slava", "Ivanov", 35);
        Gson gson = new Gson();
        Person person2 = new Person("Ivan", "Ivamov", 30);

        String result = gson.toJson(person);

        try(FileWriter writer = new FileWriter("Person.json")){
            writer.write(result);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


        StringBuilder sb = new StringBuilder();
        String res = "";

        try(FileReader reader = new FileReader("Person.json")) {
            BufferedReader br = new BufferedReader(reader);
            sb.append(br.readLine());
            res = sb.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Person person1 = gson.fromJson(res, Person.class);
        System.out.println(result);
        System.out.println(person1);
        System.out.println(person1.hashCode());
        System.out.println(person1.equals(person2));
    }
}
