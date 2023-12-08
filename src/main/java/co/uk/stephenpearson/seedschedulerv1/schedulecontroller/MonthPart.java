package co.uk.stephenpearson.seedschedulerv1.schedulecontroller;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthPart {
    private int partNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfDays;

    // Constructor, getters, and setters
}



