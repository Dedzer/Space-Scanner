package vshchur.com.spaceScanner.entities;

import javax.persistence.*;

@Entity
@Table(name = "USER_T")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false)
    private Long userId;
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;
    @Column(name = "PASSWORD", nullable = false, length = 256)
    private String password;
    @Column(name = "USER_ROLE", nullable = false, length = 10)
    private String userRole;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
