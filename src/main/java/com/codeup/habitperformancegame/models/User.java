package com.codeup.habitperformancegame.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Must enter a username")
    private String username;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Must enter an email")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Must enter a password")
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(columnDefinition = "text")
    private String bio;

    @ManyToOne
    @JoinColumn (name = "avatar_id")
    private Avatar avatar;

    @Column
    private String avatar_color;

    @ManyToOne
    @JoinColumn (name = "clan_id")
    private Clan clan;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created_on;

    @OneToMany(cascade = ALL, mappedBy = "user")
    private List<User_Badge> user_badges;

    @OneToMany(mappedBy = "created_by")
    private List<Message> created_messages;

    @ManyToMany(mappedBy = "sent_to", fetch = FetchType.LAZY)
    private List<Message> messages;

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

    public User(String username, String email, String password, String firstName, String lastName, String bio, Avatar avatar, String avatar_color) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.avatar = avatar;
        this.avatar_color = avatar_color;
    }

    public User(String username, String email, String password, String firstName, String lastName, String bio, Avatar avatar, String avatar_color, Clan clan, Date created_on, List<User_Badge> user_badges, List<Message> messages, List<Message> created_messages) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.avatar = avatar;
        this.avatar_color = avatar_color;
        this.clan = clan;
        this.created_on = created_on;
        this.user_badges = user_badges;
        this.created_messages = created_messages;
        this.messages = messages;
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

    public List<Message> getCreated_messages() { return created_messages; }

    public void setCreated_messages(List<Message> created_messages) { this.created_messages = created_messages; }

    public List<Message> getMessages() { return messages; }

    public void setMessages(List<Message> messages) { this.messages = messages; }

    public String getAvatar_color() { return avatar_color; }

    public void setAvatar_color(String avatar_color) { this.avatar_color = avatar_color; }
}
