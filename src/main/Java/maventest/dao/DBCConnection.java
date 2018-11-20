package maventest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBCConnection {
	private Connection connection = null;
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/sneakers?verifyServerCertificate=false&useSSL=true";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "gunit7887";
	
	private static DBCConnection dbcConnection;
	
	public static DBCConnection getInstance(){
		if (dbcConnection == null) {
			dbcConnection = new DBCConnection();
            return dbcConnection;
        } else {
            return dbcConnection;
        }
	}
	
	
	
	private DBCConnection () {
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
		}
	}
	
	public Connection returnConnection(){
		return connection;
	}
}
