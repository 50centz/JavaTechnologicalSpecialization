public class Main {
    public static void main(String[] args) {

        Calculator.sum(10, 15.0);
        Calculator.subtract(10.0, 15);
        Calculator.divide(10, 0);
        Calculator.multiply(5, 25.0);



        System.out.println();
        System.out.println();



        Task2 task2 = new Task2();

        String[] arr = new String[]{"1", "2", "3"};
        String[] arr1 = new String[]{"1", "2", "3"};
        System.out.println(task2.compareArrays(arr, arr1));



        System.out.println();
        System.out.println();



        Task3<Task2, Double> task3 = new Task3<>(new Task2(), 2023.00);

        System.out.println(task3.getFirst());
        System.out.println(task3.getSecond());
        System.out.println(task3.toString());



        System.out.println();
        System.out.println();


        Task3<String, Double> task33 = new Task3<>("Hello", 2023.00);

        System.out.println(task33.getFirst());
        System.out.println(task33.getSecond());
        System.out.println(task33.toString());

    }
}
