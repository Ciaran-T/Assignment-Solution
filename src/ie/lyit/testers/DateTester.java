//Name: Ciarán Toman
//Date: 18/09/2017
//Desc: Name class

package ie.lyit.testers;
import ie.lyit.hotel.*;
import javax.swing.JOptionPane;

public class DateTester {

	public static void main(String[] args) {
		
		//Date date = new Date();
		boolean b = false;
		
		Date dateNew = null;
		
		int yearInput, monthInput, dayInput;
		
		
		
		do {
			
			try {
				yearInput = Integer.parseInt(JOptionPane.showInputDialog("Enter a year"));
				monthInput = Integer.parseInt(JOptionPane.showInputDialog("Enter a month"));
				dayInput = Integer.parseInt(JOptionPane.showInputDialog("Enter a day"));
		
				//testing constructor
				dateNew = new Date(dayInput, monthInput, yearInput);
				
				
			}
			//close dialog box if no number input
			catch(NumberFormatException nFE) {
				System.out.println("No number entered");
				//create valid date to exit infinite loop
				//if wanting out
				dateNew = new Date();
			}
			
			catch(IllegalArgumentException iAE) {
				
				System.out.println(iAE.getMessage());
				dateNew = null;
			}
		
		}while(dateNew == null);
		
		
		//System.out.println(date);
		//System.out.println(dateNew);
		
		
		Date myDate1 = new Date();
		
		//try to set year, month and day
		do {
			try {
							
				myDate1.setYear(Integer.parseInt(JOptionPane.showInputDialog("Enter a year")));
				myDate1.setMonth(Integer.parseInt(JOptionPane.showInputDialog("Enter a month")));
				myDate1.setDay(Integer.parseInt(JOptionPane.showInputDialog("Enter a day")));
				
				b = true;
			
			}
			//close dialog box if no number input
			catch(NumberFormatException nFE) {
				b = true;
			}
			catch(IllegalArgumentException iAE) {
				
				System.out.println(iAE.getMessage());
			}
			
		}while(!b);
		
		
		/*dateNew.setYear(1899);
		dateNew.setMonth(2);*/
		//dateNew.setDay(30);
		//System.out.println(dateNew);
		
		//dateNew.setDay(29);
		System.out.println(dateNew.getDay());
		System.out.println(dateNew);

	}//end main

}//end class

