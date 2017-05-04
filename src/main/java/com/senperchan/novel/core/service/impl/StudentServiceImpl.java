package com.senperchan.novel.core.service.impl;

import com.senperchan.novel.core.model.Student;
import com.senperchan.novel.core.repository.StudentRepository;
import com.senperchan.novel.core.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Semper on 2017/4/27.
 */
@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        studentRepository.delete(id);
    }

    @Transactional
    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
        studentRepository.flush();
    }

    @Transactional
    @Override
    public void addStudent(Student student) {
        studentRepository.saveAndFlush(student);
    }

    @Transactional
    @Override
    public void updateStudent(Student student) {
        log.debug(student.getName()+",id="+student.getId());
        studentRepository.saveAndFlush(student);
    }

    @Transactional
    @Override
    public Student findByName(String name) {
        Student student=studentRepository.findByName(name);
        log.debug("----------------id="+student.getId()+",name="+student.getName());
        return student;
    }
}
