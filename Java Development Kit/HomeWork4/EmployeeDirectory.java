import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDirectory {
    private LinkedList<Employee> listEmployee;

    public EmployeeDirectory(){
        this.listEmployee = new LinkedList<>();
    }

    public void add(Employee employee){

        boolean flag = false;

        for (Employee emplo : listEmployee) {
            if (emplo.getServiceNumber().equals(employee.getServiceNumber())){
                flag = true;
            }
        }
        if (flag){
            System.out.println("A user with this number exists");
        }else {
            listEmployee.add(employee);
        }
    }

    public void remove(Employee employee){
        listEmployee.remove(employee);
    }

     public void lookingEmployeeByExperience(String experience){
        List<Employee> list = new ArrayList<>();

        for (Employee user : listEmployee) {
            if (user.getExperience(experience).equals(experience)){
                list.add(user);
            }
        }
        if (list.size() > 0){
            for (Employee employee : list) {
                printEmployee(employee);
            }
        }else {
            System.out.println("There is no employee with such experience");
        }

    }
    
    public void addPhoneNumber(String name, String phoneNumber){
        for (Employee user : listEmployee) {
            if (user.getName().equals(name)){
                user.addPhoneNumber(phoneNumber);
                return;
            }
        }
    }

   private void printEmployee(Employee employee){
       System.out.printf("Name: %s\nExperience: %s\nServiceNumber: %s\nPhoneNumber: %s\n",
               employee.getName(), employee.getExperiencePrint(),
               employee.getServiceNumber(), employee.getPhoneNumber());
   }

   public void displaysEmployeePhoneNumberByName(String name){
       for (Employee employee : listEmployee) {
           if (employee.getName().equals(name)){
               String phoneNumber = employee.getPhoneNumber();
               System.out.println("Phone number: " + phoneNumber);
               return;
           }
       }
   }

    public void lookingEmployeeByServiceNumber(String serviceNumber){
        for (Employee employee : listEmployee) {
            if (employee.getServiceNumber().equals(serviceNumber)){
                printEmployee(employee);
                return;
            }
        }
    }
}
