package com.codeup.habitperformancegame.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id @GeneratedValue
    public long id;

    @Column(nullable = false, unique = true)
    public String category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Badge> badges;

//    ##########################         constructors             ########################

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

//    ##########################         getters and setters             ########################
    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
