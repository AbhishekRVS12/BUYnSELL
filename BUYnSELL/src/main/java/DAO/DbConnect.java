package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl"; 
	//String dbURL = "jdbc:oracle:thin:sys/orapass@localhost:1521:SoftwareSecurity";
    private static final String USER = "SYS as SYSDBA"; 
    private static final String PASS = "orapass"; 
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; 
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            //System.out.println("Database connection established");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return conn;
    }
	
}