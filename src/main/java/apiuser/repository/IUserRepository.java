package apiuser.repository;

import apiuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);
    List<User> findByNameContains(String name);
}
