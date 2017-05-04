package com.senperchan.novel.core.service.impl;

import com.senperchan.novel.core.model.Grade;
import com.senperchan.novel.core.repository.GradeRepository;
import com.senperchan.novel.core.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Semper
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepository gradeRepository;

    @Override
    public List<Grade> getAllGrade() {
        return gradeRepository.findAll();
    }
}
