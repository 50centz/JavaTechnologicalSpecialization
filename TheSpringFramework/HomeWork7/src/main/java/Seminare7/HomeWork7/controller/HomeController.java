package Seminare7.HomeWork7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/public-data")
    public String userPage(){
        return "public-data";
    }


    @GetMapping("/private-data")
    public String adminPage(){
        return "private-data";
    }


    @GetMapping("/error")
    public String accessDenied(){
        return "error";
    }


    @GetMapping("/login")
    public String auth(){
        return "login";
    }

}
