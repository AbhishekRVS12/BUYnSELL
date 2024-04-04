package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

	public static Map<String, String> getUserByUsername(String username) {
        String query = "SELECT * FROM user_info WHERE username = ?";
        Map<String, String> user = new HashMap<>();

        try (Connection conn = DbConnect.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
             
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
            	user.put("username", rs.getString("username"));
                user.put("password", rs.getString("password"));
                user.put("email", rs.getString("email"));
                user.put("phone", rs.getString("phone"));
                user.put("role", rs.getString("role"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Proper error handling/logging should be done here
        }

        return user;
    }
	
	public static boolean registerUser(String username, String password, String email, String phone, String role) {
		
		String sql = "INSERT INTO user_info(username, password, email, phone, role) VALUES(?, ?, ?, ?, ?)";
		System.out.println(password);
		
		String hashedpwd = BCrypt.hashpw(password, BCrypt.gensalt());


        try (Connection conn = DbConnect.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
             
        	statement.setString(1, username);
        	statement.setString(2, hashedpwd);
        	statement.setString(3, email);
        	statement.setString(4, phone);
        	statement.setString(5, role);
        	int rowsInserted = statement.executeUpdate();
        	
        	if (rowsInserted > 0) {
        		System.out.println("User added");
        		conn.close();
                return true; // User registered successfully
                
            } 
        	else {
        		conn.close();
                return false; // User registration failed
            }
        }
        	catch (SQLException e) {
                // Handle any SQL errors
                e.printStackTrace();
                return false;
        	}
	}

	public static boolean updatePassword(String username, String oldPassword, String newPassword) {
		// TODO Auto-generated method 

		String sql = "UPDATE user_info SET password = ? WHERE username = ?";
		
		
		try (Connection conn = DbConnect.getConnection();
	             PreparedStatement statement = conn.prepareStatement(sql)) {
			
			
			if(AuthenticateUser.authenticate(username, oldPassword)) {
				
				statement.setString(1, BCrypt.hashpw(newPassword, BCrypt.gensalt()));
				statement.setString(2, username);
				
				int rowsInserted = statement.executeUpdate();
				
				if(rowsInserted>0) {
					conn.close();
					return true;
				}
				else {
					conn.close();
					return false;
				}
				
			}
			else {
				conn.close();
				return false;
			}
			
			//conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean userComments(String name, String email, String phone, String comments) {
		// TODO Auto-generated method stub
		String sql = "insert into user_comments(uname, email, phone, comments) values (?,?,?,?)";
		
		try (Connection conn = DbConnect.getConnection();
	             PreparedStatement statement = conn.prepareStatement(sql)) {
			
			statement.setString(1, name);
        	statement.setString(2, email);
        	statement.setString(3, phone);
        	statement.setString(4, comments);
        	int rowsInserted = statement.executeUpdate();
        	
        	if(rowsInserted>0) {
        		conn.close();
        		return true;
        	}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
