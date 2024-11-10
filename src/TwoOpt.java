

public class TwoOpt {
    final int N;
    double[][] cords;

    TwoOpt(int N, double[][] cords){
        this.N = N;
        this.cords = new double[cords.length][3];

        for(int i = 0; i < N; i++){
            this.cords[i][0] = cords[i][0];
            this.cords[i][1] = cords[i][1];
            this.cords[i][2] = i;
        }

        //Arrays.sort(this.cords, Comparator.comparingDouble(o -> o[0]));
    }

    private boolean twoOpt(int i, int j){

        double a = -(dist(cords[i], cords[i + 1]) + dist(cords[j], cords[(j + 1) % N]));
        double b = dist(cords[i], cords[j]) + dist(cords[i + 1], cords[(j + 1) % N]);
        double lengthDelta = a + b;
        if (lengthDelta >= 0) return false;

        //if the j to i is shorter (n/2 TO instead of n
        if(j - i > N / 2) shortSwap(i, j);
        //else normal swap
        else
            swap(i, j);
        return true;
    }


    //not sure if this is faster, depends on how much mod operation costs.
    //TODO benchmark mod (assumption division operation -> slow)
    private void shortSwap(int i, int j){
        int half = (N - j + i + 1) / 2;
        int counter = 0;
        while (counter < half) {
            counter++;
            i = (i % N + N) % N;
            j = j % N;
            double[] temp = cords[i];
            cords[i] = cords[j];
            cords[j] = temp;
            i--;
            j++;
        }
    }

    //swap i and j, and the elements in between them so that the elements are in correct order.
    private void swap(int i, int j){
        i += 1;
        while(i < j){
            double[] temp = cords[i];
            cords[i] = cords[j];
            cords[j] = temp;
            i++;
            j--;
        }
    }

    //calculates the Euclidean distance between two points.
    private double dist(double[] a, double[] b){
        double xDist = a[0] - b[0];
        double yDist = a[1] - b[1];
        return Math.sqrt(xDist * xDist + yDist * yDist);
    }

    public void start(long startTime){
        boolean changed = true;
        while(changed) {
            changed = false;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 2; j < N; j++) {
                    if(twoOpt(i, j)) changed = true;
                }
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            if(elapsedTime > 1800) break;
        }

    }
    public void printPath(Kattio io){
        double longestDist = -1;
        int index = -1;
        for(int i = 0; i < N; i++){
            double temp = dist(cords[i], cords[(i + 1) %N]);
            if(longestDist < temp){
                longestDist = temp;
                index = i;
            }
        }

        for(int i = index; i < N; i++){
            //io.println(cords[i][2]);
            System.out.println((int)cords[i][2]);
        }

        for(int i = 0; i < index; i++){
            //io.println(cords[i][2]);
            System.out.println((int)cords[i][2]);
        }

    }

}
