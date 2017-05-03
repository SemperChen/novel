package com.senperchan.novel.core.web;

import com.senperchan.novel.core.model.Student;
import com.senperchan.novel.core.service.StudentService;
import org.json.JSONObject;
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

    final String URL = "/student";

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = URL+"/json", method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<String> showStudents() throws org.json.JSONException {
        List<Student> blogList = studentService.findAllStudent();

        List<JSONObject> entities = new ArrayList<>();
        for (Student b : blogList) {

            JSONObject entity = new JSONObject();

            entity.put("id", b.getId());
            entity.put("name", b.getName());
            entities.add(entity);
        }
        String text=entities.toString();
        return new ResponseEntity<>(text, HttpStatus.OK);
    }

    @RequestMapping(value = URL,method = RequestMethod.GET)
    public String get(ModelMap modelMap) {
        List<Student> studentList=studentService.findAllStudent();
        modelMap.addAttribute("students", studentList);
        return URL;
    }

    @RequestMapping(value = URL,method = RequestMethod.POST)
    public String post(ModelMap modelMap,@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            modelMap.addAttribute("students", studentService.findAllStudent());
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
