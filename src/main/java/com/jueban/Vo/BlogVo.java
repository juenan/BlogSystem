package com.jueban.Vo;

import com.jueban.Entity.Blog;
import com.jueban.Entity.Content;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

@Data
public class BlogVo extends ResultVo{

    private Long id;
    private String title;
    private List<Content> content;
    private String createBy;
    private Date createTime;


    public void setProperty(Blog blog){
        this.createBy = blog.getCreateBy().getName();
        BeanUtils.copyProperties(blog,this);
    }
}
