package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;

import controller.ShiftController;
import db.DataAccessException;
public class ShiftTest {
	
	public ShiftController shiftCtrl;
@Before
public void setUp() throws DataAccessException, SQLException{
	 shiftCtrl = new ShiftController ();
}

@Test
public void testCalculateTotaHours() throws DataAccessException, SQLException {
   //arrange
	int expected = 14;
	//assert
	 assertEquals(expected, shiftCtrl.calculateTotalHoursBetweenDates(3,"2022-01-01 08:00:00"," 2022-01-02 08:00:00"));
}

@Test
public void shouldDisplay21() throws DataAccessException, SQLException {
	   //arrange
		int expected = 21;
		//assert
		 assertEquals(expected, shiftCtrl.calculateTotalHoursBetweenDates(4,"2022-01-06 08:00:00"," 2022-01-08 08:00:00"));
	}


}
