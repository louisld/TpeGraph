package fr.bloome.tpegraph;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Main {
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\louis\\Documents\\Ambicitil_1d8cb0f9_2016-10-24-21-56-45.csv");
		CvsFileReader reader = new CvsFileReader(file);
		
		//Temp Arrays
		List<String[] > data = reader.getData();
		ArrayList<String> col2 = new ArrayList<String>();
		ArrayList<String> col5 = new ArrayList<String>();
		
		//Array for time and decibel
		ArrayList<Double> timeFromStart = new ArrayList<Double>();
		ArrayList<Float> decibel = new ArrayList<Float>();
		
		XYSeries ligne6 = new XYSeries("Ligne 6");
		XYSeriesCollection collection = new XYSeriesCollection();
		
		for(String[] lines : data){
			col2.add(lines[1]);
			col5.add(lines[4]);
		}
		
		//Removing cols names and reversing the arrays
		col2.remove(0);
		col5.remove(0);
		Collections.reverse(col2);
		Collections.reverse(col5);
		
		double minTime = Double.parseDouble(col2.get(0).replaceAll("\"", ""));
		
		//Fill the arrays
		for(String str : col2){
			timeFromStart.add(Double.parseDouble(str.replaceAll("\"", "")) - minTime);
		}
		for(String str : col5){
			decibel.add(Float.parseFloat(str.replaceAll("\"", "")));
		}
		
		//Fill XY series
		for(int i=0;i<decibel.size();i++){
			ligne6.add(timeFromStart.get(i), decibel.get(i));
		}
		collection.addSeries(ligne6);
		
		JFreeChart chart = ChartFactory.createXYLineChart(
				"Niveau sonore des lignes de métro",      // chart title
				"Seconde",                      // x axis label
				"Décibel",                      // y axis label
				collection,                  // data
				PlotOrientation.VERTICAL,
				true,                     // include legend
				true,                     // tooltips
				false                     // urls
				);
		MainWindow window = new MainWindow(chart);
	}

}
