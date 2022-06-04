package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionService;
import Models.UserCredentials;

public class UserCredDaoImpl implements UserCredDao {

	@Override
	public void insertUserCred(UserCredentials user) {
		String sqlString = "INSERT INTO user_cred(id, username, pass) VALUES(?,?,?)";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setInt(1, user.getId());
			pStatement.setString(2, user.getUsername());
			pStatement.setString(3, user.getPassword());
			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserCredentials selectUserByID(int id) {
		String sqString = "SELECT * FROM user_cred WHERE id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setInt(1, id);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()) {
				return new UserCredentials(rSet.getInt("id"), 
						rSet.getString("username"),
						rSet.getString("pass"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserCredentials selectUserByUsername(String username) {
		String sqString = "SELECT * FROM user_cred WHERE username=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setString(1, username);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()) {
				return new UserCredentials(rSet.getInt("id"),
						rSet.getString("username"), 
						rSet.getString("pass"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserCredentials> selectAllUser() {
		String sqString = "SELECT * FROM user_cred";
		
		Connection connection = ConnectionService.ReturnConnection();
		List<UserCredentials> userList = new ArrayList<>();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			ResultSet rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				UserCredentials user = new UserCredentials(rSet.getInt("id"), 
					rSet.getString("username"), 
					rSet.getString("pass"));
				
				userList.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void updatePassword(UserCredentials user, String password) {
		String sqlString = "UPDATE user_cred SET pass=? WHERE id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setString(1, password);
			pStatement.setInt(2, user.getId());

			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(UserCredentials user) {
		String sqlString = "DELETE FROM user_cred WHERE id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setInt(1, user.getId());

			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
