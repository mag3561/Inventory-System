/**
  *	Name: 	   Miguel Angel Galan   <BR>
  *	Course:	   4002-218-01       	<BR>
  *	Homework:	#6, Vehicle    		<BR>
  *	Date:	      10/22/18       		<BR>
  *<BR>
  *	Class:	   Car     			<BR>
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

public class Cars extends Vehicle  {
   private int chosenTowingPackage, chosenTypeOfCar;
   final static String VEHICLE_IS = "Car";
   final private String promptForCarType = "What Type of car is this? ";
   final private String promptForCarTowing = "Does this car have a towing package? ";
   final static private String [ ] towingPackage = new String [ ] {"Towing package", "No towing package"};
   final static private String [ ] typeOfCar = new String [ ]{"Sedan ", "Coupe", "Wagon"};
   
   
   /**
     * Constructor method calls on other methods to 
     * request user information from vehicle class.        <BR>
     * <BR> 
     * @param  option is used to determine which prompt to display 
     */
   public Cars(){
      super(VEHICLE_IS); 
      chosenTypeOfCar = showMenu(promptForCarType, typeOfCar); 
      chosenTowingPackage = showMenu(promptForCarTowing, towingPackage); 
   }

   /**
     * toString method formats the gathered information and
     * returned to the class that called it. Such as model,
     * color, cost, type of car and towing package.
     *        <BR>
     *        <BR> 
     * @return  Formated string of the gathered information. 
     */  
   public String toString( ){
      return String.format("%s %14s%-15s\n %14s%-15s\n", 
               super.toString( ), "Type: ", getTypeOfCar( ),"Towing: ",
               getTowingPackage( ));
   }
   
   /**
     * Accessor method to receive the type of car.
     *        <BR>
     * <BR> 
     * @return  String of the car type. 
     */ 
   public String getTypeOfCar( ){
      return typeOfCar[chosenTypeOfCar];
   }
   
   /**
     * Accessor method to receive the towing package.
     *        <BR>
     * <BR> 
     * @return  String of the towing package. 
     */ 
   public String getTowingPackage( ){
      return  towingPackage[chosenTowingPackage];
   }
   
   /**
     * Accessor method to receive the gas milage using interface VInfo.
     *        <BR>
     * <BR> 
     * @return  double of the gas mileage. 
     */
   public double gasMileage( ){
      double carGasMileage = 0;
      
      if(chosenTypeOfCar == 0){
            carGasMileage = SEDAN;
            
         }else if(chosenTypeOfCar == 1){
            carGasMileage = COUPE;
            
            }else if(chosenTypeOfCar == 2){
               carGasMileage = WAGON;
               }
               
      switch(chosenTowingPackage){
         case 1: carGasMileage = carGasMileage + TOWPACKAGE;
                 break;
      }             
      
      return carGasMileage;
    }
      
}//ends public cars class         
      