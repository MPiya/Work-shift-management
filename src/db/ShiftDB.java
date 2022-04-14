package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Employee;
import model.Shift;


public class ShiftDB implements ShiftDBIF {
	
private static final String insertShift = "insert into Shift (StartTime,Endtime,EmployeeID) values ( ?, ?, ?)";
private static final String deleteShift = "delete from shift where StartTime = ? AND EmployeeID =?   ";
private static final String selectTotalHourBetweenDates = "select Totalhour from Shift WHERE EmployeeID = ? AND  StartTime "
		+ " BETWEEN ?  AND  ?";

private  PreparedStatement insertShiftDB, deleteShiftDB, selectTotalhours;

	public ShiftDB() throws DataAccessException {
	Connection con = DBConnection.getInstance().getConnection();
	try {
	insertShiftDB = con.prepareStatement(insertShift);
	deleteShiftDB = con.prepareStatement(deleteShift);
	selectTotalhours  = con.prepareStatement(selectTotalHourBetweenDates);

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
		
		System.out.println("Shift is set");
		
	}
	
	public void deleteShift(String deleteWantedTime, int customerID) throws SQLException {
		deleteShiftDB.setString(1,deleteWantedTime );
		deleteShiftDB.setInt(2,customerID);
	}
	
	// calculate total between dates interval, this is the algorithm with good complexity to calculate hours which is O(n)
	public  int calculateTotalHoursBetweenDates(int id, String day0, String day1) throws SQLException, DataAccessException {
		int totalHour = 0;
		try {
			selectTotalhours.setInt(1, id);
			selectTotalhours.setString(2, day0);
			selectTotalhours.setString(3, day1);
			ResultSet rs = selectTotalhours.executeQuery();
			while(rs.next()) {
				
				totalHour += rs.getInt("Totalhour");
				}
			System.out.println("Total work hours from employee id " + id + " between dates "
				+ day0 + " and " + day1 + " is " +totalHour + " hours");
			}
		
	 catch (SQLException e ) {	
		 throw new DataAccessException("Could not perform", e);
		}
		
		return totalHour;
	}
	
	
	
}
