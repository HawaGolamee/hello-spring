package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring.";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring.";
    }

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParameter(@RequestParam String name, @RequestParam String language, Model model){
        String properGreetings = HelloController.createMessage(name, language);

//        String greeting = "<h3 style=' color:pink;'>" + properGreetings + "</h3>";
        model.addAttribute("greeting", properGreetings);
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }


    public static String createMessage(String name, String language){
        switch(language){
            case"Spanish":
                return "Hola, " + name;
            case"French":
                return "Bonjour, " + name;
            case "Italic":
                return"Ciao, " + name;
            case"German":
                return "Hallo, " + name;
            case"English":
            default:
                return "Hello, " + name;


        }
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("name", names);
        return "hello-list";



    }
}
