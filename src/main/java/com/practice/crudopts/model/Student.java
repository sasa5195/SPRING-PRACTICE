package com.practice.crudopts.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Students")
public class Student {
    @Id
    private int id;
    @ApiModelProperty(value = "Full Name", required = true)
    private String name;
    private String email;
}
