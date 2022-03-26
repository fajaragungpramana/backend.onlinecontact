package online.contact.model.collection;

import online.contact.model.constant.Collection;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = Collection.OTP)
public class OtpCollection {

    @MongoId(value = FieldType.OBJECT_ID)
    private String _id;

    @Field("user_id")
    private String mUserId;

    @Field("otp")
    private String mOtp;

    @Field("is_verified")
    private Boolean mIsVerified;

    @Field("created_at")
    private String mCreatedAt;

    @Field("updated_at")
    private String mUpdatedAt;

    public String getId() {
        return _id;
    }

    public String getUserId() {
        return mUserId;
    }

    public String getOtp() {
        return mOtp;
    }

    public Boolean isVerified() {
        return mIsVerified;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setId(String id) {
        this._id = id;
    }

    public void setUserId(String userId) {
        this.mUserId = userId;
    }

    public void setOtp(String otp) {
        this.mOtp = otp;
    }

    public void isVerified(Boolean isVerified) {
        this.mIsVerified = isVerified;
    }

    public void setCreatedAt(String createdAt) {
        this.mCreatedAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.mUpdatedAt = updatedAt;
    }

}
