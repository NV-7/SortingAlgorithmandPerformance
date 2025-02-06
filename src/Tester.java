import java.util.Random;

public class Tester {

    private Random ran = new Random();
    SortingAlgorithm sa;
    double average;
    int[] input;

    public Tester(SortingAlgorithm sa){
        this.sa = sa;
    }

    public double singleTest(int size){
       long timeS = System.nanoTime();
         input = new int[size];

        for(int i = 0; i < size; i++){
            input[i] = ran.nextInt();
        }
        long timeE = System.nanoTime();

        long timeStart = System.nanoTime();
        sa.sorty(input);
        long timeEnd = System.nanoTime();

        return (double) ((timeEnd - timeStart)/1000000);
    }
    public double singleTestKVer(int size){

        input = new int[size];

        for(int i = 0; i < size; i++){
            input[i] = ran.nextInt();
        }

        input = generateKSorted(input);
        long timeStart = System.nanoTime();
        sa.sorty(input);
        long timeEnd = System.nanoTime();

        return (double) ((timeEnd - timeStart)/1000000);
    }

    public void test(int iterations, int size){
        double[] results = new double[iterations];
        int total = 0;
        for(int i = 0; i< iterations; i++){
            results[i] = singleTest(size);
        }
        for(double x: results){
            total += x;
        }
        average = total/iterations;
        System.out.println(total/iterations);
    }

    public void testKVer(int iterations, int size){
        double[] results = new double[iterations];
        int total = 0;
        for(int i = 0; i< iterations; i++){
            results[i] = singleTestKVer(size);
        }
        for(double x: results){
            total += x;
        }
        average = total/iterations;
        System.out.println(total/iterations);
    }

    public int[] generateKSorted(int[] input){
        int size = input.length;

        for(int gap = size /10; gap > 0; gap = 0) {
            for(int i = gap; i < size; i++){
                int temp = input[i];
                int j;
                for( j = i; j >= gap && input[j - gap] > temp; j-= gap){
                    input[j] = input[j -gap];
                }
                input[j] = temp;
            }

        }
        return input;
    }

    public double getAverage() {
        return average;
    }
}
