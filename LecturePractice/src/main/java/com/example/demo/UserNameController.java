package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserNameController {
	@RequestMapping("/user/{userName}")
	public String getUserName(@PathVariable String userName) {
		return "You used the name " + userName;
	}
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String postUserName(@RequestBody String userName) {
		return "The name you entered was " + userName;
	}
	
	@RequestMapping(value = "/user/add", method= RequestMethod.POST)
	public Person addPerson(@RequestBody Person person) {
		return person;
	}
}
