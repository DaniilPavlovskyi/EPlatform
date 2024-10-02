package com.dp.userservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;

    @Cacheable(value = "users", key = "#id")
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
