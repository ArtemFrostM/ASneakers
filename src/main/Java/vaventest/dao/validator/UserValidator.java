package vaventest.dao.validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import maventest.dao.DBCConnection;
import maventest.entity.UserSn;

public class UserValidator {

	private Connection connection;
	
	public UserValidator() {
		this.connection = DBCConnection.getInstance().returnConnection();
	}
	
	//Log in
	public boolean checkIfLogInIsWright(String password, String email){
		boolean checkAnswer = false;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		//UserSn userSn = null;
		String query = "select id, nickname, first_name, last_name, user_password, user_email from user_sn where user_email = ? and user_password = ?";
		
		try {
			pstm = connection.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			checkAnswer = rs.next();
//			if(checkAnswer){
//				int id = rs.getInt("id");
//				String nickname = rs.getString("nickname");
//				String firstName = rs.getString("first_name");
//				String lastName = rs.getString("last_name");
//				String userPassword = rs.getString("user_password");
//				String userEmail = rs.getString("user_email");
//				userSn = new UserSn(id, nickname, firstName, lastName, userPassword, userEmail);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return checkAnswer;
	}
}
