package com.southwind.controller;


import com.southwind.entity.Student;
import com.southwind.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.southwind.repository.StudentRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RESTHandler {

    @Autowired //通过类型取注入 （bean？）
    private StudentRepository studentRepository;
    @GetMapping("/findAll")
    public Collection<Student> findAll(HttpServletResponse response){
        response.setContentType("text/json;charset=UTF-8");
        return studentRepository.findAll();
    }


    @RequestMapping("/test")
    public User  test(){
        User user =new User();
        user.setName("阿里");
        return user;
    }


    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return studentRepository.findById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }
    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        studentRepository.deleteById(id);
    }


}
