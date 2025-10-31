package com.java04.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Users")
public class Users {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="password")
    private String password;
    @Column(name="fullname")
    private String fullName;
    @Column(name="email")
    private String email;
    @Column(name="admin")
    private Boolean admin = false;
    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;
    @OneToMany(mappedBy = "user")
    private List<Share> shares;

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public void printInformation(){
        System.out.println("id: "+id);
        System.out.println("password: "+password);
        System.out.println("fullName: "+fullName);
        System.out.println("email: "+email);
        System.out.println("admin: "+admin);
    }
}

