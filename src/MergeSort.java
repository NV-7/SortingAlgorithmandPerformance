public class MergeSort implements SortingAlgorithm{

    String name = "MergeSort";

    @Override
    public int[] sorty(int[] input) {

        mergeSort(input, 0, input.length -1);
        return input;
    }

    public void merge(int[] input, int beg, int last, int mid){

        int leftSize, rightSize;
        int[] left, right;
        leftSize = mid - beg + 1;
        rightSize = last - mid;
        left = new int[leftSize];
        right = new int[rightSize];

        for(int i = 0; i < leftSize ; i++){
            left[i] = input[beg + i];
        }
        for(int i = 0; i < rightSize ; i++){
            right[i] = input[mid + 1 + i];
        }

        int i, j, k;
        i = 0;
        j = 0;
        k = beg;

        while(i < leftSize && j < rightSize){
            if(left[i] <= right[j]){
                input[k] = left[i];
                i++;
            }
            else {
            input[k] = right[j];
            j++;
            }
            k++;
        }
        while(i < leftSize){
            input[k] = left[i];
            i++;
            k++;
        }
        while(j < rightSize){
            input[k] = right[j];
            j++;
            k++;
        }


    }

    public void mergeSort(int[] input, int beg, int last){
        if(beg < last){

            int mid = (beg + last)/2;
            mergeSort(input, beg, mid);
            mergeSort(input, mid +1, last);

            merge(input, beg, last, mid);
        }
    }

    public String getName() {
        return name;
    }
}
