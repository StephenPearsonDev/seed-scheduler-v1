package co.uk.stephenpearson.seedschedulerv1.schedulecontroller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ScheduleController {
	
	CalendarService calendarService;
	
	public ScheduleController(CalendarService calendarService) {
		this.calendarService = calendarService;
	}
	
	
	
	@GetMapping("/api/getWeeks")
	public String getWeeks(@RequestParam String month, Model model) {
		int weeksInMonth = calendarService.getWeeksInMonth(month);
		List<Integer> weeks = IntStream.rangeClosed(1, weeksInMonth).boxed().collect(Collectors.toList());
		model.addAttribute("weeks", weeks);
		return "fragments/weekOptions";
	}
	
	@GetMapping("/api/getMonthParts")
	public String getMonthparts(@RequestParam String month, Model model) {
		System.out.println("getting month: " + month);
		List<MonthPart> monthParts = calendarService.getMonthParts(month);
		
		model.addAttribute("monthParts", monthParts);
		
		return "fragments/monthParts";
	}

}
