// Name: Ciarán Toman
// Date: 11/11/2017
// Desc: Customer Menu class


package ie.lyit.hotel;

import javax.swing.JOptionPane;

public class CustomerMenu {

	
	//instance variables
	private int option = 0;
	
	//display menu and read option off user,
	//return option 1 - 5.
	//6, X, cancel or a string entered will close dialog, exiting loop.
	public int displyReadOption() {
		
		do {
			try {
				option = Integer.parseInt(JOptionPane.showInputDialog(
						"Customer Menu\n\n" + 
						"1. Add\n" + 
						"2. List\n" +
						"3. View\n" +
						"4. Edit\n" +
						"5. Delete\n" +
						"6. Quit\n\n" +
						"Enter Option:"));
			}catch(NumberFormatException nfe) {
				
				//exit if user wants
				//ill take a string as wanting out
				System.out.println("GoodBye");
				option = 6;
			}
			
			//while its an invalid option, and not 6.
		}while((option < 1 || option >= 7) && option != 6);
		
		return option;
	}
	
}
