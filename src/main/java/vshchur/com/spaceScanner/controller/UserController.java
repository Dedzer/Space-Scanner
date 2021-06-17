package vshchur.com.spaceScanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vshchur.com.spaceScanner.model.request.form.UserForm;
import vshchur.com.spaceScanner.model.response.dto.UserDTO;
import vshchur.com.spaceScanner.service.UserService;
import vshchur.com.spaceScanner.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserForm userForm) {
        userService.saveUser(userForm);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public UserDTO getUserRoles(HttpServletRequest request) {
        return userService.findUserRole(jwtUtil.retrieveUserId(Optional.of(request.getHeader("Authorization"))));
    }

    @PutMapping("/password")
    public ResponseEntity<Void> changePassword(@RequestBody UserForm userForm, HttpServletRequest request) {
        userService.changePassword(userForm, jwtUtil.retrieveUserId(Optional.of(request.getHeader("Authorization"))));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
