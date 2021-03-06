package in.nit.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtil {
  public void generatePie(String path,List<Object[]> data) {
    //1.create data set
	  DefaultPieDataset dataset=new DefaultPieDataset();
	  for(Object[] arr:data) {
		  //key-shipMode,val-count
		  dataset.setValue(arr[0].toString(),
				  Double.valueOf(arr[1].toString()));
	  }
	  //2.create jfree chart using chartbfactory
	  JFreeChart chart=ChartFactory.createPieChart3D("ShipmentTypeModes", dataset, true, true,false);
	  //3.save as image using chartUtils
	  try {
		  ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipmentA.png"), chart, 400, 400);
		   } catch(IOException e) {
			   e.printStackTrace();
		   }
  }
  public void generateBar(String path,List<Object[]> data) {
	  //1.create dataset
	DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	 for(Object[] arr:data) {
		 //val-index-1(y-axis),key-index-0(x-axis)
		dataset.setValue(Double.valueOf(arr[1].toString()),arr[0].toString()," ");
	 }
   //create jfree chart using chart factory
	 JFreeChart chart=ChartFactory.createBarChart("ShipmentTypeMode","Modes","COUNT",dataset);
	 //3.save as image using chartutil
	   try {
		   ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipmentB.png"),chart,400,400);
		   
	   } catch(IOException e) {
		   e.printStackTrace();
	   }
	 
  }
}
