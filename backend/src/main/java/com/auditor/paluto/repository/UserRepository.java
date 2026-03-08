package com.auditor.paluto.repository;

import com.auditor.paluto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public boolean findByEmail(String email);
}
