package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import hu.rendszerfejlesztes.bookshopbackend.utils.EncryptionUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
//@Table(name = "users")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    private String fullName;
    @Column(name="Email")
    private String email;
    @Column(name="Password")
    private String password;
    private String city;
    private String street;
    private String postCode;
    private String phoneNumber;
    @Column(name="Token")
    private String token;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Transient
    private boolean passwordEncrtyped;

    @OneToOne
    @JsonIgnore
    private Cart cart;

    @OneToMany(mappedBy="customer", fetch = FetchType.EAGER)
    private Set<Rating> ratings;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", postCode=").append(postCode);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", userRole=").append(userRole);
        sb.append(", passwordEncrtyped=").append(passwordEncrtyped);
        sb.append(", cart=").append(cart);
        sb.append(", ratings=").append(ratings);
        sb.append(", token=").append(token);
        sb.append('}');
        return sb.toString();
    }

    @Transient
    @JsonIgnore
    public byte[] getBytes() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.toString());
        sb.append(Long.toString(new Date().getTime()));
        return sb.toString().getBytes();
    }
    @JsonIgnore
    public void randomizeTokenOnce() {
        if(token == null) {
            token = EncryptionUtils.getSHA256HashString(UUID.randomUUID().toString());
        }
    }
}
