// Name: Ciarán Toman
// Date: 11/11/2017
// Desc: CustomerSerializer tester class


package ie.lyit.testers;

import ie.lyit.hotel.CustomerMenu;
import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester {

	public static void main(String[] args) {
		
		CustomerSerializer c = new CustomerSerializer();
		int option = 0;
		CustomerMenu cm = new CustomerMenu();
		
		
		//deserialize method
		c.readRecordsFromFile();
		
		
		do {
			option = cm.displyReadOption();

			switch(option) {

			case 1 :
				c.add();
				break;
			case 2 :
				c.list();
				break;
			case 3 : 
				c.view("to view");
				break;
			case 4 :
				c.edit();
				break;
			case 5 :
				c.delete();
				break;
			default:
				System.out.println("Quiting");
			}
		}while(option != 6);
		
		
		//serialize method
		c.writeRecordsToFile();


	}
		
		
}

