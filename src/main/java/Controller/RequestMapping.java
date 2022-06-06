package Controller;

import io.javalin.Javalin;

public class RequestMapping {
	public static void RouteConfigurations(Javalin app) {
		
		app.post("/login", ctx ->{
			AuthenticationController.AuthenticateUserForSession(ctx);
			
			ctx.result(ctx.sessionAttribute("userID").toString());
		});
		
		
		app.get("/logout", ctx ->{
			ctx.consumeSessionAttribute("userID");
		});
		
		
		//---Non-Finance Managers' Options
		app.post("/SubmitRequest", ctx ->{
			
		});
		
		app.get("/ViewPastRequests", ctx ->{
			
		});
		
		//--------------------------------
		
		//Finance Manager Options
		
		
		app.get("/ViewAllRequests", ctx ->{
			
		});
		
		app.post("/ApproveRequests", ctx ->{
			
		});
		
		
		
		
		
		
		
	}
}
