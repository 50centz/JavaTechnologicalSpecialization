package task1;

public class Dog extends Animal{

    private String name;
    private int age;

    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void makeSound(){
        System.out.println("Gav gav");
    }
}
