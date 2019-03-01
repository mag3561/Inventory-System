import java.util.*;
import java.io.*;

/**
  *	Name: 	   Miguel Angel Galan   <BR>
  *	Course:	   4002-218-01       	<BR>
  *	Homework:	#6, Vehicle    		<BR>
  *	Date:	      10/22/18       		<BR>
  *<BR>
  *	Class:	   Orders     			<BR>
  *	Purpose:	   The purpose of this class is to continually 
  *               prompt the user for information about a vehicle.
  *               Initially it request a type of vehicle the user would  
  *               like to order, then proceeds to create an instance of 
  *               the inherited class. Once the vehicle class has requested
  *               all information it will prompt if the user would like to
  *               make another order. 
  *			                           <BR>
  *                                    <BR>
  *	@author Miguel Angel Galan
  *	@version 3.0				
  *	@see Vehicle
  *   @see Truck
  *   @see Car
  *   @see Boat
  *   @see Moped
  */
public class Orders {

   /** 
     * Scanner Object used through out the program
     * to capture user input.
     * String file name used to open and save the file into
     */
   Scanner scan = new Scanner(System.in);
   String fileName = "VehicleOrder.dat";
   /** 
     * ArrayList itemsAdded is wrapped with VInfo, holds the information of vehicles ordered.
     */
   ArrayList<VInfo> itemsAdded = new ArrayList<VInfo>( );                   
   
   
   public static void main(String [] args){
   
      Orders vehicles = new Orders( );
      vehicles.RunOrders( );
      System.exit(0);
      
   }
   
   /**
     * RunOrders runs the program until the user is ready to quit.
     * The program initially looks for a file VehicleOrder.dat to 
     * load information from previous orders. Uses ArrayList object
     * along with vehicle class to add to the ArrayList. User choses
     * a vehicle then is prompted again after the information is
     * gathered if they would like to place another order.
     * Finally, when the user chooses to quit it will save the 
     * orders to a .dat and .txt file.        <BR>
     * <BR> 
     *  
     */
   public void RunOrders( ){
   
            
      System.out.printf("%-40s\n%-40s\n%-40s\n%-40s\n\n",
       "Miguel Angel Galan", "218-01 Q:024", "Homework # 6", "Prof. Alam");
      LoadOrders( );      
      do{
         
         ChooseVehicle( );
 
         }while(AskForAnotherVehicle( ));
         
      SaveOrders( );
      SaveToTextFile( );       
      DisplayAllVehicles( );      
      
      System.out.println("Thank you for using Miguels Ordering System.");
      
   }
   
