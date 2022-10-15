package com.krauser.dto;

import com.krauser.security.Role;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class UserDTO implements Serializable {

    private String id;

    @NotNull
    private String username;

    private LocalDate createdAt;
    private Boolean enabled;
    private String email;
    private String password;
    private Role role;
    private LocalDate deletedAt;

    private String googleProfilePicture;
    public UserDTO() {

    }

    public UserDTO(String anId, String anUsername, LocalDate createdAt, Boolean enabled, String password) {
        this.setId(anId);
        this.setUsername(anUsername);
        this.setCreatedAt(createdAt);
        this.setEnabled(enabled);
        this.setPassword(password);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String anId) {
        this.id = anId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String anUsername) {
        this.username = anUsername;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDate deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoogleProfilePicture() {
        return googleProfilePicture;
    }

    public void setGoogleProfilePicture(String googleProfilePicture) {
        this.googleProfilePicture = googleProfilePicture;
    }
}
