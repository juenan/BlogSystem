package com.jueban.Controller;

import com.jueban.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("")
    public String home(Model model){
        List list = blogService.getAllBlog();
        model.addAttribute("blogs",list);
        return "home";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req, HttpServletResponse res){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(req,res,auth);
        return "redirect:";
    }
}
