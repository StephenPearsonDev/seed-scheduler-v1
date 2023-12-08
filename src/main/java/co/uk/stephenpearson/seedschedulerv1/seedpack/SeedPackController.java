package co.uk.stephenpearson.seedschedulerv1.seedpack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seedpack")
public class SeedPackController {
	
	List<SeedPack> seedPacks = new ArrayList<>();
	
	@PostMapping("/add")
	public String addSeedPack(@ModelAttribute SeedPack seedPack) {
			seedPacks.add(seedPack);
			
			
		
			System.out.println(seedPack.toString());
			
			
			return "seedpack added";
	}
	
	
	

}
