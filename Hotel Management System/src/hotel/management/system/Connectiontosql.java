package hotel.management.system;

import java.sql.*;

public class Connectiontosql {
	Connection c;
	Statement s;
	
	public Connectiontosql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///projecthms?autoReconnect=true&useSSL=false","root","root");
			s = c.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
