package com.senperchan.novel.core.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Semper on 2017/4/27.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id()
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
