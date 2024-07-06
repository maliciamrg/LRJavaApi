package com.maliciamrg.lrcat.repository;

import com.maliciamrg.lrcat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
