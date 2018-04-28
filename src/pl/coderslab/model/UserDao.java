package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.utils.DbUtil;

public class UserDao {

	public static void saveToDB(User user) throws SQLException {
		Connection conn = DbUtil.getConn();
		if (user.getId() == 0) {
			String sql = "INSERT INTO Users(username, email, password) VALUES (?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				user.setId( rs.getInt(1));
			}
		} else {
			String sql = "UPDATE Users SET username=?, email=?, password=? where id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, user.getId());
			preparedStatement.executeUpdate();
		}
	}
	public static User loadUserById(int id) throws SQLException {
		Connection conn = DbUtil.getConn();
		String sql = "SELECT * FROM Users where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			User loadedUser = new User();
			loadedUser.setId(resultSet.getInt("id"));
			loadedUser.setUsername(resultSet.getString("username"));
			loadedUser.setPassword(resultSet.getString("password"));
			loadedUser.setEmail(resultSet.getString("email"));
			return loadedUser;
		}
		return null;
	}

	public static List<User> loadAllUsers() throws SQLException {
		Connection conn = DbUtil.getConn();
		ArrayList<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM Users";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			User loadedUser = new User();
			loadedUser.setId(resultSet.getInt("id"));
			loadedUser.setUsername(resultSet.getString("username"));
			loadedUser.setPassword(resultSet.getString("password"));
			loadedUser.setEmail(resultSet.getString("email"));
			users.add(loadedUser);
		}
		return users;
	}

	public static List<User> loadAllByGrupId(int id) throws SQLException {
		Connection conn = DbUtil.getConn();
		ArrayList<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users WHERE person_group_id = ?";
		PreparedStatement prepStat = conn.prepareStatement(sql);
		prepStat.setInt(1, id);
		ResultSet resultSet = prepStat.executeQuery();
		while (resultSet.next()) {
			User loadedUser = new User();
			loadedUser.setId(resultSet.getInt("id"));
			loadedUser.setUsername(resultSet.getString("username"));
			loadedUser.setPassword(resultSet.getString("password"));
			loadedUser.setEmail(resultSet.getString("email"));
			users.add(loadedUser);
		}
		return users;

	}

	public static void delete(User user) throws SQLException {
		Connection conn = DbUtil.getConn();
		if (user.getId() != 0) {
			String sql = "DELETE FROM Users WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.executeUpdate();
			user.setId(0);
		}
	}
}
