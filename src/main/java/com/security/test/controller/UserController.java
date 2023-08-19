package com.security.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.test.model.AppUser;
import com.security.test.service.AppUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private AppUserService appUserService;
	
	@GetMapping("/")
	public List<AppUser> getAllAppUser(){
		return appUserService.getAllAppUsers();
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{username}")
	public AppUser getAppUserByName(@PathVariable("username") String user) {
		return appUserService.getAppUserByName(user);
	}
	
	@PostMapping("/")
	public AppUser addNewAppuser(@RequestBody AppUser appUser) {
		return appUserService.addNewAppUser(appUser);
	}
}
