package maventest.dao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import maventest.dao.DBCConnection;
import maventest.entity.Sneaker;
import maventest.entity.UserSn;

public class UserSnDAO {

	private Connection connection;

	public UserSnDAO() {
		this.connection = DBCConnection.getInstance().returnConnection();
	}

	public void createUser(UserSn userSn) {
		String query = "Insert into user_sn (id, nickname, first_name, last_name, user_email, user_password) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, userSn.getId());
			ps.setString(2, userSn.getNickname());
			ps.setString(3, userSn.getFirstName());
			ps.setString(4, userSn.getLastName());
			ps.setString(5, userSn.getEmail());
			ps.setString(6, userSn.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {

		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// SHOW ALL USERS
	public List<UserSn> showAllUsers() {

		List<UserSn> users = new ArrayList<UserSn>();
		String query = "select id, nickname, first_name, last_name, user_password, user_email from user_sn";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserSn userSn = new UserSn();
				userSn.setId(rs.getInt(1));
				userSn.setNickname(rs.getString(2));
				userSn.setFirstName(rs.getString(3));
				userSn.setLastName(rs.getString(4));
				userSn.setPassword(rs.getString(5));
				userSn.setEmail(rs.getString(6));
				users.add(userSn);
			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	//SHOW ONE BY ID
	public UserSn showOneUserById(int id){
		
		String query = "select id, nickname, first_name, last_name, user_password, user_email from user_sn where id = ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		UserSn userSn = null;
		
		try {
			pstm = connection.prepareStatement(query);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next()){
				String nickname = rs.getString("nickname");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String userPassword = rs.getString("user_password");
				String userEmail = rs.getString("user_email");
				userSn = new UserSn(id, nickname, firstName, lastName, userPassword, userEmail);
			}
			
		} catch (SQLException e) {
			e.getMessage();
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
		return userSn;
	}
	
	//SHOW USER'S Sneakers
	public UserSn showUsersSneakers(int id){
		PreparedStatement pstm = null;
		String query = "select u.id, u.nickname, u.first_name, u.last_name, u.user_password, u.user_email,"// from user_sn u where u.id = ?";
				+ "s.brand, s.model, s.id, s.year_release, s.description from sneakers_users su "
				+ "join user_sn u on u.id = su.id_user "
				+ "join sneaker s on s.id = su.id_sneaker "
				+ "where u.id = ?";
		ResultSet rs = null;
		UserSn userSn = null;
		List<Sneaker> sneakers = new ArrayList<Sneaker>();
		
		try {
			pstm = connection.prepareStatement(query);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			userSn = this.showOneUserById(id);
			
			while (rs.next()) {
				Sneaker sneaker = new Sneaker();
				sneaker.setId(rs.getInt("s.id"));
				sneaker.setBrand(rs.getString("s.brand"));
				sneaker.setModel(rs.getString("s.model"));
				sneaker.setReleaseYear(rs.getInt("s.year_release"));
				sneaker.setDescription(rs.getString("s.description"));
				sneakers.add(sneaker);
				
//				String nickname = rs.getString("nickname");
//				String firstName = rs.getString("first_name");
//				String lastName = rs.getString("last_name");
//				String userPassword = rs.getString("user_password");
//				String userEmail = rs.getString("user_email");
				//userSn = new UserSn(id, nickname, firstName, lastName, userPassword, userEmail);
				if(sneakers != null){
					userSn.setSneakers(sneakers);
				}
			}
		} catch (SQLException e) {
			e.getMessage();
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
		
		return userSn;
	}
	
	//EDIT USER
	public void editUser(UserSn userSn, int id){
		PreparedStatement pstm = null;
		String query = "UPDATE user_sn SET nickname = ? , " + "first_name = ? , "
				+ "last_name = ? , " + "user_password = ? , " + "user_email = ? " + "WHERE id = ?";
		
		try {
			pstm = connection.prepareStatement(query);
			pstm.setString(1, userSn.getNickname());
			pstm.setString(2, userSn.getFirstName());
			pstm.setString(3, userSn.getLastName());
			pstm.setString(4, userSn.getPassword());
			pstm.setString(5, userSn.getEmail());
			pstm.setInt(6, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//DELETE USER
	public void deleteUserById(int id){
		PreparedStatement pstm = null;
		String query = "delete from user_sn where id = ?";
		
		try {
			pstm = connection.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
