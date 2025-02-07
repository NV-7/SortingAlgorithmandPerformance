import org.jfree.data.xy.XYSeries;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Performance {
     String path;
     Tester tester;
     double average;
     SelectionSort selectionSort;
     BubbleSort bubbleSort;
     InsertionSort insertionSort;
     MergeSort mergeSort;
     QuickSort quickSort;
     ShellSort shellSort;
     FileWriter writer;
     static XYSeries sortSeries;
     static XYchart xyChart = new XYchart("Sorting Runtimes", "Sorting Runtimes");
     static XYchart xyChartKver = new XYchart("Sorting Runtimes KVer", "Sorting Runtimes KVer");

    public Performance(String filePath){
        path = filePath;
    }
    public FileWriter initWriter(String name){
        {
            try {
                writer = new FileWriter(path + name, true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return writer;
    }

    public void closeWriter() throws IOException {
        writer.close();
    }
    public void createFile(String name) throws IOException {
        File results = new File(path + "name");
         results.createNewFile();
    }
    public void writeResultOf20(int size) throws IOException {
        tester.test(20, size);
        average = tester.getAverage();
        sortSeries.add(size, average);
        writer.write("Sorted " +size+ " elements in " + average +" ms (avg)" + "\n");
    }
    public  void writeResultOf20KVer(int size) throws IOException {
        tester.testKVer(20, size);
        average = tester.getAverage();
        sortSeries.add(size, average);
        writer.write("Sorted " +size+ " elements in " + average +" ms (avg)" + "\n");
    }
    public void perform(int[] sizes, SortingAlgorithm[] sa) throws IOException {
        String name;
        createFile("Results");
        writer = initWriter("Results");
        int i = 0;
        int j = 0;
        while (i < sa.length) {
            sortSeries = new XYSeries(sa[i].getClass().getName());
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
        File jpeg = new File("ChartJpeg");
        //xyChart.saveJpeg(jpeg);
        xyChart.pack();
        xyChart.setVisible(true);
        writer.close();

    }
    public  void performKVer(int[] sizes, SortingAlgorithm[] sa) throws IOException {
        String name;
        createFile("ResultsKVer");
        writer = initWriter("ResultsKVer");
        int i = 0;
        int j = 0;
        while (i < sa.length) {
            sortSeries = new XYSeries(sa[i].getClass().getName());
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
        writer.close();

    }

    public static void main(String[] args) throws IOException {

        SelectionSort selectionSort = new SelectionSort();
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        ShellSort shellSort = new ShellSort();
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
       // String[] names = {"SelectionSort", "BubbleSort", "InserionSort", "MergeSort", "QuickSort", "ShellSort"};
        SortingAlgorithm[] sa = {selectionSort, bubbleSort, insertionSort, mergeSort, quickSort, shellSort};


        Performance perform =  new Performance("C:\\Users\\Tommy\\IdeaProjects\\Assigment 2 Sorting Algo\\");
        perform.perform(sizes, sa);
        perform.performKVer(sizes, sa);
        perform.closeWriter();
    }
}
