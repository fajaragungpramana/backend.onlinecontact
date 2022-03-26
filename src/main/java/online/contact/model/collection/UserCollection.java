package online.contact.model.collection;

import online.contact.model.constant.Collection;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = Collection.USER)
public class UserCollection {

    @MongoId(value = FieldType.OBJECT_ID)
    private String _id;

    @Field("full_name")
    private String mFullName;

    @Field("email")
    private String mEmail;

    @Field("password")
    private String mPassword;

    @Field("created_at")
    private String mCreatedAt;

    @Field("updated_at")
    private String mUpdatedAt;

    public String getId() {
        return _id;
    }

    public String getFullName() {
        return mFullName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPassword() {
        return mPassword;
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

    public void setFullName(String fullName) {
        this.mFullName = fullName;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

    public void setCreatedAt(String createdAt) {
        this.mCreatedAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.mUpdatedAt = updatedAt;
    }

}
