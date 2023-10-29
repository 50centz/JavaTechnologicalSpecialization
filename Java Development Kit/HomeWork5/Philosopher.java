import java.util.Random;

public class Philosopher extends Thread{
    private volatile boolean fork;
    private String name;
    private boolean finish;
    private Philosopher philosopher;
    private Random random;

    public Philosopher(String name) {
        this.name = name;
    }

    public void setPhilosopher(Philosopher philosopher) {
        this.philosopher = philosopher;
        random = new Random();
    }

    @Override
    public void run() {
        int count = 3;
        while (!finish){
            if (fork == philosopher.getFork()){
                philosopher.setFork(true);
                eat();
                try {
                    sleep(random.nextInt(1, 10) * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                philosopher.setFork(false);
                count --;
            }else {
                thinks();
                try {
                    sleep(random.nextInt(1, 10) * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (count == 0){
                finish = true;
            }
        }
        System.out.println(name + ": я наелся и надумался ха-ха-ха");
    }

    public boolean getFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    private void eat(){
        System.out.println(name + ": обедает");
    }

    private void thinks(){
        System.out.println(name + ": размышляет");
    }
}
