package com.example.accessingdatajpa;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public BuddyInfo(String name) {
        this.name = name;
    }

}
