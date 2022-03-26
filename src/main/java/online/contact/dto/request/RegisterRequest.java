package online.contact.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class RegisterRequest {

    @NotEmpty(message = "full_name is required")
    private String mFullName;

    @NotEmpty(message = "email is required")
    private String mEmail;

    @NotEmpty(message = "password is required")
    private String mPassword;

    public String getFullName() {
        return mFullName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPassword() {
        return mPassword;
    }

    @JsonProperty("full_name")
    public void setFullName(String fullName) {
        this.mFullName = fullName;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.mEmail = email;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.mPassword = password;
    }

}
