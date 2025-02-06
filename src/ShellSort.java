public class ShellSort implements SortingAlgorithm{

    String name = "ShellSort";

    @Override
    public int[] sorty(int[] input) {

        int size = input.length;

        for(int gap = input.length /2; gap > 0; gap = gap/2)
        {
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

    public String getName() {
        return name;
    }
}
