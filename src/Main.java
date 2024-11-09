import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static Kattio io;

    private static void greedyTSPArray(int N, int startNode) {

        boolean[] used = new boolean[N];


        for (int i = 0; i < N; i++) {
            used[i] = false;
        }

        ArrayList<Integer> path = new ArrayList<>();

        double xStart = cords[startNode][0];
        double yStart = cords[startNode][1];
        int current = 0;
        path.add(startNode);
        used[startNode] = true;


        double pathCost = 0;
        for (int i = 0; i < N - 1; i++) {
            double dist = Double.MAX_VALUE;
            pathCost = 0;
            for (int j = 0; j < N; j++) {
                if (used[j]) continue;
                double newDist = Double.min(dist, Math.sqrt(Math.pow((xStart - cords[j][0]), 2) + Math.pow((yStart - cords[j][1]), 2)));
                if (dist > newDist) {
                    current = j;
                    dist = newDist;
                }

            }
            xStart = cords[current][0];
            yStart = cords[current][1];
            used[current] = true;
            pathCost += dist;
            //System.out.println(current);
            path.add(current);

        }
        if (pathCost < globalMinCost){
            globalMinCost = pathCost;
            thePath = new ArrayList<>(path);
        }

    }

    static double[][] cords;

    static HashMap<String, Double> map = new HashMap<>();

    static List<Integer> thePath;

    private static double exhaustiveTSP(List<Integer> nodes, List<Integer> path, double cost) {
        if (nodes.isEmpty()) { // Complete the cycle by returning to the starting node
            if(cost < globalMinCost){
                globalMinCost = cost;
                thePath = new ArrayList<>(path);
            }
            return cost;
        }

        if(cost >= globalMinCost) return cost;

        String key = path.get(path.size() - 1) + ":" + listToString(nodes);
        if(map.containsKey(key)){
            return map.get(key);
        }

        double minCost = Double.MAX_VALUE;
        for (int i = 0; i < nodes.size(); i++) {
            int node = nodes.remove(i);
            key = listToString(path) + ":" + node;
            path.add(node);
            double tempCost = cost + distance(node, path.get(path.size() - 2));
            minCost = Math.min(minCost, exhaustiveTSP(nodes, path, tempCost));
            map.put(key, tempCost);
            path.remove(path.size() - 1);
            nodes.add(i, node);
        }

        return minCost;
    }

    static double distance(int i, int j){
        return Math.sqrt(Math.pow((cords[i][0] - cords[j][0]), 2)
                + Math.pow((cords[i][1] - cords[j][1]), 2));
    }

    static double globalMinCost = Double.MAX_VALUE;

    private static double exhaustiveTSP(int N, List<Integer> nodes){
        for(int i = 0; i < N; i++){
            int node = nodes.remove(i);
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(node);
            globalMinCost = Math.min(globalMinCost, exhaustiveTSP(nodes, arr, 0));
            nodes.add(i, node);
        }
        return globalMinCost;
    }

    static String listToString(List<Integer> list){
        StringBuilder str = new StringBuilder();
        //str.append(list.get(0));
        for(int i : list){
            str.append(i);
            str.append(":");
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    void readNodes(int N){
        cords = new double[N][2];
        for(int i = 0; i < N; i++){
            cords[i][0] = io.getDouble();
            cords[i][1] = io.getDouble();
            nodes.add(i);
        }
    }

    ArrayList<Integer>  nodes = new ArrayList<>();

    void subExhaustiveTSP(int N, ArrayList<Integer> nodes){
        //divide them into subgroups and to exhaustive search on the subgroups
        sortCords();
        double[][] temp = cords;



        for(int i = 0; i < (N/10); i++){

        }

    }

    static void printCords(){
        for(int i = 0; i  < cords.length; i++){
            System.out.println(cords[i][0] + " " + cords[i][1]);
        }
    }

    static void sortCords(){
        Arrays.sort(cords, Comparator.comparingDouble(a -> a[0]));
    }


    void greedyTSPArray(){

    }

    Main(){
        long startTime = System.currentTimeMillis();
        io = new Kattio(System.in, System.out);
        int N = io.getInt();

        readNodes(N);

        if(N <= 00) {
            exhaustiveTSP(N, nodes);
        }
        else if(N <= 00) subExhaustiveTSP(N, nodes);
        else {
            for(int i = 0; i < N; i++){
                greedyTSPArray(N, i);
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                if(elapsedTime > 1900) break;
            }
        }

        for(int node : thePath){
            System.out.println(node);
        }

    }

    public static void main(String[] args) {
        new Main();
    }
}