package online.contact.model.collection;

import online.contact.model.constant.Collection;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = Collection.VERSION)
public class VersionCollection {

    @MongoId(value = FieldType.OBJECT_ID)
    private String _id;

    @Field("version_name")
    private String mVersionName;

    @Field("version_code")
    private Long mVersionCode;

    public String getId() {
        return _id;
    }

    public String getVersionName() {
        return mVersionName;
    }

    public Long getVersionCode() {
        return mVersionCode;
    }

    public void setId(String id) {
        this._id = id;
    }

    public void setVersionName(String versionName) {
        this.mVersionName = versionName;
    }

    public void setVersionCode(Long versionCode) {
        this.mVersionCode = versionCode;
    }

}
