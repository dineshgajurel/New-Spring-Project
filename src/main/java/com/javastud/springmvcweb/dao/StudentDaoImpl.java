package com.javastud.springmvcweb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javastud.springmvcweb.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Long insert(Student student) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(student);
		return id;

	}

	@Override
	@Transactional
	public void insertUpdate(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
	}

	@Override
	public List<Student> getAll() {
		Session session =sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Student.class);
		List<Student> studentList=(List<Student>)criteria.list();
		
		return studentList;
	}

	@Override
	public Student get(Long id) {
		Session session =sessionFactory.openSession();
		Student student=(Student)session.get(Student.class, id);
		return student;
	}
	
	@Override
	@Transactional
	public void delete(Long id){
		Session session =sessionFactory.getCurrentSession();
		Student student=(Student)session.get(Student.class, id);
		session.delete(student);	
	}

}
