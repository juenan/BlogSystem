package com.jueban.Entity;

import com.jueban.utils.Enum.ContentType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class Content {
    @Id
    private Long id;

    @ManyToOne
    private ContentType type;

    @Column
    private String content;

}
