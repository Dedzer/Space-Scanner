package vshchur.com.spaceScanner.model.response.dto;

import vshchur.com.spaceScanner.enums.UserRole;

public class UserDTO {

    private UserRole userRole;

    public UserDTO(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
