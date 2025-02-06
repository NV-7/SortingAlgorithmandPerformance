public class InsertionSort implements SortingAlgorithm {

    String name = "InsertionSort";

    @Override
    public int[] sorty(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int j = i;
            while (j > 0 && input[j] < input[j - 1]) {
                // Swap numbers[j] and numbers [j - 1]
                int temp = input[j];
                input[j] = input[j - 1];
                input[j - 1] = temp;
                j--;
            }
        }
        return  input;
    }

    public String getName() {
        return name;
    }
}
