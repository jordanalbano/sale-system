package com.krauser.security;

import java.io.Serializable;

public enum Role implements Serializable {

    ROLE_ADMIN("Administrador"), ROLE_EMPLOYEE("Empleado");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
