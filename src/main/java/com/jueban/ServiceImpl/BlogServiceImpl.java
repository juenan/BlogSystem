package com.jueban.ServiceImpl;

import com.jueban.Dto.BlogDto;
import com.jueban.Entity.Blog;
import com.jueban.Entity.User;
import com.jueban.Repository.BlogRepository;
import com.jueban.Repository.UserRepository;
import com.jueban.Service.BlogService;
import com.jueban.Vo.BlogListVo;
import com.jueban.Vo.BlogVo;
import com.jueban.Vo.ResultVo;
import com.jueban.utils.Code;
import com.jueban.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@EnableGlobalMethodSecurity(proxyTargetClass = true)
public class BlogServiceImpl implements BlogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    @Override
    public ResultVo addBlog(BlogDto blogDto) {
        ResultVo resultVo = new ResultVo();
        String username = (
                (org.springframework.security.core.userdetails.User)
                        SecurityContextHolder.getContext()
                                .getAuthentication()
                                .getPrincipal())
                .getUsername();
        User user = userRepository.findByName(username);
        Blog blog = new Blog();

        blog.setContent(blogDto.getContent());
        blog.setTitle(blogDto.getTitle());
        blog.setCreateBy(user);
        blog.setCreateTime(new Date());
        blogRepository.save(blog);

        if (blog.getId() != null) {
            resultVo.setMessage(Message.ADD_BLOG_SUCCESS);
            resultVo.setCode(Code.SUCCEED);
        } else {
            resultVo.setMessage(Message.ADD_BLOG_FAIL);
            resultVo.setCode(Code.FAIL);
        }

        return resultVo;
    }

    @Transactional
    @Override
    public List<Blog> getAllBlog() {
        Iterable<Blog> it = blogRepository.findAll();
        List<Blog> list = new ArrayList<Blog>();
        for (Blog blog : it) {
            list.add(blog);
        }
        return list;
    }

    @Transactional
    @Override
    public BlogVo findBlog(Long id) {
        BlogVo blogVo = new BlogVo();
        Blog blog = blogRepository.findOne(id);

        if (blog != null) {
            blogVo.setProperty(blog);
            blogVo.setCode(Code.SUCCEED);
            blogVo.setMessage(Message.GET_BLOG_SUCCESS);
        } else {
            blogVo.setCode(Code.FAIL);
            blogVo.setMessage(Message.GET_BLOG_FAIL);
        }

        return blogVo;
    }

    @PreAuthorize("principal.username==#blog.createBy")
    @Override
    public ResultVo deleteBlog(BlogVo blog) {
        ResultVo resultVo = new ResultVo();

        try {
            blogRepository.delete(blog.getId());
            resultVo.setCode(Code.SUCCEED);
            resultVo.setMessage(Message.DELETE_BLOG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setCode(Code.FAIL);
            resultVo.setMessage(Message.DELETE_BLOG_FAIL);
        }

        return resultVo;
    }

    @Override
    public BlogListVo getBlogs(int blog_count, int page_count) {
        BlogListVo blogListVo = new BlogListVo();
        try{
            List<Blog> list = blogRepository.findBlogs(new PageRequest(page_count-1, blog_count));

            if (list != null) {
                blogListVo.setBlog_count(blogRepository.countBlog());
                blogListVo.setList(list);
                blogListVo.setMessage(Message.GET_BLOG_LIST_SUCCESS);
                blogListVo.setCode(Code.SUCCEED);
            } else {
                blogListVo.setMessage(Message.GET_BLOG_LIST_FAIL);
                blogListVo.setCode(Code.FAIL);
            }
        }catch (Exception e){
            System.err.println(Message.PAGE_COUNT_LESS_THEN_ZERO);
            blogListVo.setMessage(Message.PAGE_COUNT_LESS_THEN_ZERO);
            blogListVo.setCode(Code.FAIL);
        }

        return blogListVo;
    }


}
