package com.senperchan.novel.core.service;

import com.senperchan.novel.core.model.Student;

import java.util.List;

/**
 * Created by Semper on 2017/4/27.
 */
public interface StudentService {

    List<Student> findAllStudent();

    void deleteById(Long id);

    void delete(Student student);

    void addStudent(Student student);

    void updateStudent(Student student);

    Student findByName(String name);

}
