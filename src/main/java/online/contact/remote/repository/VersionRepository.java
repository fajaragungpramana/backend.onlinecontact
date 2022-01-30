package online.contact.remote.repository;

import online.contact.model.collection.VersionCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends MongoRepository<VersionCollection, String> {

    @Query("{_id:?0}")
    VersionCollection getVersionById(String id);

}
