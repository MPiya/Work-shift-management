package db;



import java.sql.SQLException;
import java.time.LocalDate;

import model.Employee;
import model.Shift;

public interface ShiftDBIF {


	void setShift( String startTime, String endTime, int employeeID)  throws SQLException;
}
