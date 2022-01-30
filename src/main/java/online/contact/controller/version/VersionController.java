package online.contact.controller.version;

import online.contact.dto.response.DataResponse;
import online.contact.dto.response.version.VersionResponse;
import online.contact.model.collection.VersionCollection;
import online.contact.model.constant.HttpRoute;
import online.contact.remote.service.VersionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    private static final String VERSION_ID = "61f670e4d85f374c28fd5577";

    @Autowired
    private VersionService mVersionService;

    @GetMapping(HttpRoute.VERSION)
    private ResponseEntity<DataResponse<VersionResponse>> getVersion() {
        final DataResponse<VersionResponse> dataResponse = new DataResponse<>();

        final VersionCollection versionCollection = mVersionService.getVersionById(new ObjectId(VERSION_ID));
        if (versionCollection != null) {
            final VersionResponse versionResponse = new VersionResponse();
            versionResponse.setVersionName(versionCollection.getVersionName());
            versionResponse.setVersionCode(versionCollection.getVersionCode());

            dataResponse.setMessage("This is the latest app version.");
            dataResponse.setData(versionResponse);

            return ResponseEntity.ok(dataResponse);
        } else {
            dataResponse.setCode(1);
            dataResponse.setMessage("The current latest version app with id " + VERSION_ID + " not found.");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dataResponse);
        }

    }

}
