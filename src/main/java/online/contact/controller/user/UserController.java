package online.contact.controller.user;

import online.contact.dto.request.RegisterRequest;
import online.contact.dto.response.DataResponse;
import online.contact.dto.response.user.RegisterResponse;
import online.contact.model.collection.UserCollection;
import online.contact.model.constant.Constant;
import online.contact.model.constant.HttpRoute;
import online.contact.remote.service.UserService;
import online.contact.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;

@RestController
public class UserController {

    @Autowired
    private UserService mUserService;

    @PostMapping(HttpRoute.USER_REGISTER)
    private ResponseEntity<DataResponse<RegisterResponse>> doUserRegister(@Valid @RequestBody RegisterRequest registerRequest, Errors errors) {
        final DataResponse<RegisterResponse> response = new DataResponse<>();

        if (errors.hasErrors()) {
            final StringBuilder stringBuilder = new StringBuilder();

            for (ObjectError error : errors.getAllErrors()) {
                if (stringBuilder.length() > 0) stringBuilder.append(", ");

                stringBuilder.append(error.getDefaultMessage());
            }

            response.setCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
            response.setMessage(stringBuilder.toString());

            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }

        if (mUserService.getListEmail(registerRequest.getEmail()).isEmpty()) {
            final RegisterResponse registerResponse = new RegisterResponse();
            final UserCollection userCollection = new UserCollection();

            final String timeStamp = new SimpleDateFormat(Constant.DATE_FORMAT).format(System.currentTimeMillis());

            userCollection.setFullName(registerRequest.getFullName());
            userCollection.setEmail(registerRequest.getEmail());
            userCollection.setPassword(registerRequest.getPassword());
            userCollection.setCreatedAt(timeStamp);
            userCollection.setUpdatedAt(timeStamp);

            mUserService.setUser(userCollection);

            registerResponse.setOtpToken(new JwtUtil().setToken(userCollection));

            response.setCode(HttpStatus.CREATED.value());
            response.setMessage("New account successfully created.");
            response.setData(registerResponse);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            response.setCode(HttpStatus.FORBIDDEN.value());
            response.setMessage("Account with same email is already exists.");

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }
    }

}
