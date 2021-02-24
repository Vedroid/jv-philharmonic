package ua.vedroid.philharmonic.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import ua.vedroid.philharmonic.lib.Email;
import ua.vedroid.philharmonic.lib.FieldMatch;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "The password fields must match"
)
public class UserRegistrationDto {
    @Email
    private String email;
    @NotNull(message = "Field password must not be null")
    @Size(min = 4, max = 16, message = "Password size must be between 4 and 16")
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
