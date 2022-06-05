package Controller;

import io.javalin.Javalin;

public class RequestMapping {
	public static void RouteConfigurations(Javalin app) {
		
		app.post("/login", ctx ->{
			AuthenticationController.AuthenticateUserForSession(ctx);
			
			ctx.result(ctx.sessionAttribute("userID").toString());
		});
		
		
		app.get("/logout", ctx ->{
			ctx.sessionAttribute("userID", 0);
		});
		
		
		
	}
}
