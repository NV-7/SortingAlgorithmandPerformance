public class SelectionSort implements SortingAlgorithm{
String name = "SelectionSort";
    @Override
    public int[] sorty(int[] input) {

        int j = 0;
        int temp = 0;

        for(int i = 0; i < input.length -1; i++){
            for(j = i + 1; j < input.length; j++){

                if(input[i] < input[j] ){
                    temp = input[i];
                    input[i] = input[j];
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
