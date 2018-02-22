package com.jason.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyMvcController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String prepareView(@RequestParam("id") String id,
                              Model model) {
        System.out.println("id:" + id);
        //bind msg variable to a value which our jsp view
        //will be using
        model.addAttribute("msg", "Spring quick start!!");
        //return  the name of our jsp page.
        return "my-page";
    }
}