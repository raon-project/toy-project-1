package com.rara.toy1.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rara.toy1.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
