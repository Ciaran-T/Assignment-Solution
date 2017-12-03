package ie.lyit.hotel;

public interface CustomerDAO {
	
	public void readRecordsFromFile();
	
	public void writeRecordsToFile();
	
	public void add();
	
	public void list();
	
	public Customer view(String s);
	
	public void edit();
	
	public void delete();

}
