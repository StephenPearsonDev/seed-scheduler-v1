package co.uk.stephenpearson.seedschedulerv1.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {
	
	@GetMapping("/dashboard")
	public String getDashBoard() {
		return "dashboard";
	}

}
