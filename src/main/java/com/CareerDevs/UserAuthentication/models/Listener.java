package com.CareerDevs.UserAuthentication.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;

// let spring boot know this is a database -@Entity
@Entity
public class Listener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //uuid (is a garanteed random number)

    private Long id;
    private String name;
    private Integer age;

    // later we will add genre and user


    //default constructors jpa needs this
    @OneToMany(mappedBy = "listener", fetch = FetchType.LAZY) // match the variable name in the @Entity
    @JsonIgnore
    private Set<Note> note; //set does not include duplicates.

    public Listener() {
    }
    public Set<Note> getNote() {
        return note;
    }


    public void setNote(Set<Note> note) {
        this.note = note;
    }
    //don't include collections


    public Listener(Long id, String name, Integer age) {
        this.id = id;
        name = name;
        this.age = age;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}