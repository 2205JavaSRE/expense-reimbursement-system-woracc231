package DAO;

import java.util.List;

import Models.ReimbursementTicket;

public interface ReimburTicketDao {
	public void insertTicket(ReimbursementTicket ticket);
	public ReimbursementTicket selectByTicketID(int ticketID);
	public ReimbursementTicket selectByUserID(int userID);
	public List<ReimbursementTicket> selectByTicketType(String ticketType);
	public List<ReimbursementTicket> selectByTicketStatus(String ticketStatus);
	public List<ReimbursementTicket> selectAllTickets();
	public void updateReimburseAmount(ReimbursementTicket ticket, int amount);
	public void updateTicketType(ReimbursementTicket ticket, String ticketType);
	public void updateTicketStatus(ReimbursementTicket ticket, String ticketStatus);
	public void deleteTicket(ReimbursementTicket ticket);
	
}
