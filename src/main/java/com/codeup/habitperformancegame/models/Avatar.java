package com.codeup.habitperformancegame.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "avatars")
public class Avatar {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "text")
    private String url;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avatar")
    private List<User> users;


//    ##########################         constructors             ########################


    public Avatar() {
    }

    public Avatar(String name, String url) {
        this.name = name;
        this.url = url;
    }

//    ##########################         getters and setters             ########################


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
