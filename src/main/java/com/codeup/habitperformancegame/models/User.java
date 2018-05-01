package com.codeup.habitperformancegame.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String bio;

    @ManyToOne
    @JoinColumn (name = "avatar_id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn (name = "clan_id")
    private Clan clan;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created_on;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<User_Badge> user_badges;

//    ##########################         constructors             ########################


    public User() {
    }
    //make a copy of user
    public User(User copy){
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public User(String username, String email, String password, String firstName, String lastName, String bio, Avatar avatar) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.avatar = avatar;
    }

    public User(String username, String email, String password, String firstName, String lastName, String bio, Avatar avatar, Clan clan, Date created_on, List<User_Badge> user_badges) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.avatar = avatar;
        this.clan = clan;
        this.created_on = created_on;
        this.user_badges = user_badges;
    }

//    ##########################         getters and setters      ########################


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public List<User_Badge> getUser_badges() {
        return user_badges;
    }

    public void setUser_badges(List<User_Badge> user_badges) {
        this.user_badges = user_badges;
    }
}
