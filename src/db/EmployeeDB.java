package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDB implements EmployeeDBIF{
	private static final String createeEmployee = "INSERT INTO Employee(FirstName,LastName,Address,Phone)"
			+ " VALUES ( ?,?,?,?)";
	private PreparedStatement createEmp;
	DBConnection con = new DBConnection();
	public EmployeeDB() throws DataAccessException, SQLException {
		
		createEmp = DBConnection.getInstance().getConnection()
				.prepareStatement(createeEmployee);
	}
	


public void createEmployeeinDB(String fname, String lname, String address, String phoneno) throws SQLException {
createEmp.setString(1,fname);
createEmp.setString(2,lname);
createEmp.setString(3,address);
createEmp.setString(4,phoneno);
createEmp.executeUpdate();
con.disconnect();

   }
}
