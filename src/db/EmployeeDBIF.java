package db;

import java.sql.SQLException;

public interface EmployeeDBIF {

	public void createEmployeeinDB(String fname, String lname, String address, String phoneno) throws SQLException;
}
