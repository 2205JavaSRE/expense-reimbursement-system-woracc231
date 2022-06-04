package DAO;

import java.util.List;

import Models.UserMeta;

public interface UserMetaDao {
	public void insertUserMeta(UserMeta user);
	public UserMeta selectUserByMetaID(int metaID);
	public UserMeta selectUserByUserID(int userID);
	public List<UserMeta> selectUserByFirstName(String firstName);
	public List<UserMeta> selectUserByLastName(String lastName);
	public List<UserMeta> selectAllUserMetas();
	public void updateUserMetaFirstName(UserMeta user, String firstName);
	public void updateUserMetaLastName(UserMeta user, String lastName);
	public void updateUserMetaFinanceManagerStatus(UserMeta user, Boolean isFM);
	public void deleteUserMeta(UserMeta user);
	
}
