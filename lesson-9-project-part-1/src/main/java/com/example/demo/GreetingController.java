package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Greetings, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
            // the counter value odd (i.e. 1, 3, 5, 7, ...)
            long newCounter = 0; //initialize
            newCounter = counter.get() + counter.incrementAndGet();
            if(newCounter %2 ==0) {
            	newCounter +=1;
            }
            String templateWithName = String.format(template, name);
            Greeting greetingObject = new Greeting(newCounter, templateWithName);
            return greetingObject;
    }
}

