package com.grocify.usermgnt.repository;

import com.grocify.usermgnt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmailId(String emailId);

}
