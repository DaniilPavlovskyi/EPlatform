package com.dp.userservice.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String jwtToken;
    private String refreshToken;
}
