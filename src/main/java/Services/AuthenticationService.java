package Services;

import DAO.UserCredDao;
import DAO.UserCredDaoImpl;
import DAO.UserMetaDao;
import DAO.UserMetaDaoImpl;
import Models.UserCredentials;
import Models.UserMeta;

public class AuthenticationService {
	private static UserCredDao userDAO = new UserCredDaoImpl();
	private static UserMetaDao metaDAO = new UserMetaDaoImpl();
	
	//Login and when match found return user_id/id of cred table
	
	public static UserMeta AuthenticateUser(String username, String password) {
		UserCredentials userCred = userDAO.selectUserByUsername(username);
		
		if(userCred == null) {
			return null;
		}
		if(userCred.getPassword().equals(password)) {
			UserMeta userMeta = metaDAO.selectUserByUserID(userCred.getId());
			return userMeta;
		}
		
		return null;
	}
	
	
}
