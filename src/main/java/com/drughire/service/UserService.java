package com.drughire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drughire.entity.Blog;
import com.drughire.entity.Item;
import com.drughire.entity.User;
import com.drughire.repository.*;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	public List<User> findAll() {
		return userRepository.findAll();

	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		User user = this.findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for(Blog blog : blogs){
			List<Item> items =
			itemRepository.findByBlog(blog,new PageRequest(0,10,Direction.DESC,"publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		userRepository.save(user);
	}
}
