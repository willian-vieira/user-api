package com.user_api.repository;

import com.user_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);
    List<User> findByNameContains(String name);
}
