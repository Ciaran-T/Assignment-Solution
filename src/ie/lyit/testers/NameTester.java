// Name: Ciarán Toman
// Date: 18/09/2017
// Desc: Name class

package ie.lyit.testers;

import java.util.*;
import ie.lyit.hotel.*;

public class NameTester {

	//main
	public static void main(String[] args) {

		Name n = new Name("Mr","Ciaran","Toman");
		System.out.print(n);
		
		//n.setFName("Tom");
		//System.out.print(n);
		
		n.setTitle("Ms");
		if(n.isFemale()) {
			
			System.out.println("Female");
		}
		else {
			System.out.println("Male");
		}
		
		//method test
		n.setTitle("Mr");
		Name tn = new Name("Mr","Ciaran","Toman");
		
		System.out.print(tn);
		
		//same person
		System.out.print((n.equals((Object)tn))?"\nSame Person\n":"\nNOT the same Person\n");
		
		
		ArrayList<Name> names = new ArrayList<Name>();
		
		names.add(new Name("Mr","Tom","Brady"));
		names.add(new Name("Miss","Jasmine","Brady"));
		names.add(new Name("Mr","Keiran","Mc Geeney"));
		
		for(Name q: names) {
			System.out.println(q);
		}
		
		NameTester m = new NameTester();
		
		System.out.println((m.nameSearch(names, tn))?"" + tn +" is IN the list": "" + tn + "is NOT in the list");
		
		
	}//end main
	
	//method to search array for a name
	//taking in list of name objects
	//and name to look for.
	//
	//testing equality
	//
	//true if in list
	//leave false otherwise
	//
	//return if exists
	public boolean nameSearch(ArrayList<Name> namez, Name p) {
		
		boolean exist = false;
		for(Name n: namez) {
			
			if(n.equals(p)) {
				exist = true;
			}
		}
		
		return exist;
		
	}//end search method
	
	
}//end class
