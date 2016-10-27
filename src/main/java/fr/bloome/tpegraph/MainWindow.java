package fr.bloome.tpegraph;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class MainWindow extends JFrame {
	public MainWindow(JFreeChart chart){
		this.setTitle("TpeGraph");
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new java.awt.Dimension(500, 300));
		this.setContentPane(panel);
		this.setVisible(true);
	}
}
