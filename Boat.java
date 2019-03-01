/**
  *	Name: 	   Miguel Angel Galan   <BR>
  *	Course:	   4002-218-01       	<BR>
  *	Homework:	#6, Vehicle    		<BR>
  *	Date:	      10/22/18       		<BR>
  *<BR>
  *	Class:	   Boat     			<BR>
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

public class Boat extends Vehicle {
   private int chosenType, chosenConstruction;
   final static String VEHICLE_IS = "Boat";
   final private String typeOfBoatPrompt = "What type of boat is this? ";
   final private String typeOfConstructionPrompt = "what is the boat construction? ";
   final static private String [ ] boatTypes = new String [ ]{"Pontoon", "PWC", "SailBoat"};
   final static private String [ ] constructionTypes = new String [ ]{"Wood", "FiberGlass", "Steel"};      
   
   
   /**
     * Constructor method calls on other methods to 
     * request user information from vehicle class.        <BR>
     * <BR> 
     * @param  option is used to determine which prompt to display 
     */
   public Boat(){
      super(VEHICLE_IS); 
      chosenType = showMenu(typeOfBoatPrompt, boatTypes); 
      chosenConstruction = showMenu(typeOfConstructionPrompt, constructionTypes);  
   }
    
   /**
     * toString method formats the gathered information and
     * returned to the class that called it. Such as model,
     * color, cost, type of boat and boat material.
     *        <BR>
     * <BR> 
     * @return  Formated string of the gathered information. 
     */  
   public String toString( ){
      return String.format("%s %14s%-15s\n %14s%-15s\n", 
               super.toString( ), "Type: ", getBoatType( ),"Made Of: ",
               getBoatConstruction( ));
   }
    
   /**
     * Accessor method to receive the type of car.
     *        <BR>
     * <BR> 
     * @return  String of the car type. 
     */         
   public String getBoatType( ){
      return boatTypes[chosenType];
   }
   
   /**
     * Accessor method to receive the towing package.
     *        <BR>
     * <BR> 
     * @return  String of the towing package. 
     */  
   public String getBoatConstruction( ){
      return constructionTypes[chosenConstruction];
   }
   
   
   /**
     * Accessor method to receive the gas milage using interface VInfo.
     *        <BR>
     * <BR> 
     * @return  double of the gas mileage. 
     */
   public double gasMileage( ){
      double boatGasMileage = 0;
      if(chosenType == 0){
            boatGasMileage = PONTOON;
         }else if(chosenType == 1){
            boatGasMileage = PWC;
            }else if(chosenType == 2){
               boatGasMileage = SAILBOAT;
               }              
      
      return boatGasMileage;
    }
    
}//end of Boat class
    