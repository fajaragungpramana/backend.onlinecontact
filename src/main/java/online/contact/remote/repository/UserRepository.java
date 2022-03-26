package online.contact.remote.repository;

import online.contact.model.collection.UserCollection;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserCollection, String> {

    @Query("{ '_id' : ?0 }")
    UserCollection getUser(ObjectId id);

    @Query("{ 'email' : ?0 }")
    List<UserCollection> getListEmail(String email);

}
