package model;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String address;
	private String telephone;
	private int employeeID;
	

	public Employee(String firstName, String lastName, String address, String telephone, int employeeID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.telephone = telephone;
		this.employeeID = employeeID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	
}
