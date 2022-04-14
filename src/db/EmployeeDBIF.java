package db;

import java.sql.SQLException;

public interface EmployeeDBIF {

	public void createEmployeeinDB(String fname, String lname, String address, String phoneno) throws SQLException;
	public void updatePhoneAndAddress(String address, String phone, int customerID) throws SQLException;
	public void deleteEmployee(int id) throws SQLException;
}
