package net.vishal.spring3.controller;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.support.*;
import org.springframework.web.servlet.*;
import org.springframework.web.bind.annotation.RequestMapping;;

@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    public ModelAndView helloWorld() {
        String message = "Hello World, Spring 3.0!";
        return new ModelAndView("hello", "message", message);
    }
}