import java.util.HashMap;
import java.util.Map;

public class MontyHallParadox {
    Map<Integer, String> map = new HashMap<>();


    public MontyHallParadox(){
        paradox();
    }
    private void paradox(){
        for (int i = 0; i < 1000; i++){
            int[] arr = getRandomArray();
            int choice = getChoice();
            if (arr[choice] == 1){
                map.put(i, "Win");
            }else {
                map.put(i, "Lost");
            }
        }
        int win = 0;
        int lost = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals("Win")){
                win++;
            }else {
                lost++;
            }
        }
        System.out.printf("В парадоксе Монти Холла не меняя изначальный выбор выиграл: %d раз, проиграл: %d раз" , win, lost);
    }

    private int[] getRandomArray(){
        int[] arr = new int[3];
        int number = (int) (Math.random() * 3);
        arr[number] = 1;
        return arr;
    }

    private int getChoice(){
        int choice = (int) (Math.random() * 3);
        return choice;
    }
}
