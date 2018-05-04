package hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ValuesController {

	// 3000 for react and 4200 for angular
    @CrossOrigin(origins = "http://localhost:3000")

	@GetMapping("/values")
	public String[] getValues(){
	  return new String[] {"value1","value2"};
	}
}