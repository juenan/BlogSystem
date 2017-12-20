package com.jueban.Dto;

import com.jueban.Entity.Content;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Data
public class BlogDto {
    @NotBlank(message = "标题不能为空")
    public String title;

    @NotBlank(message = "内容不能为空")
    public List<Content> content;


}
