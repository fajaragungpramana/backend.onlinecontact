package online.contact.remote.service;

import online.contact.model.collection.VersionCollection;
import online.contact.remote.repository.VersionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VersionService {

    @Autowired
    private VersionRepository mVersionRepository;

    public VersionCollection getVersionById(ObjectId id) {
        return mVersionRepository.getVersionById(id);
    }

}
