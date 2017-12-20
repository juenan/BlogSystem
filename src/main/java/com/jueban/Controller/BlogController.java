package com.jueban.Controller;

import com.jueban.Dto.BlogDto;
import com.jueban.Entity.Blog;
import com.jueban.Service.BlogService;
import com.jueban.Vo.BlogListVo;
import com.jueban.Vo.BlogVo;
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
        return "redirect:/";
    }

    @RequestMapping("/{id}")
    public String getBlog(Model model, @PathVariable("id") Long id) {
        model.addAttribute("blog",blogService.findBlog(id));
        return "Blog";
    }

    @ResponseBody
    @RequestMapping
    public BlogListVo getBlogList(int blog_count, int page_count) {
        return blogService.getBlogs(blog_count,page_count);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid BlogDto blogDto) {
        blogService.addBlog(blogDto);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "BlogForm";
    }

}
