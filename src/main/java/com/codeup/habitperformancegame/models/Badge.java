package com.codeup.habitperformancegame.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "badges")
public class Badge {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int req_amt;

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;

    @Column(nullable = false)
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "badge")
    private List<User_Badge> user_badges;


//    ##########################         constructors             ########################


    public Badge() {
    }

    public Badge(String name, int req_amt, Category category, String type) {
        this.name = name;
        this.req_amt = req_amt;
        this.category = category;
        this.type = type;
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

    public int getReq_amt() {
        return req_amt;
    }

    public void setReq_amt(int req_amt) {
        this.req_amt = req_amt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User_Badge> getUser_badges() {
        return user_badges;
    }

    public void setUser_badges(List<User_Badge> user_badges) {
        this.user_badges = user_badges;
    }
}
