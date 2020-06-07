package it.molis.istat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBConnect {
	/*
	 * public static Connection getConnection() {
	 * 
	 * SQLServerDataSource ds = new SQLServerDataSource();
	 * 
	 * ds.setUser("SA"); ds.setPassword("********"); ds.setServerName("localhost");
	 * ds.setPortNumber(1433); ds.setDatabaseName("istat");
	 * 
	 * try { Connection c = ds.getConnection(); return c; } catch (SQLException e) {
	 * ds = null; // e.printStackTrace(); return null; }
	 */
	public static Connection getConnection() {

		String jdbcURL = "jdbc:mysql://localhost/istat?user=ilMolis&password=ilMolis";

		try {
			Connection c = DriverManager.getConnection(jdbcURL);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
