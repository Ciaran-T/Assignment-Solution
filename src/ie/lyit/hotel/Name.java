// Name: Ciarán Toman
// Date: 11/11/2017
// Desc: Name class

package ie.lyit.hotel;

import java.io.Serializable;

public class Name implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4133069725638916698L;
	//instance variables
	private String fName;
	private String sName;
	private String title;
	
	//constructors
	public Name() {
		fName = sName = title = null;
	}
	
	public Name(String t, String fN, String sN) {
		
		this.fName = fN;
		this.sName = sN;
		this.title = t;
	}
	
	//Getters/Setters
	public String getFName() {
		
		return this.fName;
	}
	
	public void setFName(String fName) {
		
		this.fName = fName;
		
	}
	
	public String getSName() {
		
		return this.sName;
	}
	
	public void setSName(String sName) {
		
		this.sName = sName;
	}
	
	public String getTitle() {
		
		return this.title;
	}
	
	public void setTitle(String title) {
		
		this.title = title;
		
	}
	
		
	@Override
	public String toString() {
		
		return title + " " + fName 
				+ " " + sName;
	}
	
	//equals method:
	//testing if null
	//testing this object
	//testing if instance of Name,
	//if so, cast
	//then test all name instance fields
	//ignoring case
	@Override
	public boolean equals(Object obj) {
		
		Name n;
		boolean y = false;
		
		if(obj == null) {}
		
		else if(obj == this) {
			y = true;
		}
		
		else if(obj instanceof Name) {
			
			n = (Name)obj;
			
			if((this.fName.equalsIgnoreCase(n.getFName())) && 
					(this.sName.equalsIgnoreCase(n.getSName())) 
					&& (this.title.equalsIgnoreCase(n.getTitle()))) {
				y = true;
			}
		}
		
		return y;
	}
	
	
	//check if female by title
	//ignoring case
	public boolean isFemale() {
		
		if(title.equalsIgnoreCase("Miss") || (title.equalsIgnoreCase("Ms")) 
				|| (title.equalsIgnoreCase("Mrs"))) {
			
			return true;
		}
		
		else {
			return false;
		}
	}
	
}//end class
