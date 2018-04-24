package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaController {
	
	@GetMapping("/java")
	public String getJava() {
		return "java";
	}

}
