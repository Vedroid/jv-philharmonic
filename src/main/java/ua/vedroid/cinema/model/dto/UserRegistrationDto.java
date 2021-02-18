package ua.vedroid.cinema.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import ua.vedroid.cinema.lib.Email;
import ua.vedroid.cinema.lib.FieldMatch;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "The password fields must match"
)
public class UserRegistrationDto {
    private static final int PASS_MIN_LENGTH = 4;
    private static final int PASS_MAX_LENGTH = 16;
    private static final String PASS_MESSAGE = "Password size must be between " + PASS_MIN_LENGTH
            + " and " + PASS_MAX_LENGTH;
    @Email
    private String email;
    @NotNull(message = "Field password must not be null")
    @Size(min = PASS_MIN_LENGTH, max = PASS_MAX_LENGTH, message = PASS_MESSAGE)
    private String password;
    @NotNull(message = "Field confirmPassword must not be null")
    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
