package com.practice.crudopts.repository;

import com.practice.crudopts.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer>, PagingAndSortingRepository<Student, Integer> {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
}
