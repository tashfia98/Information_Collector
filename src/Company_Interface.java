//***********************************************************************************************
    // Written by: Tashfia Naharin Proma
	// Summer 2018
//***********************************************************************************************
//Password = password.

// A simple java program that collects customer information for a company. Error handling is not done in this version. User can perform activities from provided options.

import java.util.Scanner; //Scanner imported.

public class Company_Interface {
    
	    //Main method, the Driver file.
	public static void main(String[] args) {

	        String prompt= "Welcome to Customer's Information Collector !\n"+"Enter the maximum number of customers you want to store: ";
          	System.out.print(prompt);
          	
    	
         	maxCustomers= keyboard.nextInt();
         	
         	//Creating userDatabase array
         	userDatabase= new Customer[maxCustomers];

          	//Printing main menu in case user choose an invalid option        
            while(printingPrompt()<1|| printingPrompt()>5) {
          	      	printingPrompt();
            }
            keyboard.close()  ; //to stop the keyboard.               
	}
	
		
	// Extra Attributes
	private static Customer[] userDatabase;
	private static final String password= "password";
	private static int maxCustomers;
	public static int failedAttempts=0;
	public static Scanner keyboard= new Scanner(System.in); //to take input.
	
	//Method that prints the main menu.
	private static int  printingPrompt() {

        String prompt;
        prompt= "\nWhat do you want to do?\n"
		+ "  1. Enter new customer (password required)\n" 
		+ "  2. Change information of a customer (password required)\n" 
		+ "  3. Display all customers residing on the same street\n" 
		+ "  4. Display all customers residing in the same city\n" 
		+ "  5. Quit\n"
		+ "Please enter your choice >";
        
        //Printing options.
        System.out.print(prompt);
        int  choice= keyboard.nextInt();
           
        //Switch for the prompt options of the main menu.
        switch(choice) {
	
             case 1: {      
	    	             //Validating user's password
	                     if( autenticatingPassword() ) {
	    	                 System.out.print("\nHow many customers do you want to enter? : ");
	                     }
	                     
	                     //If password incorrect, after this process is repeated 4 times  ( failed 12 times), program quits
	                     else {  
	                    	    ++failedAttempts;
	                    	    if(failedAttempts==4) {
	                    	       System.out.print("\nProgram detected suspicious activities and will terminate immediately!");
	                    	       System.exit(0);
	                    	    }
	                    	    printingPrompt();
	                     }
	                     
	                     //storing the number of customers user wants to enter
	                     int nCustomers= keyboard.nextInt();
	                     
	                     //Checking if the user is not asking to add more customers than they is allowed
	                     int nbCustomersAvailable= maxCustomers- Customer.findNumberOfCreatedCustomers(  );
	                      
	                     //Let the user know they is not allowed to add those number of customers
	                     if(nbCustomersAvailable<  nCustomers) {
                    	         System.out.println("You can only add "+ nbCustomersAvailable+" customers");
                    	         nbCustomersAvailable= nCustomers;
	                     }
	                     
	                     //If number of customer user wants to enter data in it is allowed and added.
	                     else {
	                              for( int i=1; i<=nCustomers;i++) {
	                            	  
	                                   System.out.println("\nPlease enter the following customer's information: \n");
	        	 
	        	                       System.out.println("Name: ");
	        	                       String name= keyboard.next();
	        	 
	        	                       System.out.println("\nStreet Number: ");
	        	                       int streetNum= keyboard.nextInt();
	        	 
	                                   System.out.println("\nStreet Name: ");
	        	                       String streetName= keyboard.next();
	        	 
	        	                       System.out.println("\nCity: ");
	                                   String city= keyboard.next();
	        	 
	        	                       Customer newCustomer= new Customer(name, streetName,city,streetNum);
	         
	        	                       userDatabase[Customer.findNumberOfCreatedCustomers()-1]= newCustomer;
	        	                       System.out.println("\nCustomer "+ name+ " sucessfully added!");
	                               }
	                      }
	                      printingPrompt();
	                     
             }	                     
             break;
       
			 case 2: {
		                  if( autenticatingPassword() ) {
			                     checkingCustomerNumber();
			              }	
		                  
		                  else {   
			                     printingPrompt();
		                  }
		   
	                      checkingCustomerNumber();
	                      
			 }
			 break;
    		  
             case 3: {       
		                   System.out.print("Please enter the Street Name: ");
		                   String streetFind = keyboard.next();
		                   System.out.println();
		                   findCustomerBy(streetFind);
		                   printingPrompt();
		                   
             }   	                   
    	     break;
    	   
             case 4: {
						   System.out.print("Please enter the City: ");
					   	   String cityFind = keyboard.next();
					   	   System.out.println();
					   	   findCustomersFromCity(cityFind);
					   	   printingPrompt();
       	                    
             }     	                    
   	         break;
    	   
             case 5: {             
            	           System.out.println("Thank you for using our Customer's Information Collector. Goodbye!");
	                       System.exit(0);
			        	   
             }	
             break;
             
        }
        
 	    return choice;	           
	}
	
	
   //for option 1 and 2 in main menu.	
   //Method that authenticate user's password.
	private static boolean autenticatingPassword() {
		
		//Giving three chances to give wrong password.
		for(int i=2;i>=0;i--) {
		       System.out.print("Enter your password: \t");
		       String input = keyboard.next();
		
		        if(password.equals(input)) {
			            return true;	
		         }
		        else {
			            if(i==0) {
		    	            return false;
	    	            }
		         }
		}
		return false;

	}
	
	
    //for option 2.  
    //Method that check if customer index is valid
    private static void checkingCustomerNumber() {
	
	    System.out.print("Write the customer number you want to update : ");
	    int  customerNumber= keyboard.nextInt()-1;
         
	    //Checking if customer index is valid
        if( customerNumber<=-1||userDatabase[customerNumber]==null||customerNumber>= maxCustomers) {
        	              
         	//Asking customer if they want to try again or go to main method
            System.out.print("Sorry, but that customer number doesn't exist\n"
            +"Write 'a' or 'A' if you want to try another customer number.Anything else will take you back to the main menu: ");
                
            String answer= keyboard.next();
            
            if(answer.equals("a")|| answer.equals("A")) 
                checkingCustomerNumber();
  
            else 
                printingPrompt();
   
        }
        
        else 
                //Write the method that will update customer 
	            updatingCustomer( customerNumber);
    }
	
    
    //for option 2.
	//Method that update customer information
	private static void updatingCustomer(int customerNumber) {
		
		//Printing current customer information
		System.out.println("\nCustomer: #" + (customerNumber+1) +userDatabase[customerNumber]);
		
		//The second Menu.
		String changeOptions = "\nWhat information would you like to change? \n"
				+ "	1. Customer Name\n"
				+ "	2. Street Number\n"
				+ "	3. Street Name\n"
				+ "	4. City\n"
				+ "	5. Quit (will take you to the main menu)\n"
				+ "Please enter your choice > ";
		System.out.print(changeOptions);
	    
		int updateOption= keyboard.nextInt();
		
		//when i changed it from >4 to >5 it worked.
		if(updateOption<1|| updateOption>5) {
			    updatingCustomer(customerNumber);
		}
		
		switch ( updateOption) {
		
		        case 1: 
			               System.out.print("Write the new customer name: ");
			               String name= keyboard.next();
			               userDatabase[customerNumber].setName(name);
		                   updatingCustomer(customerNumber);
			
			    break;
			
		        case 2: 
			
			               System.out.print("Write the new customer street number: ");
			               int streetNum= keyboard.nextInt();
			               userDatabase[customerNumber].setStreetNum(streetNum);
			               updatingCustomer(customerNumber);
			
			    break;
			
		        case 3:
			
			               System.out.print("Write the new customer street name: ");
			               String streetName= keyboard.next();
			               userDatabase[customerNumber].setStreetName(streetName);
			               updatingCustomer(customerNumber);
			
			    break;
			
		        case 4 :
			
			               System.out.print("Write the new customer city: ");
			               String city= keyboard.next();
			               userDatabase[customerNumber].setCity(city);
			               updatingCustomer(customerNumber);
			
			    break;
			
		        case 5:  
		        	       printingPrompt(); 
			              
			    break;    	    
		}
		
		
		
	}

	

