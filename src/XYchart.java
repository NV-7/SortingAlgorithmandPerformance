import java.awt.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
public class XYchart  extends  ApplicationFrame{

    private XYSeriesCollection dataSet = new XYSeriesCollection();

    public XYchart(String appTitile, String charTitle) {
        super(appTitile);
        JFreeChart xyChart = ChartFactory.createXYLineChart(charTitle,"Number of Inputs - N",
                "Average sort time",dataSet,PlotOrientation.VERTICAL,true,true,false );

        ChartPanel panel = new ChartPanel(xyChart);
        panel.setPreferredSize(new java.awt.Dimension(1000,600 ));
        XYPlot plot = xyChart.getXYPlot();
        renderChart(plot, panel);
    }


    public void renderChart(XYPlot plot, ChartPanel panel){
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setSeriesPaint(0, Color.green);
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(0, Color.yellow);
        renderer.setSeriesPaint(0, Color.PINK);
        renderer.setSeriesPaint(0, Color.orange);
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 3 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 4 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 5 , new BasicStroke( 4.0f ) );
        plot.setRenderer(renderer);
        setContentPane(panel);


    }
  public void addToCollection(XYSeries sortSeries){
        dataSet.addSeries(sortSeries);
  }
}

