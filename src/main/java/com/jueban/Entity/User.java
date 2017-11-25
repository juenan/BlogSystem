package com.jueban.Entity;

import com.jueban.Enum.Gender;
import com.jueban.Enum.UserType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @Column
    public Gender gender;

    @Column
    public Date birthday;

    @Column
    public String email;

    @Column
    public String phoneNumber;

    @Column
    public UserType type;
}
