package com.senperchan.novel.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author Semper
 */
@Entity
@Table(name="grade")
public class Grade implements Serializable{

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "level")
    private String level;

    @OneToMany(mappedBy = "grade")
    private Collection<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
}
