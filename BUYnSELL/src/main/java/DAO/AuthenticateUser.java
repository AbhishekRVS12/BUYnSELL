package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class AuthenticateUser {
	
	public static boolean authenticate(String username, String password) {
        // Preliminary check to ensure inputs are not null or excessively long
		
		//System.out.println(username);
        //System.out.println(password);
		
        if(username == null || password == null || username.length() > 50 || password.length() > 50) {
            return false;
        }
        
        else {
        String sql = "SELECT password FROM user_info WHERE username = ?";

        try (Connection conn = DbConnect.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
        	
        	//System.out.println(username);
             
            statement.setString(1, username);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                String storedPasswordHash = resultSet.getString("password");
                //System.out.println("hi");
                //System.out.println(storedPasswordHash);
                /*if(password.equals(storedPasswordHash)) {
                	return true;
                }*/
                if (BCrypt.checkpw(password, storedPasswordHash)) {
                	//System.out.println("hi");
                    return true;
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // In a real application, log this exception with a logging framework.
        }
        }
        return false; // Default to false if no match or an error occurs
    }

}
