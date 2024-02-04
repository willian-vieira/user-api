package apiuser.controller;

import apiuser.dto.UserDTO;
import apiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String get() {
        return "API Running! 🚀";
    }

    @GetMapping("/users/")
    List<UserDTO> findListUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/user/{id}")
    UserDTO findUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/cpf/{cpf}")
    UserDTO findUserByCpf(@PathVariable String cpf) {
        return userService.getUserByCpf(cpf);
    }

    @GetMapping("users/search")
    List<UserDTO> findUserByName(@RequestParam(name="name", required = false) String name) {
        return userService.queryByNameUserLike(name);
    }

    @PostMapping("/user")
    UserDTO createUser(@RequestBody UserDTO userDTO) {
        userDTO.setDateRegister(new Date());
        return userService.createUser(userDTO);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}