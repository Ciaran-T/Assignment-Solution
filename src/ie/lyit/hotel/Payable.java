// Name: Ciarán Toman
// Date: 11/11/2017
// Desc: Payable Interface

package ie.lyit.hotel;

public interface Payable {
	
	public double calculateWage(double taxPercentage);
	
	public double incrementSalary(double incrementAmount);

}

