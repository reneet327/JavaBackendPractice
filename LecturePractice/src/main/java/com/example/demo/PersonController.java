package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	private PersonRepository personRepository;
	
	@Autowired
	public PersonController(PersonRepository pr) {
		this.personRepository = pr;
	}
	
	@RequestMapping(value = "/add", method= RequestMethod.POST)
	public Person addPerson(@RequestBody Person newPerson) {
		return personRepository.save(newPerson);
	}
	
	@RequestMapping(value = "/{id}")
	public Optional<Person> getPerson(@PathVariable Long id) {
			return personRepository.findById(id);
	}
}
