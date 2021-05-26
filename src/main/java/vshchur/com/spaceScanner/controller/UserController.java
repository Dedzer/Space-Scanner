package vshchur.com.spaceScanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vshchur.com.spaceScanner.model.request.form.UserForm;
import vshchur.com.spaceScanner.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Void> register(@RequestBody UserForm userForm) {
        userService.saveUser(userForm);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
