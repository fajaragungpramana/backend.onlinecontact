package online.contact.remote.repository;

import online.contact.model.collection.VersionCollection;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends MongoRepository<VersionCollection, String> {

    @Query("{ 'id' : ?0}")
    VersionCollection getVersionById(ObjectId id);

}
