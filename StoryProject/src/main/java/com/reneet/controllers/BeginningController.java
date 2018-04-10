package com.reneet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reneet.models.Story;


@Controller
@RequestMapping("/")
public class BeginningController {
	
	@GetMapping("/beginning")
    public String beginning(Model model) {
        model.addAttribute("story", new Story());
        return "beginning";
    }
	
	@PostMapping("/middle")
    public String beginningSubmit(@ModelAttribute Story story, Model model) {
		model.addAttribute("name", story.getName());
        return "middle";
    }
	
	@PostMapping("/end")
    public String middleSubmit(@ModelAttribute Story story, Model model) {
		model.addAttribute("animal", story.getAnimal());
        return "end";
    }
	
		
	@PostMapping("/story")
    public String endSubmit(@ModelAttribute Story story, Model model) {
		model.addAttribute("years", story.getYears());
        return "story";
    }


}
