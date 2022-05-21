package controller;

import java.sql.SQLException;
import java.time.LocalDate;

import db.DataAccessException;
import db.ShiftDB;
import db.ShiftDBIF;
import model.Employee;

	public class ShiftController {
	private ShiftDBIF shiftDatabase;
	
	public ShiftController () throws DataAccessException {
		shiftDatabase = new ShiftDB();
	}
	
	public void setShift(String startTime, String endTime, int employeeID) throws SQLException {
		shiftDatabase.setShift(startTime, endTime, employeeID);
	}
	
	public  int calculateTotalHoursBetweenDates(int id, String day0, String day1) throws SQLException, DataAccessException {
		int totalhours = shiftDatabase.calculateTotalHoursBetweenDates(id, day0, day1);
		 return totalhours;
	}
	
	public void deleteShift(String deleteWantedTime, int customerID) throws SQLException {
		shiftDatabase.deleteShift(deleteWantedTime, customerID);
	}

	
	
	
}
