public class Calculator {


    public static <T extends Number> void sum(T first, T second) {

        if (first instanceof Double && second instanceof Double) {
            System.out.println((double) first + (double) second);
        }
        if (first instanceof Double && second instanceof Integer) {
            int s = (Integer) second;
            System.out.println((double) first + (double) s);
        }
        if (first instanceof Integer && second instanceof Double) {
            int f = (Integer) first;
            System.out.println((double) f + (double) second);
        }
        if (first instanceof Integer && second instanceof Integer) {
            System.out.println((Integer) first + (Integer) second);
        }
    }

    public static <T extends Number> void subtract(T first, T second) {

        if (first instanceof Double && second instanceof Double) {
            System.out.println((double) first - (double) second);
        }
        if (first instanceof Double && second instanceof Integer) {
            int s = (Integer) second;
            System.out.println((double) first - (double) s);
        }
        if (first instanceof Integer && second instanceof Double) {
            int f = (Integer) first;
            System.out.println((double) f - (double) second);
        }
        if (first instanceof Integer && second instanceof Integer) {
            System.out.println((Integer) first - (Integer) second);
        }
    }

    public static <T extends Number> void divide(T first, T second) {

        if (second instanceof Integer) {
            int s = (Integer) second;
            if (s == 0) {
                System.out.println("Division by zero is prohibited!");
                return;
            }
        }

        if (second instanceof Double) {
            double s = (double) second;
            if (s == 0) {
                System.out.println("Division by zero is prohibited!");
                return;
            }
        }

        if (first instanceof Double && second instanceof Double) {
            System.out.println((double) first / (double) second);
        }
        if (first instanceof Double && second instanceof Integer) {
            int s = (Integer) second;
            System.out.println((double) first / (double) s);
        }
        if (first instanceof Integer && second instanceof Double) {
            int f = (Integer) first;
            System.out.println((double) f / (double) second);
        }
        if (first instanceof Integer && second instanceof Integer) {
            int f = (Integer) first;
            int s = (Integer) second;
            System.out.println((double) f / (double) s);
        }
    }

    public static <T extends Number> void multiply(T first, T second) {

        if (first instanceof Double && second instanceof Double) {
            System.out.println((double) first * (double) second);
        }
        if (first instanceof Double && second instanceof Integer) {
            int s = (Integer) second;
            System.out.println((double) first * (double) s);
        }
        if (first instanceof Integer && second instanceof Double) {
            int f = (Integer) first;
            System.out.println((double) f * (double) second);
        }
        if (first instanceof Integer && second instanceof Integer) {
            System.out.println((Integer) first * (Integer) second);
        }
    }
}
