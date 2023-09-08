package homework3;

public class Freelancer extends Employee {



    public Freelancer(String firstName, String secondName, int workPriceHour){
        super(firstName, secondName, workPriceHour);
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
        return 20.8 * 8 * workPriceMonth;
    }
}
