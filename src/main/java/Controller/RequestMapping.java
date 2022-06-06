package Controller;

import org.eclipse.jetty.http.HttpStatus;

import io.javalin.Javalin;

public class RequestMapping {
	public static void RouteConfigurations(Javalin app) {
		
		app.post("/login", ctx ->{
			AuthenticationController.AuthenticateUserForSession(ctx);
			
			ctx.result(ctx.sessionAttribute("userID").toString());
		});
		
		
		app.get("/logout", ctx ->{
			ctx.consumeSessionAttribute("userID");
			ctx.consumeSessionAttribute("isFinanceManager");
		});
		
		
		//---Non-Finance Managers' Options
		app.post("/SubmitRequest", ctx ->{//Form parameter : reimburseAmount, ticketType(lodging, travel, food, other)
			if(AuthenticationController.VerifyUserLogInStatus(ctx)) {
				TicketController tController = new TicketController();
				tController.submitNewTicket(ctx);
			}else {
				ctx.status(HttpStatus.FORBIDDEN_403);
			}

		});
		
		app.get("/ViewPastRequests", ctx ->{
			if(AuthenticationController.VerifyUserLogInStatus(ctx)) {
				TicketController tController = new TicketController();
				tController.getAllTicketsWithUserID(ctx);
			}
			else {
				ctx.status(HttpStatus.FORBIDDEN_403);
			}
		});
		
		//--------------------------------
		
		//Finance Manager Options
		
		
		app.get("/ViewAllRequests", ctx ->{
			Boolean isFM = ctx.sessionAttribute("isFinanceManager");
			if(AuthenticationController.VerifyUserLogInStatus(ctx) && isFM) {//fix boolean stuff for checking financial manager
				TicketController tController = new TicketController();
				tController.getAllTickets(ctx);
			}
			else {
				ctx.status(HttpStatus.FORBIDDEN_403);
			}			
		});
		
		app.post("/ApproveRequests", ctx ->{//Form parameter: ticketID, ticketStatus
			Boolean isFm = ctx.sessionAttribute("isFinanceManager");
			if(AuthenticationController.VerifyUserLogInStatus(ctx) && isFm) {
				TicketController tController = new TicketController();
				tController.changeTicketStatus(ctx);
			}
			else {
				ctx.status(HttpStatus.FORBIDDEN_403);
			}			
		});
		
		
		
		
		
		
		
	}
}
