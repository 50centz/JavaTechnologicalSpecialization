import java.util.LinkedList;

public class Employee {

    private String serviceNumber;
    private LinkedList<String> listPhoneNumber;
    private String name;
    private LinkedList<String> listExperience;


    public Employee(String name, String phoneNumber, String serviceNumber, String experience){
        listPhoneNumber = new LinkedList<>();
        listExperience = new LinkedList<>();
        this.name = name;
        this.serviceNumber = serviceNumber;
        addExperience(experience);
        addPhoneNumber(phoneNumber);
    }

    public void addExperience(String experience){
        this.listExperience.add(experience);
    }
    public void addPhoneNumber(String phoneNumber){
        this.listPhoneNumber.add(phoneNumber);
    }

    public String getName(){
        return name;
    }

    public String getExperience(String experience){
        for (String expe : listExperience) {
            if (expe.equals(experience)){
                return expe;
            }
        }
        return "";
    }

    public String getExperiencePrint(){
        String res = "";
        for (String experience : listExperience) {
            res += experience + " ";
        }
        return res;
    }

    public  String getServiceNumber(){
        return serviceNumber;
    }

    public String getPhoneNumber(){
        String res = "";
        for (String phoneNumber : listPhoneNumber) {
            res += phoneNumber + " ";
        }
        return res;
    }



}
