package com.aspose.slides.examples.Slides.Charts;

import com.aspose.slides.ChartType;
import com.aspose.slides.IChart;
import com.aspose.slides.IChartDataWorkbook;
import com.aspose.slides.IChartSeries;
import com.aspose.slides.ISlide;
import com.aspose.slides.MarkerStyleType;
import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;
import com.aspose.slides.examples.Utils;

public class CreatingScatteredChartWithMultipleSeriesAndDifferentSeriesMarkers {

	public static void main(String[] args) {
//ExStart:CreatingScatteredChartWithMultipleSeriesAndDifferentSeriesMarkers

		
		// The path to the documents directory.
	    	String dataDir = Utils.getDataDir(CreatingScatteredChartWithMultipleSeriesAndDifferentSeriesMarkers.class);
	    
		// Instantiate Presentation class that represents PPTX file
		Presentation pres = new Presentation();
		
		// Access first slide
		ISlide slide = pres.getSlides().get_Item(0);

		// Creating the default chart
		IChart chart = slide.getShapes().addChart(ChartType.ScatterWithSmoothLines, 0, 0, 400, 400);

		// Getting the default chart data worksheet index
		int defaultWorksheetIndex = 0;

		// Getting the chart data worksheet
		IChartDataWorkbook fact = chart.getChartData().getChartDataWorkbook();

		// Delete demo series
		chart.getChartData().getSeries().clear();

		// Add new series
		chart.getChartData().getSeries().add(fact.getCell(defaultWorksheetIndex, 1, 1, "Series 1"), chart.getType());
		chart.getChartData().getSeries().add(fact.getCell(defaultWorksheetIndex, 1, 3, "Series 2"), chart.getType());

		// Take first chart series
		IChartSeries series = chart.getChartData().getSeries().get_Item(0);

		// Add new point (1:3) there.
		series.getDataPoints().addDataPointForScatterSeries(fact.getCell(defaultWorksheetIndex, 2, 1, 1), fact.getCell(defaultWorksheetIndex, 2, 2, 3));

		// Add new point (2:10)
		series.getDataPoints().addDataPointForScatterSeries(fact.getCell(defaultWorksheetIndex, 3, 1, 2), fact.getCell(defaultWorksheetIndex, 3, 2, 10));

		// Edit the type of series
		series.setType(ChartType.ScatterWithStraightLinesAndMarkers);

		// Changing the chart series marker
		series.getMarker().setSize(10);
		series.getMarker().setSymbol(MarkerStyleType.Star);

		// Take second chart series
		series = chart.getChartData().getSeries().get_Item(1);

		// Add new point (5:2) there.
		series.getDataPoints().addDataPointForScatterSeries(fact.getCell(defaultWorksheetIndex, 2, 3, 5), fact.getCell(defaultWorksheetIndex, 2, 4, 2));

		// Add new point (3:1)
		series.getDataPoints().addDataPointForScatterSeries(fact.getCell(defaultWorksheetIndex, 3, 3, 3), fact.getCell(defaultWorksheetIndex, 3, 4, 1));

		// Add new point (2:2)
		series.getDataPoints().addDataPointForScatterSeries(fact.getCell(defaultWorksheetIndex, 4, 3, 2), fact.getCell(defaultWorksheetIndex, 4, 4, 2));

		// Add new point (5:1)
		series.getDataPoints().addDataPointForScatterSeries(fact.getCell(defaultWorksheetIndex, 5, 3, 5), fact.getCell(defaultWorksheetIndex, 5, 4, 1));

		// Changing the chart series marker
		series.getMarker().setSize(10);
		series.getMarker().setSymbol(MarkerStyleType.Circle);
		// Save presentation with chart
		pres.save(dataDir + "AsposeScatterChart.pptx", SaveFormat.Pptx);

//ExEnd:CreatingScatteredChartWithMultipleSeriesAndDifferentSeriesMarkers

	}

}
