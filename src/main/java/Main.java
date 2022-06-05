import Controller.RequestMapping;
import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) {
		//System.out.println("Hello World");

		
		Javalin app = Javalin.create().start(9090);
		
		RequestMapping.RouteConfigurations(app);
	}

}
