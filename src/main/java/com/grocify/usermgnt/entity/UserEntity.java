package com.grocify.usermgnt.entity;

import com.grocify.usermgnt.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    private String emailId;

    private String firstName;

    private String lastName;

    private String mobileNo;

    private String address;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    private Date lastLogin;

    private Boolean status;

}
