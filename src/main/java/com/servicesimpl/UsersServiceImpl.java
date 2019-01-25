package com.servicesimpl;

import java.util.List;

import com.entities.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.UsersDao;
import com.entities.Users;
import com.servicesapi.UsersService;
import com.entities.UserDetails;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersDao userDao;
	public boolean saveOrUpdate(Users users) {
		return userDao.saveOrUpdate(users);
	}

	public List<Users> list() {
		return userDao.list();
	}

	public boolean delete(Users users) {
		return userDao.delete(users);
	}

	public boolean saveOrUpdate2(UserDetails users) {
		return userDao.saveOrUpdate2(users);
	}

	public List<UserDetails> list2() {
		return userDao.list2();
	}

	public List<Users>appl(){

		return userDao.appl();
	}

}
