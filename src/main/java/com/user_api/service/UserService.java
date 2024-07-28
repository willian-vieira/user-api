package com.user_api.service;

import com.user_api.dto.UserDTO;
import com.user_api.entity.User;
import com.user_api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    /**
     * Recupera Lista de Usuários
     * @return List UserDTO
     */
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users
            .stream()
            .map(UserDTO::convertToUser)
            .collect(Collectors.toList());
    }

    /**
     * Recupera Usuário por ID
     * @param id
     * @return UserDTO
     */
    public UserDTO getUserById(long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user
            .map(UserDTO::convertToUser)
            .orElse(null);
    }

    /**
     * Recupera Usuário por CPF
     * @param cpf
     * @return UserDTO
     */
    public UserDTO getUserByCpf(String cpf) {
        User user = this.userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convertToUser(user);
        }
        return null;
    }

    /**
     * Recupera Lista de Usuários por Nome Especifico
     * @param name
     * @return List UserDTO
     */
    public List<UserDTO> queryByNameUserLike(String name) {
        List<User> users = this.userRepository.findByNameContains(name);
        return users
            .stream()
            .map(UserDTO::convertToUser)
            .collect(Collectors.toList());
    }

    /**
     * Cria um Usuário
     * @param userDTO
     * @return userDTO
     */
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setDateRegister(LocalDateTime.now());
        User user = this.userRepository.save(User.convertToUserDTO(userDTO));
        return UserDTO.convertToUser(user);
    }

    /**
     * Deleta um Usuário por ID
     * @param userId
     */
    public void deleteUser(long userId) {
        Optional<User> user = this.userRepository.findById(userId);
        user.ifPresent(value -> this.userRepository.delete(value));
    }
}
