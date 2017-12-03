// Name: Ciarán Toman
// Date: 11/11/2017
// Desc: Employee class 

package ie.lyit.hotel;

public class Employee extends Person implements Payable {
	
	/**
	 * Automatically generated ID
	 */
	private static final long serialVersionUID = -356624747818767616L;
	//instance variables
	private Date dateOfBirth;
	private Date startDate;
	private double salary;
	private int employeeNum;
	private static int nextEmpNum = 1;
	
	//constructors
	public Employee() {
		super();
		dateOfBirth = new Date();
		startDate = new Date();
		salary = 0;
		employeeNum = nextEmpNum++;
	}
	
	public Employee(Name name, String address, String phoneNum, Date dateOfBirth, Date startDate,
			double salary) {
		
		super(name, address, phoneNum);
		this.dateOfBirth = dateOfBirth;
		this.startDate = startDate;
		this.salary = salary;
		this.employeeNum = nextEmpNum++;
	}
	
	
	//inherited abstract method implementation
	//
	//calculate wage method:
	//calculate tax to be deducted,
	//	i.e. percentage parameter divided by 100,
	//	multiplied by salary.
	//
	//return the result of 
	//(salary - tax) 
	//dived by 12, (months)
	//
	public double calculateWage(double taxPercentage) {
		 
		double taxDeduct = salary * (taxPercentage/100);
		return (salary - taxDeduct) / 12;
	}
	
	
	//method to increment salary:
	//calculate salary and test with max,
	//if less than or equal to max, apply raise.
	//if its greater than max, set salary to max,
	public double incrementSalary(double incrementAmount) {
		
		int max = 150000;
		
		if((this.salary += incrementAmount) <= max) {
			
			this.salary += incrementAmount;
		}
		else if((this.salary += incrementAmount) > max) {
			
			this.salary = max;
		}
		
		return this.salary;
	}
	
	//Setters/Getters
	public Date getDateOfBirth() {
		
		return this.dateOfBirth;
	}
	
	public Date getStartDate() {
		
		return this.startDate;
	}
	
	public double getSalary() {
		
		return this.salary;
	}
	
	public int getEmployeeNum() {
		
		return this.employeeNum;
	}
	
	//set date of birth method:
	//
	//call set date on date of birth variable
	//
	//passing in year, month and day of the parameter
	//
	public void setDateOfBirth(Date dateOfBirth) {
		
		this.dateOfBirth.setDate(dateOfBirth.getYear(), dateOfBirth.getMonth(), dateOfBirth.getDay());
	}
	
	//same again
	public void setStartDate(Date startDate) {
		
		this.startDate.setDate(startDate.getYear(), startDate.getMonth(), startDate.getDay());
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean t = false;
		Employee e;
		
		if(obj == null) {}
		
		else if(obj == this) {
			t = true;
		}

		else if(obj instanceof Employee) {

			e = (Employee)obj;

			if(this.employeeNum == e.getEmployeeNum()) {
				t = true;
			}
		}
		
		
		return t;
	}
	@Override
	public String toString() {
		
		return "" + this.getName().toString() + "\n"
				+ "Date of Birth: " + this.dateOfBirth + "\n"
				+ "Start date: " + this.startDate + "\n" +
				"Salary: " + this.getSalary() + "\n"
				+ "Employee Number:  #" + this.getEmployeeNum() + "\n";
	}

}
