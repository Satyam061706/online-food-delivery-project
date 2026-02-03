package in.satyamsharma.foodiesapi.service;

import in.satyamsharma.foodiesapi.io.UserRequest;
import in.satyamsharma.foodiesapi.io.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest request);

    String findByUserId();
}
