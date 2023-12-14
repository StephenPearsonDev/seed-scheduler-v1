package co.uk.stephenpearson.seedschedulerv1.dashboard;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashBoardController {
	
	@GetMapping("/dashboard")
	public String getDashBoard() {
		return "dashboard";
	}
	
	@GetMapping("/scheduler")
	public String getScheduler() {
		return "scheduler";
	}
	
	@GetMapping("/api/varieties")
	@ResponseBody
	public String getVarieties(@RequestParam(required = false) String query) {
	    System.out.println("Searching: " + query);
	    List<String> allVarieties = List.of("Clapton F1", "Gucio F1", "Crimson Crush");

	    if (query == null || query.isEmpty()) {
	        return "";
	    }

	    return allVarieties.stream()
	                       .filter(variety -> variety.toLowerCase().startsWith(query.toLowerCase()))
	                       .findFirst()
	                       .orElse("");
	}







}
