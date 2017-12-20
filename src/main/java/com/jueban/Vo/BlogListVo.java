package com.jueban.Vo;

import com.jueban.Entity.Blog;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BlogListVo extends ResultVo{
    private List<BlogVo> list = new ArrayList<BlogVo>();
    private Integer blog_count;


    public void setList(Iterable<Blog> it){
        for(Blog blog:it){
            BlogVo blogVo = new BlogVo();
            blogVo.setTitle(blog.getTitle());
            blogVo.setId(blog.getId());
            list.add(blogVo);
        }
    }

}