   /**
     * Saves the customers oreder to the same file it was read from.  
     * <BR>
     * @throws catches an exception and prints out the stack trace back to the user. 
     */
   public void SaveOrders() {
      try {
            /**  
              * Object output stream used to read from the vehicle ordere data file.
              * Along with buffered output stream and file output stream.
              */
            ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            os.writeObject((ArrayList<VInfo>)itemsAdded);
            os.flush();
            os.close();
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
   
   /**
     * Checks to see if a file exist, if it does it will read the information from specified file. 
     * <BR>
     * @throws catches an exception and prints out the stack trace back to the user. 
     */
   public void LoadOrders( ){
    
    try{    /** 
              * File used to open the vehicle ordere data file.
              */
            File file = new File(fileName);
            if(file.exists()){
               /** 
                 * Object input stream used to read from the vehicle ordere data file.
                 * Along with buffered input stream and file input stream.
                 */  
               ObjectInputStream inStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
               itemsAdded = (ArrayList<VInfo>)inStream.readObject();
               inStream.close();         
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      
  
   }
   
   /**
     * Saves the requested car orders from the user to a text file. 
     * <BR>
     * @throws catches an exception and prints out the stack trace back to the user. 
     */
   public void SaveToTextFile( ){
   
      try{  /** 
              * Print writer used to write the vehicle ordered to a text file.
              */
            PrintWriter writer = new PrintWriter("VehicleOrders.txt");
               for(VInfo receiver: itemsAdded){
                     writer.print(receiver);
               }
            writer.flush( );
            writer.close( );
          }catch(Exception e){
             e.printStackTrace( );
          }
   }
   
   /**
     * Display all vehicle traverses the ArrayList to print out the 
     * vehicles ordered either it be truck, car or boat. <BR>
     * <BR> 
     * @param  itemsAdded is an arraylist that holds all vehicles from order. 
     */
   public void DisplayAllVehicles( ){
      
       for(VInfo receiver: itemsAdded){
          System.out.println(receiver);
       }
       
      
   }
      
   /**
     * ChooseVehicle prompts the user to pick from the prompted vehicle then it
     * will continue to request information from the user pertaining to the class.
     *                                                     <BR>
     * <BR> 
     * @param  itemsAdded ArrayList wrapped with vehicle is passed in. 
     * @return Arraylist is returned to runOrders.
     * @throws Throws an exception for input mismatched from the user.
     */
   public void ChooseVehicle( ){
      /** 
        * int userChoice holds the captured infromation entered
        */
      int userChoice;    
      
      System.out.println("Do you want to order a (1)Truck or (2)Car or (3)Boat or (4)Moped or (5)Helicopter? ");
      
      while(true){
      
        try{
               userChoice = scan.nextInt( );
            }catch(Exception e){
               System.out.println("Please enter something: ");
               System.out.print("Enter an appropriate choice (1)Truck or (2)Car or (3)Boat or (4)Moped or (5)Helicopter: ");
               scan.nextLine( );
               continue;
            }
                       
        if(userChoice == 1){
             System.out.printf("%-20s\n", "Enter truck order: ");             
             itemsAdded.add(new Truck());        
             break;
              
           }else if(userChoice == 2){
                      System.out.printf("%-20s\n", "Enter Car order: ");
                      itemsAdded.add(new Cars());       
                      break;
                     
                 }else if(userChoice == 3) {
                            System.out.printf("%-20s\n", "Enter Boat order: ");
                            itemsAdded.add(new Boat());       
                            break;   
              
                       }else if(userChoice == 4) {
                                  System.out.printf("%-20s\n", "Enter Moped order: ");
                                  itemsAdded.add(new Moped());
                                  break;
                                   
                                  } else if(userChoice == 5){
                                              System.out.printf("%-20s\n", "Enter Helicopter order: ");
                                              itemsAdded.add(new Helicopter( ));
                                              break;
                                      } else {                                  
                                                  System.out.print("Enter an appropriate choice (1) or (2) or (3) or (4): ");
                                                  scan.nextLine( );
                                                  continue;                                                                             
                                                }
      } 
      scan.nextLine( );
       
   }   
   
   /**
     * AskForAnotherVehicle prompts the user they would like to continue ordering.
     *                                                      <BR>
     * <BR> 
     * @return boolean is returned for the answer of the user true is continue false is quit.
     * @throws Throws an exception for input mismatched from the user.
     */
   public boolean AskForAnotherVehicle( ){
      /** 
        * Boolean value is set to true and is used to exit the loop in RunOrders.
        * char optionFroAnotherVehicle captures the choice of the user.
        */
      boolean keepGoing = true; 
      
      char optionForAnotherVehicle;
         
      System.out.println("Do you want to process another vehicles (Y/y) or (N/n)?");
      
      while(true){    
         try{     
               optionForAnotherVehicle = scan.nextLine( ).toUpperCase( ).charAt(0);
               
            }catch(Exception e){
               System.out.println("Please enter something: ");
               System.out.print("Enter an appropriate choice (Y/y) or (N/n): ");
               continue;
            }
            
         if(optionForAnotherVehicle != 'Y' && optionForAnotherVehicle != 'N'){
               System.out.print("Enter an appropriate choice (Y/y) or (N/n): ");
               continue;
                               
            }else {
                keepGoing = (optionForAnotherVehicle == 'Y');
                break;
            }
      }
      
      return keepGoing;
   }
      
   
}//end of order class //end of Process another vehicle function.
   
   
   