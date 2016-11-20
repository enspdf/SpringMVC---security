package com.shackox.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by SHACKOX on 23/10/16.
 */

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false, unique = true)
    String username;
    @Column(nullable = false)
    String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRole> roles;

    public AppUser() {
    }

    public AppUser(String username, String password, List<UserRole> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
