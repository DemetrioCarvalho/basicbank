package com.livingit.basicbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livingit.basicbank.model.User;

/**
 * 
 * @author BytesTree
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
