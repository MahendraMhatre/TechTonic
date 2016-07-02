import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart_AWT extends ApplicationFrame
{
	 Tracker tracker;
   public BarChart_AWT( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
     
      tracker  = new Tracker();
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Days",            
         "Calories",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 560 ) );    
   
      setContentPane( chartPanel ); 
   }
   private CategoryDataset createDataset( )
   {
      final String calorie = "Calories";        
         
      final String Monday = "Monday";        
      final String Tuesday = "Tuesday";        
      final String Wednesday = "Wednesday";        
      final String Thursday = "Thursday";   
      final String Friday = "Friday"; 
      final String Saturday = "Saturday";
      final String Sunday = "Sunday";
      int x[] = {0,0,0,0,0,0,0,0};
      x = tracker.query123("", "");
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( x[6] , calorie , Monday );        
      dataset.addValue( x[5], calorie , Tuesday );        
      dataset.addValue( x[4] , calorie , Wednesday ); 
      dataset.addValue(x[3] , calorie , Thursday );    
      dataset.addValue(x[2] , calorie , Friday );    
      dataset.addValue(x[1] , calorie , Saturday );    
      dataset.addValue(x[0] , calorie , Sunday );    
       
      return dataset; 
   }
   public static void main( String[ ] args )
   {
      BarChart_AWT chart = new BarChart_AWT("Calorie Statistics", "Weekly Calorie Consumption Stats");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}