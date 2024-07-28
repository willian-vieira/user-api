package com.user_api.entity;

import com.user_api.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 11, nullable = false, unique = true)
    private String cpf;
    @Column(length = 100, nullable = false)
    private String address;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 11, nullable = false)
    private String phone;
    @Column(nullable = false)
    private LocalDateTime dateRegister;

    //--- Converter User em UserDTO
    public static User convertToUserDTO(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setCpf(userDTO.getCpf());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setDateRegister(userDTO.getDateRegister());
        return user;
    }
}
