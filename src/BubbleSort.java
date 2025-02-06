public class BubbleSort implements SortingAlgorithm{
String name = "BubbleSort";
    @Override
    public int[] sorty(int[] input) {
        int temp = 0;
        int length = input.length;

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length -i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                }
            }
        }

        return input;
    }

    public String getName() {
        return name;
    }
}
