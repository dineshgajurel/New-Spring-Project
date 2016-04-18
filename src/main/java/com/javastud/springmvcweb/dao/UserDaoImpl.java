package com.javastud.springmvcweb.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javastud.springmvcweb.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;
	
	@Autowired
	private DataSource dataSource;

	@Override
	public User getUser(Long id) {
Session session =sessionFactory.openSession();
   User user =(User)session.get(User.class, id);
   session.close();
		return user;
	}

	@Override
	public boolean validatUser(User user) {
JdbcTemplate jdbcTemplete=new JdbcTemplate(dataSource);
String query="select username from user where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";

try{
String username=jdbcTemplete.queryForObject(query, String.class);
if(username !=null && username.equals(user.getUsername())){
	return true;
}else{
	return false;
}


}catch(Exception e){
	e.printStackTrace();
}
		return false;
	}

}
