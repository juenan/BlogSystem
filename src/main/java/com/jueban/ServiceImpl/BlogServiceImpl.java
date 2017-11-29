package com.jueban.ServiceImpl;

import com.jueban.Dto.BlogDto;
import com.jueban.Entity.Blog;
import com.jueban.Entity.User;
import com.jueban.Repository.BlogRepository;
import com.jueban.Repository.UserRepository;
import com.jueban.Service.BlogService;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
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

    @Transactional
    @Override
    public List<Blog> getAllBlog() {
        Iterable<Blog> it = blogRepository.findAll();
        List<Blog> list = new ArrayList<Blog>();
        for(Blog blog:it){
           list.add(blog);
        }
        return list;
    }

    @Transactional
    @Override
    public Blog findBlog(Long id) {
        return blogRepository.findOne(id);
    }


    @Override
    public void deleteBlogById(Long id) {
        Blog blog = blogRepository.findOne(id);
        System.out.println(blog.getCreateBy().getName());
        deleteBlog(blog);
    }

    @PreAuthorize("principal.username==#blog.createBy.name")
    @Override
    public void deleteBlog(Blog blog){
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getUsername());
        blogRepository.delete(blog.getId());

    }


}
