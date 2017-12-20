package com.jueban.Service;

import com.jueban.Dto.BlogDto;
import com.jueban.Entity.Blog;
import com.jueban.Vo.BlogListVo;
import com.jueban.Vo.BlogVo;
import com.jueban.Vo.ResultVo;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface BlogService {
    public ResultVo addBlog(BlogDto blogDto);
    public List<Blog> getAllBlog();
    public BlogVo findBlog(Long id);
    public ResultVo deleteBlog(BlogVo blog);
    public BlogListVo getBlogs(int blog_count, int page_count);
}
