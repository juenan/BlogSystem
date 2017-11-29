package com.jueban.Entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date createTime;

    @Column
    @Type(type = "text")
    @LazyCollection(LazyCollectionOption.TRUE)
    private String content;

    @Column
    private String title;

    @ManyToOne
    private User createBy;


}
