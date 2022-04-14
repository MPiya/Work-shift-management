package db;



import java.sql.SQLException;
import java.time.LocalDate;

import model.Employee;
import model.Shift;

public interface ShiftDBIF {


	void setShift( String startTime, String endTime, int employeeID)  throws SQLException;
	public void deleteShift(String deleteWantedTime, int customerID) throws SQLException;
	public  int calculateTotalHoursBetweenDates(int id, String day0, String day1) throws SQLException, DataAccessException;
}
