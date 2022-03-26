package online.contact.remote.service;

import online.contact.model.collection.UserCollection;
import online.contact.remote.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository mUserRepository;

    public UserCollection getUser(ObjectId id) {
        return mUserRepository.getUser(id);
    }

    public void setUser(UserCollection userCollection) {
        mUserRepository.insert(userCollection);
    }

    public List<UserCollection> getListEmail(String email) {
        return mUserRepository.getListEmail(email);
    }

}
