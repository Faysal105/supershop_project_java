public class Customer{
	private String name;
	private String number;
	private String address;
	private String password;

	
	public Customer(String name, String number, String address, String password){
		this.name = name;
		this.number = number;
		this.address = address;
		this.password = password;

	}
	public void setName(String name){
		this.name = name;
	}
	public void setNumber(String number){
		this.number = number;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	
	public String getName(){
		return name;
	}
	public String getNumber(){
		return number;
	}
	public String getAddress(){
		return address;
	}
	public String getPassword(){
		return password;
	}

}