package co.uk.stephenpearson.seedschedulerv1.schedulecontroller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class CalendarService {
	public int getWeeksInMonth(String month) {
		int currentYear = LocalDate.now().getYear();
        // Parse the month string to a month number (e.g., January -> 1)
        int monthNumber = Month.valueOf(month.toUpperCase()).getValue();

        // Create a YearMonth object for the specified month and year
        YearMonth yearMonth = YearMonth.of(currentYear, monthNumber);

        // Find the first day of the month
        LocalDate firstDayOfMonth = yearMonth.atDay(1);

        // Calculate the number of weeks based on the first day and the last day of the month
        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();
        int weeks = calculateWeeks(firstDayOfMonth, lastDayOfMonth);

        return weeks;
    }
	
	public int getWeeksForMonth(String month) {
		
		int currentYear = LocalDate.now().getYear();
		
		int monthNumber = Month.valueOf(month.toUpperCase()).getValue();
		
		YearMonth yearMonth = YearMonth.of(currentYear, monthNumber);
			
		LocalDate firstOfMonth = yearMonth.atDay(1);
		LocalDate lastOfMonth = yearMonth.atEndOfMonth();
		
		WeekFields weekFields = WeekFields.of(Locale.getDefault());
		 int firstWeekNumber = firstOfMonth.get(weekFields.weekOfWeekBasedYear());
	        int lastWeekNumber = lastOfMonth.get(weekFields.weekOfWeekBasedYear());
		
		return lastWeekNumber - firstWeekNumber - 1;
		
	}
	
	private int calculateWeeks(LocalDate startDate, LocalDate endDate) {
        int weeks = 0;
        
        // Start from the first day of the month and find the end of the first week
        LocalDate current = startDate;
        LocalDate endOfWeek = current.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));

        // Iterate through the days, moving from one Saturday to the next
        while (current.isBefore(endDate) || current.isEqual(endDate)) {
            weeks++;
            current = endOfWeek.plusDays(1);
            endOfWeek = current.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        }

        return weeks;
    }
	
	public List<MonthPart> getMonthParts(String month) {
	    int currentYear = LocalDate.now().getYear();
	    int monthNumber = Month.valueOf(month.toUpperCase()).getValue();
	    YearMonth yearMonth = YearMonth.of(currentYear, monthNumber);

	    List<MonthPart> parts = new ArrayList<>();
	    int totalDays = yearMonth.lengthOfMonth();
	    int daysInPart = totalDays / 4;
	    int extraDays = totalDays % 4;

	    for (int i = 0; i < 4; i++) {
	        LocalDate partStart = yearMonth.atDay(i * daysInPart + 1);
	        LocalDate partEnd = (i == 3) ? yearMonth.atEndOfMonth() : yearMonth.atDay((i + 1) * daysInPart);

	        MonthPart part = new MonthPart();
	        part.setPartNumber(i + 1);
	        part.setStartDate(partStart);
	        part.setEndDate(partEnd);
	        part.setNumberOfDays((i == 3) ? (daysInPart + extraDays) : daysInPart);

	        parts.add(part);
	    }

	    return parts;
	}


}
