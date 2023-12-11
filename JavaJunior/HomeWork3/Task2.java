import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Task2 {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();


    public static final String FILE_JSON = "task2.json";
    public static final String FILE_XML = "task2.xml";

    public static void main(String[] args) throws IOException {
        Student student = new Student("Vladimir", 25, 90);

        saveStudentToFile(FILE_JSON, student);
        saveStudentToFile(FILE_XML, student);

        Student student1 = loadStudentFromFile(FILE_JSON);
        System.out.println(student1);

        Student student2 = loadStudentFromFile(FILE_XML);
        System.out.println(student2);
    }



    public static void saveStudentToFile(String fileName, Student student) throws IOException {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
                objectMapper.writeValue(new File(fileName), student);
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static Student loadStudentFromFile(String fileName)  {

        Student student = null;

        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    student = objectMapper.readValue(file, objectMapper.getTypeFactory().constructType(Student.class));
                } else if (fileName.endsWith(".xml")) {
                    student = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructType(Student.class));
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return student;
    }


}
