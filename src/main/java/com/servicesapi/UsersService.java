package com.servicesapi;

import java.util.List;

import com.entities.UserDetails;
import com.entities.Users;

public interface UsersService {
	public boolean saveOrUpdate(Users users);
	public List<Users> list();
	public boolean delete(Users users);
	public boolean saveOrUpdate2(UserDetails users);
	public List<UserDetails> list2();
	//public boolean delete2(UserDetails users);
	public List<Users>appl();
}
