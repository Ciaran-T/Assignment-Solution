// Name: Ciarán Toman
// Date: 11/11/2017
// Desc: Date class

package ie.lyit.hotel;

public class Date {
	
	//instance variables
	private int day;
	private int month;
	private int year;    
	
	//constructors
	
	//default
	public Date() {
		//default valid values
		this.day = 1;
		this.month = 1;
		this.year = 1900;
		
	}
	
	//throws exception if any 
	//of the methods throw an error
	public Date(int day, int month, int year) throws IllegalArgumentException{
		
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	
	//setter/getter methods
	public int getYear() {
		
		return this.year;
	}
	
	//Method to set year:
	//base line 1900, anything above ill allow,
	//if invalid i.e. below 1900, throw exception
	//else set year
	public void setYear(int year) throws IllegalArgumentException{
		
		if(year < 1900) {
			throw new IllegalArgumentException("Enter year above 1900");
		}
		else {
			this.year = year;
			System.out.println("Year set");
		}
	}
	
	
	public int getMonth() {
		
		return this.month;
	}
	
	//set month
	//check valid number
	//throw exception if not
	public void setMonth(int month) throws IllegalArgumentException{
		
		//throw exception if not between 1 & 12
		if(month > 12 || month < 1)
			throw new IllegalArgumentException("Enter a month between 1 & 12 ");
		else {
			this.month = month;
			System.out.println("Month set");
		}
	}
	
	public int getDay() {
		
		return this.day;
	}
	
	
	
	//method to set day:
	//check if between 1 and 31,
	//check if its a leap year,
	//switch the month,
	//make sure each month has the right number of days,
	//make sure February is sorted,
	//i.e. leap year is 29 days, !(NOT)leapYear is 28.
	//set day accordingly, or don't if illegal Argument (exception).
	//** day is always last to be set **//
	public void setDay(int day) throws IllegalArgumentException{
		
		//create exception to be thrown
		IllegalArgumentException error = new IllegalArgumentException("Invalid, set a valid day");
		
		//if out of range, throw exception
		if(day < 1 || day > 31) {
			throw error;
		}
		
		//call method to check if leap year
		boolean leapYear = isLeapYear();
		
		//switching month value
		//throw error if days do not match month
		switch(month) {
			
			case 1:   //January
			case 3:   // March
			case 5:   // May	>>> 31 Days
			case 7:   // July
			case 8:   // August
			case 10:  // October
			case 12:  // December
				if(day <= 31) {
					this.day = day;
					System.out.println("Day set.\n");
				}
				break;
					
			case 4:  // April
			case 6:  // June	>>> 30 Days
			case 9:  // September
			case 11: // November
				if(day <= 30) {
					this.day = day;
					System.out.println("Day set.\n");
				}
				else
					throw error;
				break;
					
			case 2: // February		>>>  28/29 Days
				if(leapYear && (day <= 29)) {
					this.day = day;
					System.out.println("Day set.\n");
				}
					
				else if(!leapYear && (day <= 28)) {
					this.day = day;
					System.out.println("Day set.\n");
				}
				else
					throw error;
				break;
					
					
			default:
				System.out.println("Invalid.. Could not set day.. \n");
		}
			
	}
	
	//Overridden methods
	@Override
	public String toString() {
		
		return day + "/" + month + "/" + year;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Date d;
		boolean y = false;
		
		if(obj == null) {}
		
		else if(obj == this) {
			
			y = true;
		}
		
		else if(obj instanceof Date) {
			
			d = (Date)obj;
			
			if((d.getDay() == this.day) && (d.getMonth() == this.month) && (d.getYear() == this.year)) {
				
				y = true;
			}
		}
		
		return y;
	}
	
	
	//method to check leap year:
	
	// A) The remainder of year divided by 400, equals 0 
	//       its a leap year
	//
	//    OR
	//
	// B) The remainder of year divided by 4, equals 0
	//        AND 
	//    The remainder of year divided by 100, NOT equal 0
	//        its also a leap year
	
	//else false (NOT leapYear)
	//
	//return A OR B >> true if A, true if B.
	private boolean isLeapYear() {
		
		return (year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0)));
	}
	
	
	//method to set date
	//call each method individually
	public void setDate(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
}//end class
