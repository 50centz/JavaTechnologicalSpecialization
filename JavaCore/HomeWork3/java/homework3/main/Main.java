package homework3.main;

import homework3.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Freelancer("Vasya", "Petrov", 10000));
        employeeList.add(new Worker("Evil", "Dracur", 50000));
        employeeList.add(new Freelancer("Ivan","Ivanov",2000));
        employeeList.add(new Worker("Sergey", "Semenov", 10000));

        for (Employee e: employeeList) {
            System.out.println(e);
        }

        System.out.println();

        Collections.sort(employeeList, new EmployeeNameComparator());


        PrintEmployee printEmployee = new PrintEmployee(employeeList);
        printEmployee.printEmployee();


    }
}
