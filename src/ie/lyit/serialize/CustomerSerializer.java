// Name: Ciarán Toman
// Date: 11/11/2017
// Desc: Customer Serializer class


package ie.lyit.serialize;

import ie.lyit.hotel.Customer;
import ie.lyit.hotel.CustomerDAO;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.JOptionPane;


public class CustomerSerializer implements CustomerDAO{
	
	//instance variables
	private ArrayList<Customer> customers = new ArrayList<>();
	private String FILENAME = "src/data/customerOutput.bin";
	private Path path = Paths.get(FILENAME);
	private ObjectInputStream is;
	private ObjectOutputStream os;
	private int deleted;
	
	
	
	
	//write records method
	//write records out to file
	//Serialize
	//
	//try creating OOStream object to write objects to the file,
	//  (Convert Objects to bits)
	//
	//passing in the FOStream object to connect to the file,
	//  (write bits to file, after connection)
	//		 which passes in the defined file path.
	//
	//use OOStream method to write objects to file,
	//
	//then close connection
	//
	//catch file not found or I/O error
	@Override
	public void writeRecordsToFile() {
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(path.toString()));
			os.writeObject(customers);
			os.close();
	
		}
		catch(FileNotFoundException fn) {
			System.out.println(fn.getMessage());
			
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
			
		}
	}//end writeRecords method
	
	
	
	
	
	//read records method
	//Read records in from file
	//deserialize
	//
	//if file path exists
	//  try creating OIStream object to retrieve objects from file
	//    (converts bits to objects)
	//
	//  passing in the FIStream object to connect to the file
	//    (read bits from file, after connection)
	//  		which passes in the defined file path
	// 
	//if all goes well, set new next customer number
	//
	//close connection
	//
	//catch various exceptions
	//
	//suppressed warning, i know its an ArrayList of Customers
	//i am retrieving.
	@SuppressWarnings("unchecked")
	@Override
	public void readRecordsFromFile() {
		
		//if the file path exists
		if(Files.exists(path)) {
			try {

				is = new ObjectInputStream(new FileInputStream(path.toString()));
				customers = (ArrayList<Customer>)is.readObject();
				
				//After reading in ArrayList from file
				//set next Customer number to the last given out, + 1, + deleted Objects.
				//i.e. the Customer's number at the end of the ArrayList, + 1, + deleted Objects.
				Customer.setNextNum((customers.get(customers.size()-1).getCustNum() + 1) + deleted);
				is.close();

			}
			catch(ClassNotFoundException cnf) {
				System.out.println("Class not found: " + cnf.getMessage());
			}
			catch(FileNotFoundException fn) {
				System.out.println("File not found: " + fn.getMessage());

			}
			catch(IOException ioe) {
				System.out.println("Input/Output error: " + ioe.getMessage());

			}
		}	
	}//end readRecords method
	
	
	
	
	//add method: 
	//create Customer object, 
	//read Customer c details off user, 
	//add to ArrayList 
	@Override
	public void add() {
		Customer c = new Customer();

		c.read();

		customers.add(c);
	}//end add method
		
		
	
	//list method:
	//iterate through the ArrayList of Customers, 
	//print to screen (implicitly calling toString())
	@Override
	public void list() {
		
		for(Customer c: customers) {
			
			System.out.println(c);
		}
	}//end list method
	
	
	
	
	//view method: 
	//take input from the user,
	//if details have been entered,
	//	test them, i.e. Customer No.
	//
	//	if found, return customer object.
	//
	//	if not, return null customer object.
	@Override
	public Customer view(String m) {//String parameter, pass in use-case message
									//i.e. delete, edit, etc..
									//to be more specific on output to screen
		int t = 0;
		Customer cust = null;
		
		do {
			try {
				t = Integer.parseInt((JOptionPane.showInputDialog("Enter Customer number " 
																				+ m + ": ")));
			
			}catch(NumberFormatException nfe) {
			
				System.out.println("GoodBye");
				t = -1;
			}
			
		}while(t == 0);
		
		
		//if text has been entered
		//or try/catch executes (without error) and exits loop
		//i.e. t is not left at Zero
		for(Customer c: customers) {
				
			if(t == c.getCustNum()) {
					
				//if anything entered equals Customer No., its the customer.
				cust = c;
			}
		}
		
		//if customer was assigned
		//print customer
		if(cust != null) {
			System.out.println(cust);
			
		}
		//if they wern't assigned
		//print message
		else {
			System.out.println("Customer Number not found. \n");
		}
			
		//return customer object or null customer object.
		return cust;
	
	}//end view method
	
	
	
	
	//delete method:
	//find customer to delete,
	//if the return object is not null,
	//remove from ArrayList.
	//increment delete count.
	@Override
	public void delete() {
		
		Customer cust = view("to delete");
		
		if(cust != null) {
			customers.remove(cust);
			System.out.println("Customer deleted\n");
			deleted++;
		}
		else {
			System.out.println("Cannot delete\n");
		}
	}//end delete method
	
	
	
	
	//edit method:
	//find customer to edit,
	//read new details,
	//replace new details with old in list.
	@Override
	public void edit() {
		
		Customer cust = view("to edit details");
		
		if(cust != null) {
			
			cust.read();
			
			//loop through customer list
			for(int i = 0; i < customers.size(); i++) {
					
					//when found target customer
					//replace with position found at ( i ).
					if(customers.get(i).equals(cust)) {
						customers.set(i, cust);
					}
				}
			}
		else {
			System.out.println("Customer not found");
		}
			
		}//end edit method
	
	
}//end class
