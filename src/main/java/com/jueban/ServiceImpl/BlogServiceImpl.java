package com.jueban.ServiceImpl;

import com.jueban.Dto.BlogDto;
import com.jueban.Entity.Blog;
import com.jueban.Entity.User;
import com.jueban.Repository.BlogRepository;
import com.jueban.Repository.UserRepository;
import com.jueban.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;


    @Override
    public void addBlog(BlogDto blogDto, String username) {
        User user = userRepository.findByName(username);
        Blog blog = new Blog();
        blog.setContent(blogDto.getContent());
        blog.setTitle(blogDto.getTitle());
        blog.setCreateBy(user);
        blog.setCreateTime(new Date());
        blogRepository.save(blog);
    }

}
