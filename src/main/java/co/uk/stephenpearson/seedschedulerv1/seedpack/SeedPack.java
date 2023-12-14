package co.uk.stephenpearson.seedschedulerv1.seedpack;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeedPack {
	private String month;
    private String week;
    private String category;
    private String subcategory;
    private String variety;
    private String notes;
    private int sowingDay;
    
}
