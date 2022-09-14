package com.example.BMI.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class BMIcontroller {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/calculate")
    public String calculation(@RequestParam("weight")int weight, @RequestParam("height")double height, RedirectAttributes attributes){
        attributes.addAttribute("weight",weight);
        attributes.addAttribute("height",height);
        return "redirect:/calculatedBMI";
    }

    @GetMapping("/calculate")
    public String calc(@RequestParam("weight")int weight, @RequestParam("height")double height, Model model){

        double result = (weight/((height/100)*(height/100)));


        model.addAttribute("weight", weight);
        model.addAttribute("height", height);
        model.addAttribute("result", result);
        return "calculateBMI";

    }
}
