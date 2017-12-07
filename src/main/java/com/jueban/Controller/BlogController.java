package com.jueban.Controller;

import com.jueban.Dto.BlogDto;
import com.jueban.Entity.Blog;
import com.jueban.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;


    @RequestMapping("/delete/{id}")
    public String deleteBlog(@Valid @PathVariable("id") Long id) {
        blogService.deleteBlog(blogService.findBlog(id));
        return "redirect:/blog";
    }

    @RequestMapping("/{id}")
    public String getBlog(Model model, @PathVariable("id") Long id) {
        Blog blog = blogService.findBlog(id);
        model.addAttribute("blog", blog);
        return "Blog";
    }

    @RequestMapping
    public String getBlogList(Model model) {
        List list = blogService.getAllBlog();
        model.addAttribute("blogs", list);
        return "BlogList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid BlogDto blogDto) {
        String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        blogService.addBlog(blogDto, username);
        return "redirect:/blog";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "BlogForm";
    }

}
