package com.indianbank.repository;

import com.indianbank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public Boolean existsByEmail(String email);
}
