package com.codeup.habitperformancegame.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clans")
public class Clan {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long owner_id;

    @Column(columnDefinition = "text")
    private String announcements;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clan")
    private List<User> users;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created_on;

//    ##########################         constructors             ########################


    public Clan() {
    }

    public Clan(String name, long owner_id) {
        this.name = name;
        this.owner_id = owner_id;
    }

    public Clan(String name, long owner_id, List<User> users, Date created_on) {
        this.name = name;
        this.owner_id = owner_id;
        this.users = users;
        this.created_on = created_on;
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

    public long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(long owner_id) {
        this.owner_id = owner_id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public String getAnnouncements() { return announcements; }

    public void setAnnouncements(String announcements) { this.announcements = announcements; }
}
