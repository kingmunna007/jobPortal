package com.kingmunna.Jobs.repo;

import com.kingmunna.Jobs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByName(String name);
}
