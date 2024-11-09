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
        arr.add(5);

        ArrayList<Integer> barr = arr;

        barr.remove(barr.size() -1);

        System.out.println(arr);


    }

    static void arrstuff(){
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(25);
        arr.add(47);

        System.out.println(arr.toString());
    }
}
