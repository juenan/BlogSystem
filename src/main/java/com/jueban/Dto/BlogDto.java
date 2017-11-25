package com.jueban.Dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class BlogDto {
    @NotBlank(message = "标题不能为空")
    public String title;

    @NotBlank(message = "内容不能为空")
    public String content;
}
