package com.jueban.Controller;

import com.jueban.Dto.BlogDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/blog")
@Controller
public class BlogController {

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String create(@Valid BlogDto blogDto){
        System.out.println(blogDto);
        return "BlogForm";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "BlogForm";
    }

}
