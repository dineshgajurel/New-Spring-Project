package com.javastud.springmvcweb.dao;

import java.util.List;

import com.javastud.springmvcweb.model.Student;

public interface StudentDao {
public Long insert(Student student);
public void insertUpdate(Student student);
public List<Student> getAll();
public Student get(Long id);
public void delete(Long id);
}
