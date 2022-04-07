package db;

public class DataAccessException extends Exception {
	public DataAccessException(String expl, Exception e) {
		super(expl, e);
	}
}
