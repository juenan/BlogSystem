package com.jueban.Dto;

import com.jueban.Entity.User;
import com.jueban.Enum.Gender;
import com.jueban.Enum.UserType;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

@Data
public class UserDto {

    @NotBlank
    private String name;

    private Date registerTime;

    private String email;

    private Gender gender;

    private Date birthday;

    private String phoneNumber;

    private UserType userType;

    public UserDto(User user){
        this.name = user.getName();
        this.registerTime = user.getRegisterTime();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.birthday = user.getBirthday();
        this.phoneNumber = user.getPhoneNumber();
        this.userType = user.getType();
    }

    public UserDto(){}
}
