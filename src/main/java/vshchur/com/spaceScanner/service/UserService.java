package vshchur.com.spaceScanner.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vshchur.com.spaceScanner.dao.repository.UserRepository;
import vshchur.com.spaceScanner.entities.User;
import vshchur.com.spaceScanner.enums.UserRole;
import vshchur.com.spaceScanner.exception.AuthException;
import vshchur.com.spaceScanner.exception.UserNotFoundException;
import vshchur.com.spaceScanner.model.request.form.UserForm;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveUser(UserForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
        user.setUserRole(UserRole.USER.name());
        userRepository.save(user);
    }

    private Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Long verifyCredentials(UserForm userForm) {
        Optional<User> user = findUserByEmail(userForm.getEmail());
        if (user.isEmpty() || !bCryptPasswordEncoder.matches(userForm.getPassword(), user.get().getPassword())) {
            throw new AuthException();
        }
        return user.get().getUserId();
    }

    public User findUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }
}
