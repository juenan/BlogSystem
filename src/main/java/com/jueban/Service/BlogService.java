package com.jueban.Service;

import com.jueban.Dto.BlogDto;
import com.jueban.Entity.Blog;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface BlogService {
    public void addBlog(BlogDto blogDto,String username);
    public List<Blog> getAllBlog();
    public Blog findBlog(Long id);
    public void deleteBlogById(Long id);
    public void deleteBlog(Blog blog);
}
