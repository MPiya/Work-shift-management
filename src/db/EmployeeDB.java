package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDB implements EmployeeDBIF{
	private static final String createeEmployee = "INSERT INTO Employee(FirstName,LastName,Address,Phone)"
			+ " VALUES ( ?,?,?,?)";
	private static final String changeAddAndPhone = "UPDATE Employee SET Address = ?, Phone = ? WHERE EmployeeID = ? ";
	private static final String deleteEmployee = " Delete from Employee where EmployeeID = ? ";
	private static final String deleteShift =" Delete from Shift where EmployeeID = ?";
	private PreparedStatement createEmp,changeAddressAndPhone,deleteEmp, deleteShiftDB;
	DBConnection con = DBConnection.getInstance();
	
	public EmployeeDB() throws DataAccessException, SQLException {
		
		createEmp = DBConnection.getInstance().getConnection()
				.prepareStatement(createeEmployee);
		changeAddressAndPhone = DBConnection.getInstance().getConnection()
				.prepareStatement(changeAddAndPhone);
		deleteEmp = DBConnection.getInstance().getConnection()
				.prepareStatement(deleteEmployee);
		deleteShiftDB=DBConnection.getInstance().getConnection()
				.prepareStatement(deleteShift);
	}
	
public void createEmployeeinDB(String fname, String lname, String address, String phoneno) throws SQLException {
createEmp.setString(1,fname);
createEmp.setString(2,lname);
createEmp.setString(3,address);
createEmp.setString(4,phoneno);
createEmp.executeUpdate();

   }

public void updatePhoneAndAddress(String address, String phone, int customerID) throws SQLException {
	changeAddressAndPhone.setString(1,address);
	changeAddressAndPhone.setString(2,phone);
	changeAddressAndPhone.setInt(3,customerID);
	changeAddressAndPhone.executeUpdate();
	
}

// The reason  that shift has to be deleted before employee before in there is Employee id column
//in Shift table, it is a constraint.
public void deleteEmployee(int id) throws SQLException {
	deleteShiftDB.setInt(1, id);
	deleteShiftDB.executeUpdate();
	deleteEmp.setInt(1, id);
	deleteEmp.executeUpdate();
}
}