    //For option 3.
	//To find and display all the customers with the same street name.
	private static void findCustomerBy(String streetFind) {
		 for (int a=0  ; a < userDatabase.length ; a++) {
				 if(userDatabase[a]!=null) {
					  if ( (userDatabase[a].getStreetName() ).equals(streetFind) ) {
						 System.out.println(" Name: " + userDatabase[a].getName());
					     System.out.println(" Street Number: " + userDatabase[a].getStreetNum());
					     System.out.println(" Street: " + userDatabase[a].getStreetName());
						 System.out.println(" City: " + userDatabase[a].getCity());
						 System.out.println();
					  }
				 }  
		 }
	 }
	
	
	//For option 4.
	//To find and display all the customers with the city.
	private static void findCustomersFromCity(String cityFind) {
		 for (int a=0  ; a < userDatabase.length ; a++) {
				 if(userDatabase[a]!=null) {
					  if ( (userDatabase[a].getCity() ).equals(cityFind) ) {
						 System.out.println(" Name: " + userDatabase[a].getName());
					     System.out.println(" Street Number: " + userDatabase[a].getStreetNum());
					     System.out.println(" Street: " + userDatabase[a].getStreetName());
					     System.out.println(" City: " + userDatabase[a].getCity());
						 System.out.println();
					  }
				 }
		 }

	}

	
	
}
