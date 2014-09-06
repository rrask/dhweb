package com.drughire.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import org.springframework.transaction.annotation.Transactional;

import com.drughire.entity.*;
import com.drughire.repository.BlogRepository;
import com.drughire.repository.ItemRepository;
//import com.drughire.repository.*;
import com.drughire.repository.RoleRepository;
import com.drughire.repository.UserRepository;

@Transactional
@Service
public class InitDBService {

	@Autowired
	private RoleRepository roleRepository;// Spring will auto inject an instance
											// that it instantiates from
											// RoleReposity Interface
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private BlogRepository blogRepository;
	
	@PostConstruct
	public void init(){
		
		System.out.println("Rask INIT service");
		Role roleUser = new Role();
		roleUser.setName("Role_User");
		
		roleRepository.save(roleUser);
		System.out.println("Rask INIT A");
		Role roleAdmin = new Role();
		roleAdmin.setName("Admin_User");
	
		roleRepository.save(roleAdmin);
		System.out.println("Rask INIT B");
		User userAdmin = new User();
		userAdmin.setName("Admin");
		userAdmin.setPassword("Admin");
		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(roleUser);
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogJavavids = new Blog();
		blogJavavids.setName("JavaVids");
		blogJavavids.setUrl("");
		blogJavavids.setUser(userAdmin);
		blogRepository.save(blogJavavids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavavids);
		item1.setTitle("First");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogJavavids);
		item2.setTitle("Second");
		item2.setLink("http://www.javasdfsdf.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);

		Item item3 = new Item();
		item3.setBlog(blogJavavids);
		item3.setTitle("Third");
		item3.setLink("http://www.javavids123.com");
		item3.setPublishedDate(new Date());
		itemRepository.save(item3);
		
		Item item4 = new Item();
		item4.setBlog(blogJavavids);
		item4.setTitle("Fourth");
		item4.setLink("http://www.javavids123.com");
		item4.setPublishedDate(new Date());
		itemRepository.save(item4);
		
		
	}
}
