package homework3;

import java.util.Iterator;
import java.util.List;


public class PrintEmployee implements Iterable<Employee>{

    private List<Employee> employeeList;

    public PrintEmployee(List<Employee> employeeList){
        this.employeeList = employeeList;
    }

    @Override
    public Iterator<Employee> iterator() {
        return employeeList.iterator();
    }



    public void printEmployee(){
//        for (Employee e: employeeList) {
//            System.out.println(e);
//
//        }
        Iterator<Employee> iter = employeeList.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }


}
