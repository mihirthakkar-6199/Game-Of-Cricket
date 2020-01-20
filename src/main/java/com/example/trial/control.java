package com.example.trial;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class control {
    @RequestMapping("/")
    public String index(){
        match m = new match();
        String fin=m.startmatch();
        System.out.println(fin);
        return fin;
    }
    @RequestMapping(value="/id")
    public String getid(@RequestParam("id") String pid){
            System.out.println("id : "+pid);
            System.out.println("hey");
            return "Got ID";
    }
}
