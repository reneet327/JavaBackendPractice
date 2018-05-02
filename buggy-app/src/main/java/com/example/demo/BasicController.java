package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
            String localDateTime = getLocalDateTime();
        return localDateTime;
    }

    private String getLocalDateTime() {
            String result = "";
            LocalDateTime now = LocalDateTime.now();
            result = now.toString();
            System.out.println(result);
            return result;
    }
}