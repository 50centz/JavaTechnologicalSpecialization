package homework3;

public abstract class Employee implements Comparable<Employee>{

    protected String firstName;
    protected String secondName;
    protected int workPriceMonth;

    protected Employee(String firstName, String secondName, int workPriceMonth){
        this.firstName = firstName;
        this.secondName = secondName;
        this.workPriceMonth = workPriceMonth;
    }
    protected abstract String getFirstName();
    protected abstract String getSecondName();
    public abstract double averageMonthlySalary();


    @Override
    public String toString() {
        return firstName + " " +
                secondName + " " +
                workPriceMonth;
    }

    @Override
    public int compareTo(Employee o) {

        return Double.compare(averageMonthlySalary(), o.averageMonthlySalary());
//        return averageMonthlySalary() == o.averageMonthlySalary() ? 0 :
//                averageMonthlySalary() > o.averageMonthlySalary() ? 1 : -1;
    }
}
