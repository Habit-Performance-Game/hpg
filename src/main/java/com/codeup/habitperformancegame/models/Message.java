package com.codeup.habitperformancegame.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "messages")
public class Message {
    @Id @GeneratedValue
    public long id;

    @Column(nullable = false)
    public String title;

    @Column(nullable = false, columnDefinition = "text")
    public String body;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    public User created_by;


    @ManyToMany(cascade = ALL)
    @JoinTable(
            name="users_messages",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="message_id")}
    )
    public List<User> sent_to;

    @CreationTimestamp
    @Column(updatable = false)
    public Date created_on;




    //    ##########################         constructors             ########################


    public Message() {
    }

    public Message(String title, String body, User created_by, Date created_on) {
        this.title = title;
        this.body = body;
        this.created_by = created_by;
        this.created_on = created_on;
    }

    public Message(String title, String body, User created_by, List<User> sent_to, Date created_on) {
        this.title = title;
        this.body = body;
        this.created_by = created_by;
        this.sent_to = sent_to;
        this.created_on = created_on;
    }
    //    ##########################         getters and setters      ########################


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public List<User> getSent_to() {
        return sent_to;
    }

    public void setSent_to(List<User> sent_to) {
        this.sent_to = sent_to;
    }
}
