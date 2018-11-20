package maventest.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import maventest.dao.entity.SneakersDAO;
import maventest.dao.entity.UserSnDAO;
import maventest.entity.Sneaker;
import maventest.entity.UserSn;


public class Main {

	
		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			
//			Sneaker sneaker = new Sneaker("New Balance", "993", 1993, "Jesus they're cooler than me!");
			SneakersDAO dao = new SneakersDAO();
//			dao.saveSneaker(sneaker);
//			
//			System.out.println(dao.showOneSneakerById(7));
//			
//			List<Sneaker> sneakers = dao.showAllSneakers();
//			
//			System.out.println(sneakers.toString());
			
			//System.out.println(dao.showOneSneaker("Yeezy"));
			
//			dao.deleteSneakerByModel("null");
			
			//System.out.println(dao.showOneSneaker("993"));
			
			UserSnDAO snDao = new UserSnDAO();
			//UserSn userSn = snDao.showUsersSneakers(1);
			//System.out.println(userSn);
			UserSn userSn1 = new UserSn("nickname", "firstName", "lastName", "password", "email");
			snDao.createUser(userSn1);
			//List<UserSn> users = snDao.showAllUsers();
			//List<Sneaker> sneakers = userSn.getSneakers();
			//System.out.println(sneakers);
			//snDao.editUser(userSn, userSn.getId());
			//snDao.deleteUserById(2);
			
//			Sneaker sneaker = new Sneaker(3, "brand", "model", 2222, "description");
//			dao.updateSneaker(sneaker, sneaker.getId());
			//System.out.println(userSn);
			//snDao.createUser(userSn);
			
			List<UserSn> users = snDao.showAllUsers();
			
			System.out.println(users.toString());
			
			//List<Sneaker> sneakers = dao.showAllSneakers();
			
			//System.out.println(sneakers.toString());
			
			
			
			
		}
}
