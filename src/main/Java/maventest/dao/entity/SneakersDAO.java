package maventest.dao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import maventest.dao.JDBCConnection;
import maventest.entity.Sneaker;

public class SneakersDAO {

	private Connection connection;

	public SneakersDAO() throws SQLException, ClassNotFoundException {
		connection = new JDBCConnection().getConnection();
	}

	// ADDING
	public void saveSneaker(Sneaker sneaker) throws SQLException {
		String query = "INSERT INTO sneaker(id, brand, model, year_release, description)"
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setInt(1, sneaker.getId());
		pstm.setString(2, sneaker.getBrand());
		pstm.setString(3, sneaker.getModel());
		pstm.setInt(4, sneaker.getReleaseYear());
		pstm.setString(5, sneaker.getDescription());
		pstm.executeUpdate();
	}

	// UPDATING
	public void updateSneaker(Sneaker sneaker, int id) throws SQLException {
		String query = "UPDATE sneaker SET brand = ? , " + "model = ? , "
				+ "year_release = ? , " + "description = ? " + "WHERE id = ?";
		PreparedStatement pstm = connection.prepareStatement(query);
		// pstm.setInt(1, sneaker.getId());
		pstm.setString(1, sneaker.getBrand());
		pstm.setString(2, sneaker.getModel());
		pstm.setInt(3, sneaker.getReleaseYear());
		pstm.setString(4, sneaker.getDescription());
		pstm.setInt(5, id);
		pstm.executeUpdate();
	}

	// DELETE BY ID
	public void deleteSneaker(int id) throws SQLException {

		String query = "DELETE FROM sneaker WHERE id = ?";
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setInt(1, id);
		pstm.executeUpdate();
	}

	// DELETE BY Model
	public void deleteSneakerByModel(String model) throws SQLException {

		String query = "DELETE FROM sneaker WHERE model = ?";
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setString(1, model);
		pstm.executeUpdate();
	}

	// SHOW ONE BY ID
	public Sneaker showOneSneakerById(int id) throws SQLException {

		String query = "Select a.brand, a.model, a.id, a.year_release, a.description from Sneaker a where a.id = ?";
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setInt(1, id);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String brand = rs.getString("brand");
			String model = rs.getString("model");
			int release = rs.getInt("year_release");
			String description = rs.getString("description");
			Sneaker sneaker = new Sneaker(id, brand, model, release,
					description);
			return sneaker;
		}
		return null;
	}

	// SHOW ONE BY MODEL
	public Sneaker showOneSneaker(String model) throws SQLException {

		String query = "Select a.brand, a.id, a.year_release, a.description from Sneaker a where a.model = ?";
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setString(1, model);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String brand = rs.getString("brand");
			int id = rs.getInt("id");
			int release = rs.getInt("year_release");
			String description = rs.getString("description");
			Sneaker sneaker = new Sneaker(id, brand, model, release,
					description);
			return sneaker;
		}
		return null;
	}

	// SHOW ALL
	public List<Sneaker> showAllSneakers() throws SQLException {

		List<Sneaker> sneakersList = new ArrayList<Sneaker>();
		String query = "Select id, brand, model, year_release, description from Sneaker";
		PreparedStatement pstm = connection.prepareStatement(query);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			Sneaker sneaker = new Sneaker();
			sneaker.setId(rs.getInt(1));
			sneaker.setBrand(rs.getString(2));
			sneaker.setModel(rs.getString(3));
			sneaker.setReleaseYear(rs.getInt(4));
			sneaker.setDescription(rs.getString(5));
			sneakersList.add(sneaker);
		}
		return sneakersList;
	}
}
