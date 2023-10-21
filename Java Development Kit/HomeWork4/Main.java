import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        Employee employee1 = new Employee("Егор", "123",
                "000001", "2019-2020");
        Employee employee2 = new Employee("Николай", "1543",
                "000002", "2015-2020");
        Employee employee3 = new Employee("Алексей", "123652",
                "000003", "2017-2020");
        Employee employee4 = new Employee("Антон", "12848963",
                "000004", "2014-2020");
        Employee employee5 = new Employee("Сергей", "128489634456",
                "000005", "2014-2020");

        employeeDirectory.add(employee1);
        employeeDirectory.add(employee2);
        employeeDirectory.add(employee3);
        employeeDirectory.add(employee4);
        employeeDirectory.add(employee5);

        employeeDirectory.lookingEmployeeByExperience("2019-2020");
        System.out.println();
        employeeDirectory.lookingEmployeeByExperience("2014-2020");
        System.out.println();
        employeeDirectory.lookingEmployeeByExperience("2019-2021");
        System.out.println();
        employeeDirectory.displaysEmployeePhoneNumberByName("Николай");
        System.out.println();
        employeeDirectory.lookingEmployeeByServiceNumber("000004");
    }
}
