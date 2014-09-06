package com.drughire.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import com.drughire.entity.*;

public interface ItemRepository extends JpaRepository<Item,Integer>{
	
	List<Item> findByBlog(Blog blog, Pageable pageable);

}
