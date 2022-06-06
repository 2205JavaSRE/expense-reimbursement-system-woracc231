package Models;

import java.util.Objects;

public class ReimbursementTicket {
	private int id;
	private int userID;
	private int reimburseAmount;
	private String ticketType;
	private String ticketStatus;
	public ReimbursementTicket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReimbursementTicket(int id, int userID, int reimburseAmount, String ticketType, String ticketStatus) {
		super();
		this.id = id;
		this.userID = userID;
		this.reimburseAmount = reimburseAmount;
		this.ticketType = ticketType;
		this.ticketStatus = ticketStatus;
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

	public int getReimburseAmount() {
		return reimburseAmount;
	}

	public void setReimburseAmount(int reimburseAmount) {
		this.reimburseAmount = reimburseAmount;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	@Override
	public String toString() {
		return "ReimbursementTicket [id=" + id + ", userID=" + userID + ", reimburseAmount=" + reimburseAmount
				+ ", ticketType=" + ticketType + ", ticketStatus=" + ticketStatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, reimburseAmount, ticketStatus, ticketType, userID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementTicket other = (ReimbursementTicket) obj;
		return id == other.id && reimburseAmount == other.reimburseAmount
				&& Objects.equals(ticketStatus, other.ticketStatus) && Objects.equals(ticketType, other.ticketType)
				&& userID == other.userID;
	}
	
	
}
