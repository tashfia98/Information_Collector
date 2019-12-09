//***********************************************************************************************
    // Written by: Tashfia Naharin Proma
	// Summer 2018
//***********************************************************************************************

public class Customer {
    
	//Attributes
	private String name, streetName, city;
	private int streetNum;
	private static int numberOfCreatedCustomers= 0;
	
	//Default Constructor 
    public Customer () {
    	name = null;
    	streetName = null;
    	city = null;
    	streetNum = 0;
    }
    
    //Copy Constructor
    public Customer (Customer save) {
    	this.name = save.name;
    	this.streetName = save.streetName;
    	this.city = save.city;
    	this.streetNum = save.streetNum;
     }
    
    //Input Constructor ( takes input and sets the values )
    public Customer (String name, String streetName, String city, int streetNum) {
    	this.name = name;
    	this.streetName = streetName;
    	this.city = city;
    	this.streetNum = streetNum;
    	
    	 numberOfCreatedCustomers++;
    	
    }
    
    //Accessors 
    public String getName () {
    	return name;
    }
    
    public String getStreetName () {
    	return streetName;
    }
    
    public String getCity () {
    	return city;
    }
	
    public int getStreetNum () {
    	return streetNum;
    }
	
    //Mutators
	public void setName (String name) {
		this.name = name;
	}
	
	public void setStreetName (String streetName) {
		 this.streetName = streetName;
	}
	 
	public void setCity (String city) {
		this.city = city;
	}
	
	public void setStreetNum (int streetNum) {
		this.streetNum = streetNum;
	}
	
	//toString Method to display all data.
	public String toString () {
		return    "\nName: "+name 
			    + "\nStreeNum: "+ streetNum 
			    + "\nStreetName: " + streetName 
			    + "\nCity: " + city ;
		
		
	}
	
    /*It is required to know how many Customer objects have been created. For that, you need to add a
    method, called findNumberOfCreatedCustomers(), to the class. This method must return number
	of created Customer objects prior to the time this method is called. The method would simply
	return 0 if no customers has been created by the time the method is called. (Hint: use Static � You
	are allowed to add other attributes to the class.) . */
	public static int findNumberOfCreatedCustomers(  ) {
		
		return  numberOfCreatedCustomers;
	}
	
   /*equals() method) to check if streetName and city are of customers are same*/
	public boolean equals (Customer customer) {
		return ( (streetName.equals(customer.streetName)) && (city.equals(customer.city)) );
	}

    /*It is required to display any Customer object (all info of that object) using System.out.println()
	method. (Hint: use toSting() method). */
    public String toString1 () {
		return name;
	}
    
    

}
