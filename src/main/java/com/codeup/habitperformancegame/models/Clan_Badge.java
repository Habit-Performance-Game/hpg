package com.codeup.habitperformancegame.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clan_badges")
public class Clan_Badge {

    @Id@GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "clan_id")
    private Clan clan;

    @ManyToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @Column(nullable = false)
    private int user_amt;

    @Column(nullable = false)
    private boolean has_completed;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created_on;

//    ##########################         constructors             ########################


    public Clan_Badge() {
    }

    public Clan_Badge(Clan clan, Badge badge, int user_amt, boolean has_completed) {
        this.clan = clan;
        this.badge = badge;
        this.user_amt = user_amt;
        this.has_completed = has_completed;
    }

    public Clan_Badge(Clan clan, Badge badge, int user_amt, boolean has_completed, Date created_on) {
        this.clan = clan;
        this.badge = badge;
        this.user_amt = user_amt;
        this.has_completed = has_completed;
        this.created_on = created_on;
    }



//    ##########################         getters and setters             ########################


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Clan getClan() { return clan; }

    public void setClan(Clan clan) { this.clan = clan; }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public int getUser_amt() {
        return user_amt;
    }

    public void setUser_amt(int user_amt) {
        this.user_amt = user_amt;
    }

    public boolean isHas_completed() {
        return has_completed;
    }

    public void setHas_completed(boolean has_completed) {
        this.has_completed = has_completed;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }
}
