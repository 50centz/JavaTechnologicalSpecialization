package homework.sample;

import homework.regular.Decorator;
import homework.regular.OtherClass;

public class Main {
    public static void main(String[] args) {

        /**
         * javac -sourcepath ./java -d out java/ru/geekbrains/seminar1/sample/Main.java
         * java -classpath ./out ru.geekbrains.seminar1.sample.Main
         * javadoc -encoding utf8 -d docs -sourcepath ./java -cp ./out -subpackages ru
         *
         *
         * Dockerfile
         *
         * FROM bellsoft/liberica-openjdk-alpine:11.0.10
         *
         * COPY ./java ./src
         * RUN mkdir ./out
         * RUN javac -sourcepath ./src -d out src/ru/geekbrains/seminar1/sample/Main.java
         * CMD java -classpath ./out ru.geekbrains.seminar1.sample.Main
         *
         *
         *
         */

        int result = OtherClass.add(50, 50);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.sub(20, 25);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.mul(27, 2);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.div(26, 21);
        System.out.println(Decorator.decorator(result));
    }
}
