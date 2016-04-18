package com.javastud.springmvcweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javastud.springmvcweb.dao.StudentDao;
import com.javastud.springmvcweb.model.Student;

@RestController
@RequestMapping("api/rest")
public class RestControllers {
@Autowired
private StudentDao studentDao;

public ResponseEntity<List<Student>> index(){
ResponseEntity<List<Student>> studs=new ResponseEntity<List<Student>>(studentDao.getAll(),HttpStatus.OK);
	return studs;
}
}
