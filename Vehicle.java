import java.util.*;
import java.io.*;
/**
  *	Name: 	   Miguel Angel Galan   <BR>
  *	Course:	   4002-218-01       	<BR>
  *	Homework:	#6, Vehicle    		<BR>
  *	Date:	      10/22/18       		<BR>
  *<BR>
  *	Class:	   Vehicle     			<BR>
  *	Purpose:	   The purpose of this class is to be used 
  *			      as parent class for three other classes to 
  *			      inherite from. Some of the methods include asking
  *			      for user information through a menu method.
  *			      Other methods include accesor and mutators for
  *			      private attributes. 
  *			                           <BR>
  *                                    <BR>
  *	@author Miguel Angel Galan
  *	@version 3.0				
  *	
  */

public abstract class Vehicle implements VInfo, Serializable{
   private String model, color;
   private double cost;
   private String VEHICLE_IS;
   static final long serialVersionUID = 8720651351009466708L;
   private transient Scanner keyBoardInput = new Scanner(System.in);
   private int index;
   
   /**
     * Constructor method calls on other methods to 
     * request user information.        <BR>
     * <BR> 
     * @param  Type of vehicle that is choosen by the user. 
     */
   public Vehicle(String VEHICLE_IS){
      this.VEHICLE_IS = VEHICLE_IS;
      acceptUserInput();             
   }
   
   public String getVehIs( ){
      return VEHICLE_IS;
   }
   
   /**
     * Accessor method to receive the model of vehicle.
     *        <BR>
     * <BR> 
     * @return  The model of the vehicle is returned as a string 
     */   
   public String getModel( ){
      return model;
   }   
   
   /**
     * Accessor method to receive the color of vehicle.
     *        <BR>
     * <BR> 
     * @return  The color of the vehicle is returned as a string 
     */ 
   public String getColor( ){
      return color;
   }
   
   /**
     * Accessor method to receive the cost of vehicle.
     *        <BR>
     * <BR> 
     * @return  The cost of the vehicle is returned as a double 
     */ 
   public double getCost( ){
      return cost;
   }
      
   /**
     * Mutator method to change the value of model.
     *        <BR>
     * <BR>
     * @param   String new model description 
     */
   public void setModel(String newModel){
      model = newModel;
   }
   
   /**
     * Mutator method to change the value of color.
     *        <BR>
     * <BR>
     * @param   String new color description 
     */
   public void setColor(String newColor){
      color = newColor;
   }
   
   /**
     * Mutator method to change the value of cost.
     *        <BR>
     * <BR>
     * @param   Double new cost description 
     */
   public void setCost(double newCost){
      if(newCost > 0)
         cost = newCost;
   }
   
   /**
     * Menu method displays a menu to the user and 
     * requests for information from the user.
     *        <BR>
     * <BR>
     * @param   prompt is a string passed in to display to the user.
     * @param   choices is an array of strings the hold a variety.
     * @return  returns an index of the chosen choice from the array.
     * @throws  InputMismatchException is throw if input is invalid. 
     */
   public int showMenu(String prompt, String [ ] choices){
      System.out.println(prompt);
      
      for(int counter = 0; counter < choices.length; counter++){
         System.out.printf("%5d . %-10s \n", (counter+1), choices[counter]);
      }
      
      System.out.print("Choice: ");      
      boolean exit = true;
      
      do{
         try{
            index = keyBoardInput.nextInt( );
            exit = (index < 1 || index > choices.length);
            }catch(InputMismatchException e){
            
               System.out.println("Invalid input Mismatch");
            }
            
            keyBoardInput.nextLine( ); //clears the return
            
            if(exit)
               System.out.println("Enter number between 1 - " + choices.length);
               
        }while(exit);
     
     
     return (index - 1);
   }
   
   /**
     * Request from user three attributes.
     *        <BR>
     * <BR> 
     */
   public void acceptUserInput(){
     
      System.out.printf("%17s", "Model: ");   
      model = keyBoardInput.nextLine( );
       
      
           
      System.out.printf("%17s", "Color: ");
      color = keyBoardInput.nextLine( );      
      
         
      System.out.printf("%17s", "Cost: ");
      
      while(true){
         try{
            cost = keyBoardInput.nextDouble( );
            
            }catch(Exception e){
              System.out.print("Invalid dollar amount, do not use $ or , in the entered cost. Try again.");
              keyBoardInput.nextLine( );
              continue;
            }
            
            if(cost < 0){
               System.out.print("Enter a number greater than zero: ");
               continue;
            }   
            break;
      }
      }//End of accept user class.
      
     /**
       * toString method formats the gathered information and
       * returned to the class that called it. Such as model,
       * color and cost of vehicle.
       *        <BR>
       *        <BR> 
       * @return  Formated string of the gathered information. 
       */ 
      public String toString( ){
      
         return String.format("%-10s\n %14s%-20s\n %14s%-10s\n %14s%-10.2f\n %14s%-10.2f\n", 
               getVehIs( ), "Model: ", getModel( ), "Color: ", getColor( ), "Cost: ", getCost( ),
               "MPG/GPH: ", gasMileage( ));  
      
      }

            
   
   }//End of vehicle class.
   

      
      
      
      
      