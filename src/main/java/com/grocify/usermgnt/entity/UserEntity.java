package com.grocify.usermgnt.entity;

import com.grocify.usermgnt.enums.UserRole;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "user")
@Data
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailId;

    private String firstName;

    private String lastName;

    private String mobileNo;

    private String address;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    private LocalDate lastLogin;

    private Boolean status;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Map<String, String> metadata;

}
