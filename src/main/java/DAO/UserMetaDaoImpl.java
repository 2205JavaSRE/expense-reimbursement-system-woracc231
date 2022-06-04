package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionService;
import Models.UserCredentials;
import Models.UserMeta;

public class UserMetaDaoImpl implements UserMetaDao {

	@Override
	public void insertUserMeta(UserMeta user) {
		String sqlString = "INSERT INTO user_meta(id, user_id, firstname, lastname, finance_manager) VALUES(?,?,?,?,?)";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setInt(1, user.getId());
			pStatement.setInt(2, user.getUserID());
			pStatement.setString(3, user.getFirstName());
			pStatement.setString(4, user.getLastName());
			pStatement.setBoolean(5, user.getIsFinanceManager());
			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public UserMeta selectUserByMetaID(int metaID) {
		String sqString = "SELECT * FROM user_meta WHERE id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setInt(1, metaID);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()) {
				return new UserMeta(rSet.getInt("id"), 
						rSet.getInt("user_id"),
						rSet.getString("firstname"),
						rSet.getString("lastname"),
						rSet.getBoolean("finance_manager"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserMeta selectUserByUserID(int userID) {
		String sqString = "SELECT * FROM user_meta WHERE user_id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setInt(1, userID);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()) {
				return new UserMeta(rSet.getInt("id"), 
						rSet.getInt("user_id"),
						rSet.getString("firstname"),
						rSet.getString("lastname"),
						rSet.getBoolean("finance_manager"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserMeta> selectUserByFirstName(String firstName) {
		String sqString = "SELECT * FROM user_meta WHERE firstname=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		List<UserMeta> userList = new ArrayList<>();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setString(1, firstName);
			ResultSet rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				UserMeta user = new UserMeta(rSet.getInt("id"), 
						rSet.getInt("user_id"),
						rSet.getString("firstname"),
						rSet.getString("lastname"),
						rSet.getBoolean("finance_manager"));
				
				userList.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<UserMeta> selectUserByLastName(String lastName) {
		String sqString = "SELECT * FROM user_meta WHERE lastname=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		List<UserMeta> userList = new ArrayList<>();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setString(1, lastName);
			ResultSet rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				UserMeta user = new UserMeta(rSet.getInt("id"), 
						rSet.getInt("user_id"),
						rSet.getString("firstname"),
						rSet.getString("lastname"),
						rSet.getBoolean("finance_manager"));
				
				userList.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<UserMeta> selectAllUserMetas() {
		String sqString = "SELECT * FROM user_meta";
		
		Connection connection = ConnectionService.ReturnConnection();
		List<UserMeta> userList = new ArrayList<>();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			ResultSet rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				UserMeta user = new UserMeta(rSet.getInt("id"), 
						rSet.getInt("user_id"),
						rSet.getString("firstname"),
						rSet.getString("lastname"),
						rSet.getBoolean("finance_manager"));
				
				userList.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void updateUserMetaFirstName(UserMeta user, String firstName) {
		String sqlString = "UPDATE user_meta SET firstname=? WHERE user_id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setString(1, firstName);
			pStatement.setInt(2, user.getUserID());

			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUserMetaLastName(UserMeta user, String lastName) {
		String sqlString = "UPDATE user_meta SET lastname=? WHERE user_id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setString(1, lastName);
			pStatement.setInt(2, user.getUserID());

			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserMetaFinanceManagerStatus(UserMeta user, Boolean isFM) {
		String sqlString = "UPDATE user_meta SET finance_manager=? WHERE user_id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setBoolean(1, isFM);
			pStatement.setInt(2, user.getUserID());

			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUserMeta(UserMeta user) {
		String sqlString = "DELETE FROM user_cred WHERE user_id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setInt(1, user.getUserID());

			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
