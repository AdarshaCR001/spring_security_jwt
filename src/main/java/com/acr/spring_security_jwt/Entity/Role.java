package com.acr.spring_security_jwt.Entity;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

//    public Role() {
//        this.users = new HashSet<>();
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void addUser(User user) {
//        this.users.add(user);
//        user.getRoles().add(this);
//    }
//
//    public void removeUser(User user) {
//        this.users.remove(user);
//        user.getRoles().remove(this);
//    }
}
