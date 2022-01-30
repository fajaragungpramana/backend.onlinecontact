package online.contact.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataResponse<T> {

    private int mCode;

    private String mMessage;

    private T mData;

    @JsonProperty("code")
    public int getCode() {
        return mCode;
    }

    @JsonProperty("message")
    public String getMessage() {
        return mMessage;
    }

    @JsonProperty("data")
    public T getData() {
        return mData;
    }

    public void setCode(int code) {
        this.mCode = code;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }

    public void setData(T data) {
        this.mData = data;
    }

}