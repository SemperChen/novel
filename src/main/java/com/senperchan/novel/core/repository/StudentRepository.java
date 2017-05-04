package com.senperchan.novel.core.repository;

import com.senperchan.novel.core.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * Created by Semper on 2017/4/27.
 */
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
   /*
    @Modifying
    @Transactional
    @Query("UPDATE Student stu SET stu.name=:name WHERE stu.id=:id")
    void updateStudent(@Param("name") String name, @Param("id") Long id);
    @Modifying
    @Transactional
    @Query("UPDATE Student stu SET stu.name='fu' WHERE stu.id=1")
    void updateStu();

    @Query("SELECT s FROM Student s WHERE s.id=1")
    Student findById();*/

    Student findByName(String name);
}
