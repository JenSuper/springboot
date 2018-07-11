package com.rd.repository;

import com.rd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * spring data jpa
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
