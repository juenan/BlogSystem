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

    @ManyToOne
    public User createBy;


}
