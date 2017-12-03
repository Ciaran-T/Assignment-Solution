package ie.lyit.testers;
import java.util.ArrayList;

import ie.lyit.hotel.*;

public class EmployeeTester {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee(new Name("Mr","Ciaran", "Toman"), "Letterkenny", "087-1234567", 
				new Date(26, 7, 1989),new Date(8, 10, 2017), 135000);
		
		//Employee emp3 = emp1;
		
		Employee emp2 = new Employee(new Name("Mr","Ciaran", "Toman"), "Letterkenny", "087-1234567", 
				new Date(26, 7, 1990),new Date(8, 10, 2017), 135000);
		
		Employee emp4 = new Employee(new Name("Mr","Ciaran", "Tom"), "Letterk", "088-1234567", 
				new Date(26, 7, 1999),new Date(8, 10, 2017), 135000);
		
		Employee emp5 = new Employee(new Name("Mr","Tommy", "Teirnan"), "Cavan", "083-1234567", 
				new Date(26, 7, 1979),new Date(8, 10, 2017), 135000);
		
		Employee emp6 = new Employee(new Name("Ms","Ciaran", "Tomar"), "Letterk", "088-1234567", 
				new Date(26, 7, 1992),new Date(8, 10, 2017), 135000);
		
		//no: testing unique employee number
		System.out.print(emp1.equals(emp2)? "Are the same person\n" : "Are not the same person\n");
		//System.out.print(emp1.equals(emp3)? "Are the same person\n" : "Are not the same person\n");
		
		
		//new employee list
		ArrayList<Employee> empList = new ArrayList<Employee>();
		
		//add objects to the list
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp4);
		empList.add(emp5);
		
		//for every employee in empList,
		//print out details (implicitly calling toString)
		for(Employee e: empList) {
			
			System.out.println(e);
		}
		
		EmployeeTester empTest = new EmployeeTester();
		
		System.out.println(empTest.employeeSearch(emp6, empList)? "In the List" : "NOT in the list");
		System.out.println(empTest.employeeSearch(emp1, empList)? "In the List" : "NOT in the list");
		
		

	}
	
	//search class
	public boolean employeeSearch(Employee emp, ArrayList<Employee> empList) {
		
		boolean e = false;
		
		for(Employee employ: empList) {
			
			if(emp.equals(employ)) {
				
				e = true;
			}
		}
		
		return e;
	}

}
