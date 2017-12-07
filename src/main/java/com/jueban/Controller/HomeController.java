package com.jueban.Controller;

import com.jueban.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/home")
    public String home(Model model){
        List list = blogService.getAllBlog();
        model.addAttribute("blogs",list);
        return "home";
    }
}
