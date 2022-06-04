package Models;

import java.util.Objects;

public class UserMeta {
	private int id;
	private int userID;
	private String firstName;
	private String lastName;
	private Boolean isFinanceManager;
	
	
	public UserMeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserMeta(int id, int userID, String firstName, String lastName, Boolean isFinanceManager) {
		super();
		this.id = id;
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isFinanceManager = isFinanceManager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getIsFinanceManager() {
		return isFinanceManager;
	}

	public void setIsFinanceManager(Boolean isFinanceManager) {
		this.isFinanceManager = isFinanceManager;
	}

	@Override
	public String toString() {
		return "UserMeta [id=" + id + ", userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", isFinanceManager=" + isFinanceManager + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, isFinanceManager, lastName, userID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMeta other = (UserMeta) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(isFinanceManager, other.isFinanceManager) && Objects.equals(lastName, other.lastName)
				&& userID == other.userID;
	}
	
	
	
}
