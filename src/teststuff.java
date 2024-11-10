import java.util.ArrayList;

public class teststuff {

    static int hej = 5;

    static void changeValue(int xd){
        xd = 8;
    }

    static void addValue(ArrayList<Integer> arr2){
        arr2.add(75);
    }

    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args){
        int N = 19;
        int i = 3;
        int j = 7;
        int half = (N - j + i + 1) / 2;
        int counter = 0;
        while (counter < half) {
            counter++;
            System.out.println("i: " + (i % N + N) % N);
            System.out.println("j: " + j % N);
            i--;
            j++;
        }

    }


    static <T> void reverseList(T[] list, int i, int j){
        int size = list.length - 1;
        while(i < j){
            T temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            i++;
            j++;
        }
    }

    static void arrstuff(){
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(25);
        arr.add(47);

        System.out.println(arr.toString());
    }
}
