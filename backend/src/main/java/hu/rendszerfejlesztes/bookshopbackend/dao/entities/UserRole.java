package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

public enum UserRole {
    GUEST("GUEST"),
    USER("USER"),
    ADMIN("ADMIN");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
