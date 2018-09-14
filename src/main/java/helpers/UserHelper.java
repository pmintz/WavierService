package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojos.User;

public class UserHelper {
	
	private PreparedStatement authenticateUserStatement;
	
	public UserHelper(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL.US.DELOITTE.COM");
			authenticateUserStatement = conn.prepareStatement("select * from user where username=? and password=?");
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
	}
	
	public User authenticateUser(String username, String password){
		User user = null;
		try{
			authenticateUserStatement.setString(1, username);
			authenticateUserStatement.setString(2, password);
			ResultSet rs = authenticateUserStatement.executeQuery();
			if(rs.next()){
				user = new User(rs.getInt("personid"), rs.getString("lastname"), 
						rs.getString("firstname"), rs.getString("username"), rs.getString("password"), rs.getString("wavier"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return user;
	}

}
