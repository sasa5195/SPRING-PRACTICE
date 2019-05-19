package com.practice.crudopts.controller;

import com.practice.crudopts.model.Student;
import com.practice.crudopts.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Api(tags = "Students")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    @ApiOperation(value = "Get All Records of Student")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudents(@RequestBody Student student, HttpServletRequest request, HttpServletResponse response) {
        Student student1 = studentService.saveStudent(student);
        response.setHeader("location", request.getRequestURL().append("/").append(student1.getId()).toString());
//        return students;
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@RequestBody Student student) {
        studentService.deleteStudent(student);
    }

    @GetMapping("/paging")
    public Page<Student> getStudentsByPage(Pageable pageable) {
        return studentService.fetchStudentsByPage(pageable);
    }
}
