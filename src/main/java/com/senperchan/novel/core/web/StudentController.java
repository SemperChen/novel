package com.senperchan.novel.core.web;

import com.senperchan.novel.core.model.Grade;
import com.senperchan.novel.core.model.Student;
import com.senperchan.novel.core.service.GradeService;
import com.senperchan.novel.core.service.StudentService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Semper on 2017/4/27.
 */
@Controller
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    private final String URL = "/student";

    private  StudentService studentService;
    private  GradeService gradeService;

    @Autowired
    public StudentController(StudentService studentService,GradeService gradeService) {
        this.studentService = studentService;
        this.gradeService=gradeService;
    }

    @RequestMapping(value = URL+"/json", method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<String> showStudents() throws org.json.JSONException {
        List<Student> students = studentService.findAllStudent();

        List<JSONObject> entities = new ArrayList<>();
        for (Student s : students) {

            JSONObject entity = new JSONObject();

            entity.put("id", s.getId());
            entity.put("name", s.getName());
            entities.add(entity);
        }
        String text=entities.toString();
        return new ResponseEntity<>(text, HttpStatus.OK);
    }

    @RequestMapping(value = URL,method = RequestMethod.GET)
    public String get(ModelMap modelMap) {
        List<Student> studentList=studentService.findAllStudent();
        List<Grade> grades=gradeService.getAllGrade();

        modelMap.addAttribute("students", studentList);
        modelMap.addAttribute("grades", grades);

        return URL;
    }

    @RequestMapping(value = URL,method = RequestMethod.POST)
    public String post(ModelMap modelMap,@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            modelMap.addAttribute("students", studentService.findAllStudent());
            modelMap.addAttribute("grades", gradeService.getAllGrade());
            return URL;
        }
        studentService.addStudent(student);

        return "redirect:" + URL;
    }

    @RequestMapping(value = URL+"/update",method = RequestMethod.POST)
    public String update(@Valid Student student){
        studentService.updateStudent(student);
        return "redirect:" + URL;
    }

    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return "redirect:" + URL;
    }

    @RequestMapping(value = URL+"/name",method = RequestMethod.GET)
    public String findByName(){
        studentService.findByName("ww");
        return "redirect:" + URL;
    }

}
