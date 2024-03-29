package com.drughire.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

import com.drughire.entity.Blog;
import com.drughire.entity.User;
import com.drughire.service.BlogService;
import com.drughire.service.UserService;

@Controller
@Transactional
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired BlogService blogService;
	
	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}
	

	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}
	
	@RequestMapping("/users")
	public String users(Model model) {
		// System.out.println("RRask UserController made it");
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String showRegister(){
		
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
	
	@RequestMapping(value="/account")
	public String acount(Model model, Principal principal){
		String name = principal.getName();
		model.addAttribute("user",userService.findOneWithBlogs(name));	
		return "user-detail";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal){
	
		blogService.save(blog,principal.getName());
		return "redirect:/account.html";
	}
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id)
	{
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account.html";
		
	}
	
	@RequestMapping("/users/remove/{id}")
	public String removeUser(@PathVariable int id){
		userService.deleteId(id);
		return  "redirect:/users.html";
	}
}
