import org.jfree.data.xy.XYSeries;
public class dataSeries {

    XYSeries series;
    public dataSeries(String name){
        series = new XYSeries(name);
    }

    public void addData(int inputSize, double avg){
        series.add(inputSize, avg);
    }

    public XYSeries getSeries() {
        return series;
    }
}
