package com.jueban.Entity;

import com.jueban.Enum.Gender;
import com.jueban.Enum.UserType;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    public Long id;

    @Column
    public String name;

    @Column
    public Date registerTime;

    @Column
    public String password;

    @Enumerated(EnumType.STRING)
    @Column
    public Gender gender;

    @Column
    public Date birthday;

    @Column
    public String email;

    @Column
    public String phoneNumber;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column
    public UserType type;


}
