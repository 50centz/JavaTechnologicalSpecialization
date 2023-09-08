package homework3;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int res = o1.getSecondName().compareTo(o2.getSecondName());
        if (res == 0){
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
        return res;
    }
}
