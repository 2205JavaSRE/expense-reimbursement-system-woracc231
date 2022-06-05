package Controller;

import org.eclipse.jetty.http.HttpStatus;

import Models.UserMeta;
import Services.AuthenticationService;
import io.javalin.http.Context;

public class AuthenticationController {
	public static void AuthenticateUserForSession(Context ctx) {
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		UserMeta user = AuthenticationService.AuthenticateUser(username, password);
		
		if(user == null) {
			ctx.result("Wrong username or password");
			ctx.status(HttpStatus.FORBIDDEN_403);
			
		}
		else {
			ctx.result("Login Successful");
			ctx.status(HttpStatus.ACCEPTED_202);
			
			ctx.sessionAttribute("userID", user.getUserID());
			
		}
		
	}
	
	public static boolean VerifyUserLogInStatus(Context ctx) {
		Integer userID = Integer.valueOf(ctx.sessionAttribute("userID"));
		
		if(userID == null) {
			return false;
		}
		return true;
	}
	
}
