package com.user_api.controller;

import com.user_api.dto.UserDTO;
import com.user_api.service.UserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String get() {
        return "API Running! 🚀";
    }

    @GetMapping("/users")
    public List<UserDTO> findListUsers() {
        List<UserDTO> users = this.userService.getAllUsers();
        return users;
    }

    @GetMapping("/user/{id}")
    UserDTO findUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/user/cpf/{cpf}")
    UserDTO findUserByCpf(@PathVariable String cpf) {
        return this.userService.getUserByCpf(cpf);
    }

    @GetMapping("users/search")
    List<UserDTO> findUserByName(@RequestParam(name="name", required = false) String name) {
        return this.userService.queryByNameUserLike(name);
    }

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return this.userService.createUser(userDTO);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }
}
