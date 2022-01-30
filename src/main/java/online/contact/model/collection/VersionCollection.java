package online.contact.model.collection;

import online.contact.model.constant.Collection;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = Collection.VERSION)
public class VersionCollection {

    @Id
    @Field("_id")
    private String mId;

    @Field("version_name")
    private String mVersionName;

    @Field("version_code")
    private Long mVersionCode;

    public String getId() {
        return mId;
    }

    public String getVersionName() {
        return mVersionName;
    }

    public Long getVersionCode() {
        return mVersionCode;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public void setVersionName(String versionName) {
        this.mVersionName = versionName;
    }

    public void setVersionCode(Long versionCode) {
        this.mVersionCode = versionCode;
    }

}
