import java.util.*;

/**
  *	Name: 	   Miguel Angel Galan   <BR>
  *	Course:	   4002-218-01       	<BR>
  *	Homework:	#6, Vehicle    		<BR>
  *	Date:	      10/22/18       		<BR>
  *<BR>
  *	Class:	   Truck     			<BR>
  *	Purpose:	   This class extends from vehicle class and uses
  *               its methods to gather informtion for this truck.
  *               The constructor uses a parameter to determine
  *               the prompt for the vehicle and calls the vehicle
  *               constructor along with the show menu method. It
  *               also has two getters and a string formater for
  *               a display of the gathered information. 
  *			                           <BR>
  *                                    <BR>
  *	@author Miguel Angel Galan
  *	@version 3.0				
  *	@see Vehicle
  */

public class Truck extends Vehicle {
   private int chosenSize, chosenEngineSize;
   final static String VEHICLE_IS = "Truck";
   final private String sizeOfTruckPrompt = "What size is this truck? ";
   final private String engineSizePrompt = "What is the engine size of the truck? ";
   final static private String [ ] truckSizes = new String [ ]{"Half-Ton", "Full-Ton"};
   final static private String [ ] engineSizes = new String [ ]{"1500", "150"};   
   
   
   /**
     * Constructor method calls on other methods to 
     * request user information from vehicle class.        <BR>
     * <BR> 
     * @param  option is used to determine which prompt to display 
     */
   public Truck(){
      super(VEHICLE_IS); 
      chosenSize = showMenu(sizeOfTruckPrompt, truckSizes); 
      chosenEngineSize = showMenu(engineSizePrompt, engineSizes);  
   }
       
   /**
     * toString method formats the gathered information and
     * returned to the class that called it. Such as model,
     * color, cost, truck size and engine size of vehicle.
     *        <BR>
     * <BR> 
     * @return  Formated string of the gathered information. 
     */  
   public String toString( ){
      return String.format("%s %14s%-15s\n %14s%-15s\n", 
               super.toString( ), "Load: ", getTruckSize( ),
               "Engine: ", getTruckEngineSize( ));
   }
    
   /**
     * Accessor method to receive the engine of truck.
     *        <BR>
     * <BR> 
     * @return  String of the engine size. 
     */   
   public String getTruckEngineSize( ){
      return engineSizes[chosenEngineSize];
   }
   
   /**
     * Accessor method to receive the truck size.
     *        <BR>
     * <BR> 
     * @return  String of the truck size. 
     */     
   public String getTruckSize( ){
      return truckSizes[chosenSize];
   }
   
   /**
     * Accessor method to receive the gas milage using interface VInfo.
     *        <BR>
     * <BR> 
     * @return  double of the gas mileage. 
     */
   public double gasMileage( ){
      double truckMileage = 0;
      truckMileage = 50 - (Math.sqrt(getCost( ))/10.0);
      return truckMileage;
   }    
    
}//end of public class truck    
