
import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
    1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
    2. Вилки лежат на столе между каждой парой ближайших философов.
    3. Каждый философ может либо есть, либо размышлять.
    4. Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
    5. Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
    6. Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
    Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
     */
    public static void main(String[] args) {

        Philosopher philosopher1 = new Philosopher("Аристотель");
        Philosopher philosopher2 = new Philosopher("Платон");
        Philosopher philosopher3 = new Philosopher("Пифагор");
        Philosopher philosopher4 = new Philosopher("Евклид");
        Philosopher philosopher5 = new Philosopher("Вассерман");

        philosopher1.setPhilosopher(philosopher2);
        philosopher2.setPhilosopher(philosopher3);
        philosopher3.setPhilosopher(philosopher4);
        philosopher4.setPhilosopher(philosopher5);
        philosopher5.setPhilosopher(philosopher1);


        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();



    }
}
