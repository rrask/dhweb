package com.drughire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import com.drughire.entity.*;

public interface BlogRepository extends JpaRepository<Blog,Integer>{
	
	List<Blog> findByUser(User user);

}
