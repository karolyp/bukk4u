package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @JsonIgnore
    private Integer id;
    private String fullName;
    private String email;
    private String password;
    private String address;
    // TODO: telefonszám?

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Transient
    private boolean passwordEncrtyped;

    public User() {
    }

    public User(String fullName, String email, String password, String address, UserRole userRole) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.userRole = userRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @JsonIgnore
    public boolean isPasswordEncrtyped() {
        return passwordEncrtyped;
    }

    @JsonProperty
    public void setPasswordEncrtyped(boolean passwordEncrtyped) {
        this.passwordEncrtyped = passwordEncrtyped;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("fullName", fullName)
                .add("email", email)
                .add("password", password)
                .add("address", address)
                .add("userRole", userRole)
                .toString();
    }
}
