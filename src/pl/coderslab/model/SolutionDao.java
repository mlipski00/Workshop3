package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.utils.DbUtil;

public class SolutionDao {

	public void saveToDB(Solution solution) throws SQLException {
		Connection conn = DbUtil.getConn();
		PreparedStatement prepStat;
		ResultSet rs = null;
		if (solution.getId() == 0) {
			String sql = "INSERT INTO solution (created, updated, description, excercise_id, user_id) VALUES (?, ?, ?, ?, ?);";
			String columnNames[] = { "ID" };
			prepStat = conn.prepareStatement(sql, columnNames);
			prepStat.setTimestamp(1, solution.getCreated());
			prepStat.setTimestamp(2, solution.getUpdated());
			prepStat.setString(3, solution.getDescription());
			prepStat.setInt(4, solution.getExcercise_id());
			prepStat.setInt(5, solution.getUser_id());
			prepStat.executeUpdate();
			rs = prepStat.getGeneratedKeys();
			if (rs.next()) {
				solution.setId(rs.getInt(1));
			}
		} else {
			String sql = "UPDATE solution SET updated=?, excercise_id=? WHERE id=?";
			java.util.Date javaDate = new java.util.Date();
			long javaTime = javaDate.getTime();
			solution.setUpdated(new Timestamp(javaTime));
			prepStat = conn.prepareStatement(sql);
			prepStat.setTimestamp(1, solution.getUpdated());
			prepStat.setInt(2, solution.getExcercise_id());
			prepStat.setInt(3, solution.getId());
			prepStat.executeUpdate();
		}
		rs.close();
		prepStat.close();
		conn.close();
	}


	static public Solution loadSolutionById(int id) throws SQLException {
		Connection conn = DbUtil.getConn();
		String sql = "SELECT * FROM solution WHERE ID = ?;";
		PreparedStatement prepStat = conn.prepareStatement(sql);
		prepStat.setInt(1, id);
		ResultSet rs = prepStat.executeQuery();
		if (rs.next()) {
			Solution solution = new Solution();
			solution.setId(rs.getInt(1));
			solution.setCreated(rs.getTimestamp(2));
			solution.setUpdated(rs.getTimestamp(3));
			solution.setDescription(rs.getString(4));
			solution.setExcercise_id(rs.getInt(5));
			solution.setUser_id( rs.getInt(6));
			return solution;
		}
		rs.close();
		prepStat.close();
		conn.close();
		return null;
	}

	static public List<Solution> loadAllSolutions() throws SQLException {
		Connection conn = DbUtil.getConn();
		String sql = "SELECT * FROM solution;";
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		PreparedStatement prepStat = conn.prepareStatement(sql);
		ResultSet rs = prepStat.executeQuery();
		while (rs.next()) {
			Solution solution = new Solution();
			solution.setId(rs.getInt(1));
			solution.setCreated(rs.getTimestamp(2));
			solution.setUpdated(rs.getTimestamp(3));
			solution.setDescription(rs.getString(4));
			solution.setExcercise_id(rs.getInt(5));
			solution.setUser_id( rs.getInt(6));
			solutions.add(solution);
		}
		rs.close();
		prepStat.close();
		conn.close();
		return solutions;
	}
	
	static public List<Solution> loadAllSolutions(int rows) throws SQLException {
		Connection conn = DbUtil.getConn();
		String sql = "SELECT * FROM solution ORDER BY created DESC LIMIT ?";
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		PreparedStatement prepStat = conn.prepareStatement(sql);
		prepStat.setInt(1, rows);
		ResultSet rs = prepStat.executeQuery();
		while (rs.next()) {
			Solution solution = new Solution();
			solution.setId(rs.getInt(1));
			solution.setCreated(rs.getTimestamp(2));
			solution.setUpdated(rs.getTimestamp(3));
			solution.setDescription(rs.getString(4));
			solution.setExcercise_id(rs.getInt(5));
			solution.setUser_id( rs.getInt(6));
			solutions.add(solution);
		}
		rs.close();
		prepStat.close();
		conn.close();
		return solutions;
	}
	
	static public List<Solution> loadAllSolutionsByUserID (int id) throws SQLException {
		Connection conn = DbUtil.getConn();
		String sql = "SELECT * FROM solution WHERE user_id = ?";
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		PreparedStatement prepStat = conn.prepareStatement(sql);
		prepStat.setInt(1, id);
		ResultSet rs = prepStat.executeQuery();
		while (rs.next()) {
			Solution solution = new Solution();
			solution.setId(rs.getInt(1));
			solution.setCreated(rs.getTimestamp(2));
			solution.setUpdated(rs.getTimestamp(3));
			solution.setDescription(rs.getString(4));
			solution.setExcercise_id(rs.getInt(5));
			solution.setUser_id( rs.getInt(6));
			solutions.add(solution);
		}
		rs.close();
		prepStat.close();
		conn.close();
		return solutions;
	}
	
	public static List<Solution> loadAllByExerciseId (int id) throws SQLException {
		Connection conn = DbUtil.getConn();
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM solution WHERE excercise_id = ?";
		PreparedStatement prepStat = conn.prepareStatement(sql);
		prepStat.setInt(1, id);
		ResultSet rs = prepStat.executeQuery();
		while (rs.next()) {
			Solution solution = new Solution();
			solution.setId(rs.getInt(1));
			solution.setCreated(rs.getTimestamp(2));
			solution.setUpdated(rs.getTimestamp(3));
			solution.setDescription(rs.getString(4));
			solution.setExcercise_id(rs.getInt(5));
			solution.setUser_id( rs.getInt(6));
			solutions.add(solution);
		}
		rs.close();
		prepStat.close();
		conn.close();
		return solutions;
	}
	
	
	public void delete(Solution solution) throws SQLException {
		Connection conn = DbUtil.getConn();
		if (solution.getId() != 0) {
			String sql = "DELETE FROM solution WHERE id = ?;";
			PreparedStatement prepStat = conn.prepareStatement(sql);
			prepStat.setInt(1, solution.getId());
			prepStat.executeUpdate();
			solution.setId(0);
			prepStat.close();
			conn.close();
		}
	}
	
}
