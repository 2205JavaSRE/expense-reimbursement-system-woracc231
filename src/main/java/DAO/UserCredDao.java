package DAO;

import java.util.List;

import Models.UserCredentials;

public interface UserCredDao {
	public void insertUserCred(UserCredentials user);
	public UserCredentials selectUserByID(int id);
	public UserCredentials selectUserByUsername(String username);
	public List<UserCredentials> selectAllUser();
	public void updatePassword(UserCredentials user, String password);
	public void deleteUser(UserCredentials user);
}
