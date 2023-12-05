package task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Animal[] animals = new Animal[6];
        Cat cat1 = new Cat("Pushok", 5);
        Cat cat2 = new Cat("Zefir", 3);
        Cat cat3 = new Cat("Rizhik", 7);

        Dog dog1 = new Dog("Sharik", 5);
        Dog dog2 = new Dog("Pirat", 9);
        Dog dog3 = new Dog("Baget", 3);

        animals[0] = cat1;
        animals[1] = cat2;
        animals[2] = cat3;
        animals[3] = dog1;
        animals[4] = dog2;
        animals[5] = dog3;



        for (Animal a : animals) {
            Class<?> clazz = a.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields){
                field.setAccessible(true);
                System.out.printf("%s: %s\n", field.getName(), field.get(a));

            }

            try{
                Method method = clazz.getDeclaredMethod("makeSound");
                method.invoke(a);
            }catch (NoSuchMethodException | InvocationTargetException e){

            }

            System.out.println();
        }

    }
}
