package newPromoCalc.miller;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class lastYearGraph {
	
	public static int[] importPoints;
	public static int[] importUserPoints;
	public static int mosSelection;
	
	public static void importSelection (int y, int [] z, BufferedReader f) {
		mosSelection = y;
		importUserPoints = z;
		try {
			importPoints = parseCSVFile (mosSelection, f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}	
	public static int [] parseCSVFile (int mos, BufferedReader buff) throws FileNotFoundException {
		
		Scanner findLine = new Scanner(buff);
		
		int [] primeParser1 = new int[24];
		
		int matchMOScounter = 1; //Matches line to MOS
		String temp = null;
		String passer = null;
		// NEED TO WRITE THE CONDITIONS		
		
		while (findLine.hasNextLine()) {
			
			if (matchMOScounter == mos) {
				temp = findLine.nextLine();
				String[] tempArray = temp.split(",");
				for (int i = 0; i<24; i++) {
					primeParser1[i] = Integer.parseInt(tempArray[i]);
				}
				for (int i=0; i<24;i++) {
				}
				break;							
			}
			passer = findLine.nextLine();
			matchMOScounter++;
		}
		findLine.close();
		return primeParser1;
		
	}
	
	public Intent getIntent(Context context) {
		
		// This is the int array that spans the X axis, it will be called in every time series so the X is always the same
		int[] XPERM = {-11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0};
		
		//Turns the values into a series object, which is read by the chart maker
		
		//Adds the Primary Zone Points
		
		// Adding prime Parser instead of importSgtPoints
		int xCarry = 0;
		TimeSeries sgtPrimary = new TimeSeries("Primary");
		for (int i = 0; i < importPoints.length; i+=2) {
			sgtPrimary.add(XPERM[xCarry], importPoints[i]);
			xCarry++;
		}
		xCarry = 0;
		
		//Adds the Secondary Zone Points
		TimeSeries sgtSecondary = new TimeSeries("Secondary");
		for (int i = 1; i < importPoints.length; i+=2) {
			sgtSecondary.add(XPERM[xCarry], importPoints[i]);
			xCarry++;
		}
		xCarry = 0;
		
		//Adds the users Promotion Points
		TimeSeries user = new TimeSeries("Your Points");
		for (int i = 0; i <XPERM.length; i++) {
			user.add(XPERM[i], importUserPoints[i]);
		}
		
		
		//Takes the series object and turns it into a dataset, there is one per line
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(sgtPrimary);
		dataset.addSeries(sgtSecondary);
		dataset.addSeries(user);
		
		// Allows you to adjust the properties of a specific line or series
		
		//Draws the Primary Zone Points on the graph
		XYSeriesRenderer primRenderer = new XYSeriesRenderer();
		primRenderer.setColor(Color.GREEN);
		primRenderer.setPointStyle(PointStyle.DIAMOND);
		primRenderer.setFillPoints(true);
		
		//Draws the Secondary Zone Points on the graph
		XYSeriesRenderer secRenderer = new XYSeriesRenderer();
		secRenderer.setColor(Color.YELLOW);
		secRenderer.setPointStyle(PointStyle.SQUARE);
		secRenderer.setFillPoints(true);
		
		//Draws the Users Promotion Points on the graph
		XYSeriesRenderer userRenderer = new XYSeriesRenderer();
		userRenderer.setColor(Color.RED);
		userRenderer.setPointStyle(PointStyle.CIRCLE);
		userRenderer.setFillPoints(false);
		
		
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		mRenderer.addSeriesRenderer(primRenderer);
		mRenderer.addSeriesRenderer(secRenderer);
		mRenderer.addSeriesRenderer(userRenderer);
		mRenderer.setChartTitle("Points History - Last Year");
		mRenderer.setXTitle("Months - Scroll to View All Data");
		mRenderer.setYTitle("Points");
		mRenderer.setXLabels(12);
		mRenderer.setYLabels(9);
		mRenderer.setYAxisMax(800);
		mRenderer.setYAxisMin(0);
		
		
		Intent intent = ChartFactory.getLineChartIntent(context,  dataset, mRenderer, "Points History - Last Year");
		return intent;
		
	}

}
