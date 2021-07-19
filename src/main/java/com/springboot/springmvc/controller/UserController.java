package com.springboot.springmvc.controller;

import com.springboot.springmvc.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/hello")
    public ModelAndView hello(@RequestParam("name") String name) {
        ModelAndView result = new ModelAndView();
        result.setViewName("welcome");
        result.addObject("user", new User(name));
        return result;
    }

    @GetMapping("/hello2")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", new User(name));
        return "welcome";
    }
}
