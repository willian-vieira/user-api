package com.user_api.dto;

import com.user_api.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    private LocalDateTime dateRegister;

    //--- Converter UserDTO em User
    public static UserDTO convertToUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAddress(user.getAddress());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setDateRegister(user.getDateRegister());
        return userDTO;
    }
}
