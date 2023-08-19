package com.security.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.test.model.AppUser;

@Service
public class AppUserService {
	
	List<AppUser> list = new ArrayList<>();

	public AppUserService() {
		super();
		list.add(new AppUser("satya","gg@gmail.com","GG@123"));
		list.add(new AppUser("subha","sp@gmail.com","spd@123"));
	}
	
	//get all users
	public List<AppUser> getAllAppUsers(){
		return this.list;
	}
	
	//get user by username
	public AppUser getAppUserByName(String username) {
		return this.list.stream().filter(user -> user.getUsername().equals(username)).findAny().get();
	}
	
	//add new user
	public AppUser addNewAppUser(AppUser appUser) {
		this.list.add(appUser);
		return appUser;
	}
	
}
