package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String fullName;
    private String email;
    private String password;
    private String address;

    public User() {
    }

    public User(String fullName, String email, String password, String address) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("fullName", fullName)
                .add("email", email)
                .add("password", password)
                .add("address", address)
                .toString();
    }
}
