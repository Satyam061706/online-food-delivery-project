package in.satyamsharma.foodiesapi.controller;

import in.satyamsharma.foodiesapi.io.UserRequest;
import in.satyamsharma.foodiesapi.io.UserResponse;
import in.satyamsharma.foodiesapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@RequestBody UserRequest request) {
        return userService.registerUser(request);
    }
}
