package com.berthias.exemple_back_voltorbataille.user;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create-account")
    public void createAccount(@RequestParam String username, @RequestParam String password, @RequestParam String password2) throws BadRequestException {
        userService.createNewAccount(username, password, password2);
    }
}
