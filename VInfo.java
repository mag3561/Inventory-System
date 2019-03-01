/**
  *	Name: 	   Miguel Angel Galan   <BR>
  *	Course:	   4002-218-01       	<BR>
  *	Homework:	#6, Vehicle    		<BR>
  *	Date:	      10/22/18       		<BR>
  *<BR>
  *	Interface:	VInfo     			<BR>
  *	Purpose:	   The purpose of this interface is to  
  *			      hold information that the parent class can
  *               implement in its class. Information here are 
  *               related to the vehicle subclasses such as 
  *               boat, car and moped. 
  *			                           <BR>
  *                                    <BR>
  *	@author Miguel Angel Galan
  *	@version 3.0				
  *	
  */

public interface VInfo{

   final static double PONTOON = 3.5;
   final static double PWC = 2.2;
   final static double SAILBOAT = 0;
   
   final static double SEDAN = 29.7;
   final static double COUPE = 22.2;
   final static double WAGON = 19.5;
   final static double TOWPACKAGE = -3;
   
   final static double FIFTYCC = 150.5;
   final static double ONEFIFTYCC = 101.9;
   final static double TWOFIFTYCC = 90.8;
   
   final static double HELICOPTERMILEAGE = 7.2;
   
   /**
     * Gas mileage returns a double. 
     * <BR>
     * <BR> 
     * @return  returns the gas mileage of the vehicle. 
     */
   public double gasMileage( );
   
   
}