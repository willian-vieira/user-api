package apiuser.service;

import apiuser.dto.UserDTO;
import apiuser.model.User;
import apiuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users
            .stream()
            .map(UserDTO::convertToUser)
            .collect(Collectors.toList());
    }

    public UserDTO getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user
            .map(UserDTO::convertToUser)
            .orElse(null);
    }

    public UserDTO getUserByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convertToUser(user);
        }
        return null;
    }

    public List<UserDTO> queryByNameUserLike(String name) {
        List<User> users = userRepository.findByNameContains(name);
        return users
            .stream()
            .map(UserDTO::convertToUser)
            .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userRepository.save(User.convertToUserDTO(userDTO));
        return UserDTO.convertToUser(user);
    }

    public void deleteUser(long userId) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(value -> userRepository.delete(value));
    }
}
