package com.example.accessingdatajpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies;

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public AddressBook() {
        this("Default");
    }

    public AddressBook(String name) {
        this.name = name;
        buddies = new ArrayList<>();
    }

    public boolean addBuddy(BuddyInfo buddy) {
        return buddies.add(buddy);
    }

    public int size() {
        return buddies.size();
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public List<BuddyInfo> getBuddies() {
        return this.buddies;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void removeBuddy(Integer id) {
        for (int i = 0; i < this.buddies.size(); i++) {
            if (this.buddies.get(i).getId().equals(id)) {
                this.buddies.remove(i);
                break;
            }
        }
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String s = "";
        s += "Name: " + this.name +
                " ID: " + this.id;

        return s;
    }
}