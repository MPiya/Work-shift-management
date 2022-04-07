package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Employee;
import model.Shift;


public class ShiftDB implements ShiftDBIF {
	

static final String insertShift = "insert into Shift (StartTime,Endtime,EmployeeID) values ( ?, ?, ?)";


private PreparedStatement insertShiftDB;

	public ShiftDB() throws DataAccessException {
	Connection con = DBConnection.getInstance().getConnection();
	try {
	insertShiftDB = con.prepareStatement(insertShift);

	} catch (SQLException e) {
	throw new DataAccessException("Could not set the shift", e);
	}
	}
					//Set shift with these arguments
	public void setShift( String startTime, String endTime, int employeeID) throws SQLException {
		
		
		insertShiftDB.setString(1,startTime);
		insertShiftDB.setString(2,endTime);
		insertShiftDB.setInt(3,employeeID);
		insertShiftDB.executeUpdate();
		
		
	}
}
