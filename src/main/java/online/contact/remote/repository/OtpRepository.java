package online.contact.remote.repository;

import online.contact.model.collection.OtpCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends MongoRepository<OtpCollection, String> {

    @Query("{ 'user_id' : ?0 }")
    OtpCollection getUserOtp(String userId);

}
