package com.berthias.exemple_back_voltorbataille.user;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    void createNewAccount(String username, String password, String password2) throws BadRequestException {
        if (username.isBlank() || password.isBlank() || password2.isBlank()) {
            throw new BadRequestException("Champs vides");
        }
        if (!Objects.equals(password, password2)) {
            throw new BadRequestException("Mots de passe differents");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(Role.JOUEUR);
        userRepository.save(user);
    }
}
