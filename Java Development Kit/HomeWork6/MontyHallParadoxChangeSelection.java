import java.util.HashMap;
import java.util.Map;

public class MontyHallParadoxChangeSelection {

    Map<Integer, String> map = new HashMap<>();

    public MontyHallParadoxChangeSelection(){
        paradox();
    }
    private void paradox(){
        for (int i = 0; i < 1000; i++){
            int[] arr1 = getRandomArray();
            int choice = getChoice();
            int[] arr2 = getNewChoice(arr1, choice);
            if (arr2[1] == 1){
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
        System.out.printf("В парадоксе Монти Холла меняя изначальный выбор выиграл: %d раз, проиграл: %d раз" , win, lost);
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

    private  int[] getNewChoice(int[] arr, int choice){
        int[] array = new int[2];
        if (arr[choice] == 1){
            array[0] = 1;
        }else {
            array[1] = 1;
        }
        return array;
    }
}
