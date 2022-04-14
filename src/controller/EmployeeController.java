package controller;

import java.sql.SQLException;

import db.DataAccessException;
import db.EmployeeDB;
import db.EmployeeDBIF;

public class EmployeeController {
	private EmployeeDBIF employee;
	public EmployeeController() throws DataAccessException, SQLException {
		this.employee = new EmployeeDB();
	}

	public void createEmployeeinDB(String fname, String lname, String address, String phoneno) throws SQLException {
		employee.createEmployeeinDB(fname,  lname,  address,  phoneno);
	}
	
	public void updatePhoneAndAddress(String address, String phone, int customerID) throws SQLException {
		employee.updatePhoneAndAddress(address,phone,customerID);
	}
	public void deleteEmployee(int id) throws SQLException {
		employee.deleteEmployee(id);
	}
	

}
