package com.daoimpl;

import java.util.List;

import com.entities.UserDetails;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoapi.UsersDao;
import com.entities.Users;


@Repository
@Transactional
public class UsersImpl implements UsersDao{

	@Autowired
	SessionFactory session;


	public boolean update(Users users){
	    session.getCurrentSession().update(users);
	    return true;
    }
	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		//System.out.println("user recieved = " + users);
		session.getCurrentSession().saveOrUpdate(users);
		//List<Users> userList = session.getCurrentSession().createQuery("Select * from Users").list();
		//System.out.println(userList);

		return true;
	}

	public List<Users> list() {
		//System.out.println("list called : " + session.getCurrentSession().createQuery("from Users").list());

		return session.getCurrentSession().createQuery("from Users").list();
	}

	public boolean delete(Users users) {
		try{
			session.getCurrentSession().delete(users);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}

    public boolean saveOrUpdate2(UserDetails users) {
        // TODO Auto-generated method stub
        //System.out.println("user recieved = " + users);
        session.getCurrentSession().saveOrUpdate(users);
        //List<Users> userList = session.getCurrentSession().createQuery("Select * from Users").list();
        //System.out.println(userList);

        return true;
    }

    public List<UserDetails> list2() {
        //System.out.println("list called : " + session.getCurrentSession().createQuery("from Users").list());

        return session.getCurrentSession().createQuery("from UserDetails").list();
    }
    public List<Users> appl(){

		return session.getCurrentSession().createQuery("from Users where user_id=1").list();
	}
}
