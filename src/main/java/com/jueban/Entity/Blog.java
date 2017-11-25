package com.jueban.Entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue
    public Long id;

    @Column
    public Date createTime;

    @Column
    public String content;

    @Column
    public String title;

    @ManyToOne
    public User createBy;


}
