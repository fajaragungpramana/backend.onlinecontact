package online.contact.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({ "code", "message", "data" })
public class DataListResponse<T> {

    private int mCode;

    private String mMessage;

    private List<T> mData;

    @JsonProperty("code")
    public int getCode() {
        return mCode;
    }

    @JsonProperty("message")
    public String getMessage() {
        return mMessage;
    }

    @JsonProperty("data")
    public List<T> getData() {
        return mData;
    }

    public void setCode(int code) {
        this.mCode = code;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }

    public void setData(List<T> data) {
        this.mData = data;
    }

}
