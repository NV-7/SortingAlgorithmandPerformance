import org.jfree.data.xy.XYSeries;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Performance {
    static File results;
    static Tester tester;
    static double average;
    static SelectionSort selectionSort = new SelectionSort();
    static BubbleSort bubbleSort = new BubbleSort();
    static InsertionSort insertionSort = new InsertionSort();
    static MergeSort mergeSort = new MergeSort();
    static QuickSort quickSort = new QuickSort();
    static ShellSort shellSort = new ShellSort();
    static FileWriter writer;
    static XYSeries sortSeries;
    static XYchart xyChart = new XYchart("Sorting Runtimes", "Sorting Runtimes");
    static XYchart xyChartKver = new XYchart("Sorting Runtimes KVer", "Sorting Runtimes KVer");


    // Store to C:\Users\Tommy\Documents\AlgorthmResults



    public static void writeResultOf20(int size) throws IOException {
        tester.test(20, size);
        average = tester.getAverage();
        sortSeries.add(size, average);
        writer.write("Sorted " +size+ " elements in " + average +" ms (avg)" + "\n");
    }
    public static void writeResultOf20KVer(int size) throws IOException {
        tester.testKVer(20, size);
        average = tester.getAverage();
        sortSeries.add(size, average);
        writer.write("Sorted " +size+ " elements in " + average +" ms (avg)" + "\n");
    }
    public static void perform(int[] sizes, SortingAlgorithm[] sa, String[] names) throws IOException {
        String name;
        int i = 0;
        int j = 0;
        while (i < sa.length) {
            sortSeries = new XYSeries(names[i]);
            name = sa[i].getClass().getName();
            writer.write("Sorting Algorithm - " + name + "\n");
            System.out.println(i + "outer");
            while (j < sizes.length) {
                tester = new Tester(sa[i]);
                writeResultOf20(sizes[j]);
                j++;
            }
            xyChart.addToCollection(sortSeries);
            j = 0;
            i++;
            writer.write("\n");
        }
        xyChart.pack();
        xyChart.setVisible(true);

    }
    public static void performKVer(int[] sizes, SortingAlgorithm[] sa, String[] names) throws IOException {
        String name;
        int i = 0;
        int j = 0;
        while (i < sa.length) {
            sortSeries = new XYSeries(names[i]);
            name = sa[i].getClass().getName();
            writer.write("Sorting Algorithm - " + name + "\n");
            System.out.println(i + "outer");
            while (j < sizes.length) {
                tester = new Tester(sa[i]);
                writeResultOf20KVer(sizes[j]);
                j++;
            }
            xyChartKver.addToCollection(sortSeries);
            j = 0;
            i++;
            writer.write("\n");
        }
        xyChart.pack();
        xyChartKver.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        {
            try {
                writer = new FileWriter("C:\\Users\\Tommy\\Documents\\AlgorthmResults\\results3.txt", true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        String[] names = {"SelectionSort", "BubbleSort", "InserionSort", "MergeSort", "QuickSort", "ShellSort"};
        SortingAlgorithm[] sa = {selectionSort, bubbleSort, insertionSort, mergeSort, quickSort, shellSort};
        perform(sizes, sa,names);
        performKVer(sizes, sa,names);
        writer.close();
    }
}
