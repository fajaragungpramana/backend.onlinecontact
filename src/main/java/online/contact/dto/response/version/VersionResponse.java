package online.contact.dto.response.version;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VersionResponse {

    private String mVersionName;
    private Long mVersionCode;

    @JsonProperty("version_name")
    public String getVersionName() {
        return mVersionName;
    }

    @JsonProperty("version_code")
    public Long getVersionCode() {
        return mVersionCode;
    }

    public void setVersionName(String versionName) {
        this.mVersionName = versionName;
    }

    public void setVersionCode(Long versionCode) {
        this.mVersionCode = versionCode;
    }

}
