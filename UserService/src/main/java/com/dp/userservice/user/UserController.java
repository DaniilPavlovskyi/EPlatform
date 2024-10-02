package com.dp.userservice.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterRequest request) {

    }

}
