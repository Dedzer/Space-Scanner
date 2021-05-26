package vshchur.com.spaceScanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vshchur.com.spaceScanner.model.request.form.UserForm;
import vshchur.com.spaceScanner.service.UserService;
import vshchur.com.spaceScanner.util.JwtUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthenticationController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserForm userForm, HttpServletResponse response) {
        Long userId = userService.verifyCredentials(userForm);
        Cookie cookie = new Cookie("space_scanner_token", jwtUtil.generateToken(userId));
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge(1800);
        response.addCookie(cookie);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
