package maventest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnection {
	
	private Connection connection = null;
	
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://localhost:3306/sneakers";
		String user = "root";
		String password = "gunit7887";

		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connected? " + !connection.isClosed());
		return connection;
	}

}
