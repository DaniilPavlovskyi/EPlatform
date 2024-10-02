package com.dp.userservice.user;

import com.dp.userservice.validation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @Size(min = 6, max = 32, message = "Username length should be between 6 and 32 characters")
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @ValidPassword(min = 8, max = 16, message = "Password must be 8-16 chars long, with at least 1 uppercase letter, 1 lowercase letter, and 1 special character.,")
    private String password;

}
