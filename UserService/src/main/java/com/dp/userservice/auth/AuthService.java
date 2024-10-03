package com.dp.userservice.auth;

import com.dp.userservice.auth.request.LoginRequest;
import com.dp.userservice.security.JwtService;
import com.dp.userservice.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponse verify(LoginRequest request) {
        log.info("Attempting to authenticate user: {}", request.getUsername());
        Authentication auth;
        try {
            auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (Exception e) {
            log.warn("Authentication failed for user: {}. Reason: {}", request.getUsername(), e.getMessage());
            throw e;
        }

        var user = (User) auth.getPrincipal();

        log.info("User authenticated successfully: {}", user.getUsername());

        var claims = createClaims(user);

        var accessToken = jwtService.generateToken(claims, user);
//        var refreshToken = refreshTokenService.createRefreshToken(user);

        log.debug("JWT tokens generated for user: {}", user.getUsername());

        return LoginResponse.builder()
                .jwtToken(accessToken)
               /* .refreshToken(refreshToken.getToken())*/.build();
    }

    protected Map<String, Object> createClaims(User user) {
        log.debug("Created claims for user: {}", user.getUsername());
        return Map.of("username", user.getUsername());
    }
}
