package com.mitrais.trainee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController
{
    @RequestMapping(value = "/hello", method=RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam(value = "message", defaultValue = "Hello Spring") String message){
        
        return "Your message:" + message;
    }

    @RequestMapping(value="/hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestBody HelloWorld message){
        return message.getMessage();
    }

    
    @RequestMapping(value="/hello/{message}", method = RequestMethod.PUT)
    @ResponseBody
    public String helloPut(@PathVariable String message){
        return "your message: "+message;
    }
}