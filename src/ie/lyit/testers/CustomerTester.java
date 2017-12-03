// Name: Ciarán Toman
// Date: 18/09/2017
// Desc: Customer tester class

package ie.lyit.testers;
import ie.lyit.hotel.*;

public class CustomerTester {

	public static void main(String[] args) {
		
		//default constructor
		Customer c = new Customer();
		
		//initialize constructor
		Customer c1 = new Customer(new Name("Mr","Ciarán","Toman"),"Lower Main ST", "0881234091", "CT@anything.com");
		
		System.out.println(c1);
		System.out.println(c);
		
		//no
		System.out.println( "Are these the same employee? " + (c1.equals(c)? "Yes": "No") );
		
		Customer c2 = c1;
		
		//yes: pointing to same reference, therefore same unique customer No.
		System.out.println( "How about now? " + (c1.equals(c2)? "Yes": "No") );
		
		Customer c3 = new Customer(new Name("Mr","Ciarán","Toman"),"Lower Main ST", "0881234091", "CT@anything.com");
		
		//no: same details but not the same customer No.
		System.out.println( "And now? " + (c1.equals(c3)? "Yes": "No") );
		
		System.out.println(c2);
		System.out.println(c3);
		

	}

}

