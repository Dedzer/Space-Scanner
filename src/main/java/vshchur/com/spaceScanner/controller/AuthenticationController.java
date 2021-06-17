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

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> login(@RequestBody UserForm userForm, HttpServletResponse response) {
        Long userId = userService.verifyCredentials(userForm);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwtUtil.generateToken(userId));
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
