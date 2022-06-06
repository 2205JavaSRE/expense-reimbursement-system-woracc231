package Services;

import java.util.List;

import DAO.ReimburTicketDao;
import DAO.ReimburTicketDaoImpl;
import Models.ReimbursementTicket;

public class TicketService {
	private static ReimburTicketDao ticketDAO = new ReimburTicketDaoImpl();
	
	public void submitNewTicket(ReimbursementTicket ticket) {
		ticketDAO.insertTicket(ticket);
	}
	
	public ReimbursementTicket returnTicketWithID(int id) {
		return ticketDAO.selectByTicketID(id);
	}
	
	public List<ReimbursementTicket> returnAllTicketWithUserID(int userID){
		return ticketDAO.selectByUserID(userID);
	}
	
	public List<ReimbursementTicket> returnAllTickets(){
		return ticketDAO.selectAllTickets();
	}
	
	public void changeTicketStatus(ReimbursementTicket ticket, String status) {
		ticketDAO.updateTicketStatus(ticket, status);
	}
	
}
