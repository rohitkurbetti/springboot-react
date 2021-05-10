package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Users;

public interface UsersService {
	
	public List<Users> getUsers();
	
	public Users getUsers(long usersId);
	
	public Users addUsers(Users users);
	
	public Users updateUsers(Users users);
	
	public void deleteUsers(long usersId);

	public Users authUser(Users user);

	public Users validateUser(String token);

	public Users updateUser(Users user);

}
