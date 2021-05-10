package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.UsersDao;
import com.springrest.springrest.entities.Users;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao usersDao;
	
//	List<Users> list = null;
	
	public UsersServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Users(1,"Core java Users","This Users contains core java principles"));
//		list.add(new Users(2,"Advanced java Users","This Users contains advanced java principles"));
	}

	@Override
	public List<Users> getUsers() {
		List<Users> list = new ArrayList();
		list = usersDao.findAll();
		
		List<Users> list1 = new ArrayList();
		for(Users row: list) {
			if((Long)row.getId() == 6L ||(Long)row.getId() == 2L) {
				Users u = new Users();
				u.setId(row.getId());
				u.setEmail(row.getEmail());
				u.setFirstname(row.getFirstname());
				u.setLastname(row.getLastname());
				u.setPassword(row.getPassword());
				list1.add(u);
			}
		}
		return list1;
	}
	
	@Override
	public Users getUsers(long usersId) {
//		Users Users = null;
//		for(Users obj : list) {
//			if(obj.getId() == usersId) {
//				Users = obj;
//				break;
//			}
//		}
		return usersDao.getOne(usersId);
	}

	@Override
	public Users addUsers(Users user) {
//		list.add(Users);
		usersDao.save(user);
		return user;
	}
	
	
	
	public Users updateUsers(Users user) {
//		for(Users itr : list) {
//			if(itr.getId() == Users.getId()) {
//				//c.setId(Users.getId());
//				itr.setTitle(Users.getTitle());
//				itr.setDescription(Users.getDescription());
//			}
//		}
		usersDao.save(user);
		return user;
	}
	
	public void deleteUsers(long usersId) {
		
//		for(Users itr : list) {
//			if(itr.getId() == usersId) {
//				c= itr;
//				list.remove(itr);
//				break;
//			}
//		}
//		list = this.list.stream().filter(e -> e.getId() != usersId).collect(Collectors.toList());
		Users user = usersDao.getOne(usersId);
		usersDao.delete(user);
	}

	@Override
	public Users authUser(Users user) {
		List<Users> allUsers = new ArrayList<Users>();
		allUsers = usersDao.findAll();
		String email = user.getEmail();
		String password = user.getPassword();
		Users userPresent = new Users();
		boolean userFound = false;
		for(Users currentUser : allUsers) {
			if(currentUser.getEmail().equals(email)) {
				if(currentUser.getPassword().equals(password)) {
					userFound=true;
					userPresent.setId(currentUser.getId());
					userPresent.setEmail(currentUser.getEmail());
					userPresent.setFirstname(currentUser.getFirstname());
					userPresent.setLastname(currentUser.getLastname());
					userPresent.setToken(currentUser.getToken());
					return userPresent;
				}
			}
		}
		return null;
		
	}

	@Override
	public Users validateUser(String token) {
		List<Users> list = usersDao.findAll();
		for(Users currUser : list) {
			if(currUser.getToken().equals(token)) {
				return currUser;
			}
		}
		return null;
	}

	@Override
	public Users updateUser(Users user) {
		Users user1 = usersDao.getOne(user.getId());
		user1.setUserScrore(user.getUserScrore());
		usersDao.save(user1);
		return user1;
	}
	
	
	
}
