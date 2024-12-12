package com.grocify.usermgnt.repository;

import com.grocify.usermgnt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<UserEntity,String> {
}
