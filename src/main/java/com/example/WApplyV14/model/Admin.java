package com.example.WApplyV14.model;


import javax.persistence.*;

@Entity
public class Admin {

    @Id
    @Column(name="email")
    private String email;

    private String username;

    private String password;

    private String company;

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int adminID;

   /* public Admin(String email, String username, String password, String company, int adminID) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.company = company;
        this.adminID = adminID;
    }*/

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}