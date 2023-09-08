package homework3;

public class Worker extends Employee {



    public Worker(String firstName, String secondName, int workPriceMonth){
        super(firstName, secondName, workPriceMonth);
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getSecondName() {
        return secondName;
    }

    @Override
    public double averageMonthlySalary() {
        return workPriceMonth;
    }
}
