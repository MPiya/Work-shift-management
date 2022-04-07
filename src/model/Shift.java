package model;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
public class Shift {
private LocalDate date;
private String startTime;
private String EndTime;
private Employee employee;
private int totalhour;
private Location location;
public Shift(LocalDate date, String startTime, String endTime, Employee employee,Location location) {
	super();
	this.date = date;
	this.startTime = startTime;
	EndTime = endTime;
	this.employee = employee;
	
	this.location = location;
	
}

public Location getLocation() {
	return location;
}
public void setLocation(Location location ) {
	this.location = location;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return EndTime;
}
public void setEndTime(String endTime) {
	EndTime = endTime;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public int getTotalhour() {
	return totalhour;
}
public void setTotalhour(int totalhour) {
	this.totalhour = totalhour;
}

}


