package com.krauser.model;

import com.krauser.security.Role;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    @Column(name = "google_profile_picture")
    private String googleProfilePicture;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    private Boolean enabled;
    private String email;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {

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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String aPassword) {
        this.password = aPassword;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getGoogleProfilePicture() {
        return googleProfilePicture;
    }

    public void setGoogleProfilePicture(String googleProfilePicture) {
        this.googleProfilePicture = googleProfilePicture;
    }
}
