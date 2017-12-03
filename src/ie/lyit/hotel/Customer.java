// Name: Ciarán Toman
// Date: 11/11/2017
// Desc: Customer class


package ie.lyit.hotel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Customer extends Person {
	
	
	/**
	 * 	Automatically generated ID
	 */
	private static final long serialVersionUID = 3724185567034222516L;
	//instance variables
	private String emailAddress;
	private int customerNum;
	private static int nextCustNum = 1;
	
	
	//constructors
	
	//default
	//if objects >> to null
	//except customer number
	public Customer() {
		super();
		emailAddress = null;
		customerNum = nextCustNum++;
		
	}
	
	//initialized
	//use person (super) constructor,
	//assign the rest
	public Customer(Name name, String address, String phoneNum, String emailAddress) {
		
		super(name, address, phoneNum);
		this.emailAddress = emailAddress;
		this.customerNum = nextCustNum++; 
	}
	
	
	//Getters/Setters
	
	//get email address method:
	//return email address, type String.
	public String getEmailAddress() {

		return this.emailAddress;
	}

	
	//get customer number method:
	//return customer number
	public int getCustNum() {

		return this.customerNum;
	}

	//set email address method:
	//set email with parameter passed in
	public void setEmailAddress(String emailAddress) {

		this.emailAddress = emailAddress;
	}
	
	
	
	//toString
	@Override
	public String toString() {
		
		return super.toString() +  "\n" +
				 "Email Address: " + getEmailAddress() + "\n" +
					"Customer No. " + getCustNum() + "\n";
	}//end toString
	
	
	
	//equals method
	//testing if null
	//testing this object
	//testing if instance of Customer,
	//if so, cast
	//then test unique Customer No.
	@Override
	public boolean equals(Object obj) {
		
		boolean t = false;
		Customer c;
		
		if(obj == null) {}
		
		else if(this == obj) {
			t = true;
		}
		
		else if(obj instanceof Customer) {
			c = (Customer)obj;
			
			//testing unique Customer Number
			if(this.getCustNum() == c.getCustNum() ) {
				t = true;
			}
		}
		
		return t;
	}//end equals
	
	
	
	//method to set next customer number,
	//so it continues from last known customer No.,
	//i.e. the customer at the end of the list, their number
	//+ 1, + already deleted customers.
	public static void setNextNum(int num) {
		nextCustNum = num;
	}
	
	
	
	
	
	
	//copied code from book class (Lecturer)//
	//******* NOT MY CODE *******///
	
	
	//*** I Edited to take customer details ***//
	// and made customer number JTextField uneditable //
	// and check if the JTextField is null,     //
	// if null, ill assume its a new customer.  //
	// if not null, ill pre-fill details for	//
	// easy editing of an existing customer.	//
	
	
	// The rest is copied from the book class //
	//******* NOT MY CODE *******///
	// read() - To read details from the user	
	public void read(){

		JTextField txtCustomerNo = new JTextField();
		txtCustomerNo.setText("" + this.getCustNum());
		txtCustomerNo.setEditable(false);

		JTextField txtNameTitle = new JTextField();
		if(txtNameTitle != null) {
			txtNameTitle.setText(getName().getTitle());
		}
		txtNameTitle.requestFocus();

		JTextField txtNameF = new JTextField();
		if(txtNameF != null) {
			txtNameF.setText(getName().getFName());
		}

		JTextField txtNameS = new JTextField();
		if(txtNameS != null) {
			txtNameS.setText(getName().getSName());
		}

		JTextField txtAddress = new JTextField();
		if(txtAddress != null) {
			txtAddress.setText(getAddress());
		}

		JTextField txtPhoneNum = new JTextField();
		if(txtPhoneNum != null) {
			txtPhoneNum.setText(getPhoneNum());
		}

		JTextField txtEmailAddress = new JTextField();
		if(txtEmailAddress != null) {
			txtEmailAddress.setText(getEmailAddress());
		}


		Object[] message = {
				"Customer Number:", txtCustomerNo,
				"Title:", txtNameTitle,
				"First Name:", txtNameF,
				"Surname:", txtNameS,
				"Address:", txtAddress,
				"Phone Number:", txtPhoneNum,
				"Email Address:", txtEmailAddress,
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Enter Customer details", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION){
			setName(new Name(txtNameTitle.getText(), txtNameF.getText(), txtNameS.getText()));
			setAddress(txtAddress.getText());
			setPhoneNum(txtPhoneNum.getText());
			setEmailAddress(txtEmailAddress.getText());
		}   
	}//**End of borrowed code**//
	   
	   
	   

}//end class
