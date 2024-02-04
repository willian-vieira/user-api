package apiuser.service;

import apiuser.dto.UserDTO;
import apiuser.model.User;
import apiuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
}
