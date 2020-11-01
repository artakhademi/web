package edu.depaul.cdm.se452.concept.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @Value( "${spring.profiles.active}" )
    private String greeting;

    @GetMapping("/login")
    public ModelAndView showLogin() {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("name", "Account Login");
        return mv;
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView mv = new ModelAndView("dashboard");
        return mv;
    }

    @GetMapping("/course_catalog")
    public ModelAndView courseCatalog() {
        ModelAndView mv = new ModelAndView("courseCatalog");
        return mv;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}