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
    private Long id;

    @Column
    private String name;

    @Column
    private Date registerTime;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Column
    private Date birthday;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column
    private UserType type;


}
