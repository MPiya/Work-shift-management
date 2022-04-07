package controller;

import java.sql.SQLException;
import java.time.LocalDate;

import db.DataAccessException;
import db.ShiftDB;
import db.ShiftDBIF;
import model.Employee;

	public class ShiftController {
	private ShiftDB shiftController;
	public ShiftController () throws DataAccessException {
		 shiftController  = new ShiftDB();
	}
	
	public void setShift(String startTime, String endTime, int employeeID) throws SQLException {
		shiftController.setShift(startTime, endTime, employeeID);
	}

	public static void main(String[] args) throws SQLException, DataAccessException {
		ShiftController a = new ShiftController();
		a.setShift( "2022-12-30 10:10", " 2022-12-31 23:11", 1);
	}
}
