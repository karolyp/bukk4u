package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

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
    private String city;
    private String street;
    private Integer postCode;
    private Integer phoneNumber;

    @OneToOne
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private Set<Ratings> ratings = new HashSet<>();

    private String address;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Transient
    private boolean passwordEncrtyped;

    public User() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
                .add("city", city)
                .add("street", street)
                .add("postCode", postCode)
                .add("phoneNumber", phoneNumber)
                .add("userRole", userRole)
                .toString();
    }
}
