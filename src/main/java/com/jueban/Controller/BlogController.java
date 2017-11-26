package com.jueban.Controller;

import com.jueban.Dto.BlogDto;
import com.jueban.Repository.BlogRepository;
import com.jueban.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String create(@Valid BlogDto blogDto,String username){
        blogService.addBlog(blogDto,username);
        return "BlogForm";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "BlogForm";
    }

}
