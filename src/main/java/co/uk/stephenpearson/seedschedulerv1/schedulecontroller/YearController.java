package co.uk.stephenpearson.seedschedulerv1.schedulecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;
import java.util.List;

@Controller
public class YearController {

    @GetMapping("/api/getYears")
    public String getYears(Model model) {
        
        int firstYear = LocalDate.now().getYear();
        int secondYear = firstYear+1;
        if(LocalDate.now().getMonthValue() >= 10) {
        	firstYear+=1;
        	secondYear -= 1;
        	
        } 
        

        model.addAttribute("years", List.of(firstYear, secondYear));
        return "fragments/yearsFragment"; // name of the Thymeleaf template
    }
}
