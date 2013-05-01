package com.loki2302;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    TheConfiguration theConfiguration;
    
    @RequestMapping
    public String index(Model model) {
        model.addAttribute("something", "hello from controller!");
        model.addAttribute("config", theConfiguration);
        return "WEB-INF/views/index.jsp";
    }
}
