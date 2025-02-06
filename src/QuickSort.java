public class QuickSort implements SortingAlgorithm{

    String name = "Quicksort";

    @Override
    public int[] sorty(int[] input) {

        quickSort(input, 0, input.length -1);
        return input;
    }

    public int partition(int[] input, int beg, int last){

        int pivot = input[last];
        int temp =  0;
        int j = beg - 1;

        for(int i = beg; i < last; i++){
            if(input[i] <= pivot){
                j++;
                temp = input[j];
                input[j] = input[i];
                input[i] = temp;

            }
        }

        temp = input[j + 1];
        input[j + 1] = input[last];
        input[last] = temp;
        return j + 1;
    }

    public void quickSort(int[] input, int beg, int last){
     if(beg < last){

         int partiion = partition(input, beg, last);

         quickSort(input, beg, partiion -1);

         quickSort(input, partiion + 1, last);
     }

    }

    public String getName() {
        return name;
    }
}
