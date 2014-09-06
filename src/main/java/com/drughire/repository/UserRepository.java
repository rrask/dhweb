package com.drughire.repository;

import org.springframework.data.jpa.repository.*;

import com.drughire.entity.*;

public interface UserRepository extends JpaRepository<User,Integer>{

}
