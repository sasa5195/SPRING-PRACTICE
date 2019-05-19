package com.practice.crudopts.service;

import com.practice.crudopts.model.Student;
import com.practice.crudopts.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
//        return getAllStudents();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public Page<Student> fetchStudentsByPage(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }


}
