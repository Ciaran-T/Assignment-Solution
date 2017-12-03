// Name: Ciarán Toman
// Date: 11/11/2017
// Desc: Person abstract class

package ie.lyit.hotel;

import java.io.Serializable;

public abstract class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5721360722914924711L;
	//instance variables
	private Name name;
	private String address;
	private String phoneNum;
	
	
	//constructors
	public Person() {
		name = new Name();
		address = phoneNum = null;
	}
	
	public Person(Name name, String address, String phoneNum) {
		
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	
	
	//Getters/Setters
	public Name getName() {
		
		return this.name;
	}
	
	public String getAddress() {
		
		return this.address;
	}
	
	public String getPhoneNum() {
		
		return this.phoneNum;
	}
	
	public void setName(Name name) {
		
		this.name.setFName(name.getFName());
		this.name.setSName(name.getSName());
		this.name.setTitle(name.getTitle());
	}
	
	public void setAddress(String address) {
		
		this.address = address;
	}
	
	public void setPhoneNum(String phoneNum) {
		
		this.phoneNum = phoneNum;
	}
	
	
	@Override
	public String toString() {
		
		return name + "\n"
				+ "Address: " + address + "\n"
				+ "Phone Number: " + phoneNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean t = false;
		Person p;
		
		if(obj == null) {}
		
		else if(obj == this) {
			t = true;
		}
		else if(obj instanceof Person) {
			p = (Person)obj;
			
			if((p.getName().equals(this.name)) && (p.getAddress().equalsIgnoreCase(this.address)) 
					&& (p.getPhoneNum().equalsIgnoreCase(this.phoneNum))) {
				t = true;
				
			}
		}
		
		return t;
	} 

}
