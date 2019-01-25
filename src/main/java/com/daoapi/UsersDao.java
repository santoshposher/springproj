package com.daoapi;

import java.util.List;

import com.entities.Users;
import com.entities.UserDetails;
public interface UsersDao {
	public boolean saveOrUpdate(Users users);
	public List<Users> list();
	public boolean delete(Users users);
	public boolean saveOrUpdate2(UserDetails users);
	public List<UserDetails> list2();
	public List<Users> appl();
}
