package online.contact.dto.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterResponse {

    private String mOtpToken;

    @JsonProperty("otp_token")
    public String getOtpToken() {
        return mOtpToken;
    }

    public void setOtpToken(String otpToken) {
        this.mOtpToken = otpToken;
    }

}
