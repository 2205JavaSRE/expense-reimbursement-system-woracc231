package Controller;

import java.util.List;

import Models.ReimbursementTicket;
import Models.UserMeta;
import Services.TicketService;
import io.javalin.http.Context;

public class TicketController {
	
	private TicketService tService = new TicketService();
	//----Regular Employee
	public void submitNewTicket(Context ctx) {
		UserMeta user = ctx.sessionAttribute("userID");
		
		int userID = user.getUserID();
		int reimburseAmount = Integer.parseInt(ctx.formParam("reimburseAmount"));
		String ticketType = ctx.formParam("ticketType");
		String ticketStatus = "pending";
		
		ReimbursementTicket ticket = new ReimbursementTicket(userID, reimburseAmount, ticketType, ticketStatus);
		
		tService.submitNewTicket(ticket);
	}
	
	public void getAllTicketsWithUserID(Context ctx) {
		UserMeta user = ctx.sessionAttribute("userID");
		List<ReimbursementTicket> ticketList = tService.returnAllTicketWithUserID(user.getUserID());
		
		ctx.json(ticketList);
	}
	
	
	//----Finance manager
	
	public void getAllTickets(Context ctx) {
		List<ReimbursementTicket> ticketList = tService.returnAllTickets();
		
		ctx.json(ticketList);
	}
	
	public void changeTicketStatus(Context ctx) {
		ReimbursementTicket ticket = tService.returnTicketWithID(Integer.parseInt(ctx.formParam("ticketID")));
		
		tService.changeTicketStatus(ticket, ctx.formParam("ticketStatus"));
		
	}
	
	
	
}
