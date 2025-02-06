
public class Main {
    public static void main(String[] args) {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        SelectionSort selectionSort = new SelectionSort();
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        ShellSort shellSort = new ShellSort();
    Tester tester = new Tester(selectionSort);

       for(int x: mergeSort.sorty(input)){
           System.out.println(x);
       }

       System.out.println(tester.singleTest(75000));
        System.out.println("Hello, World!");
    }
}