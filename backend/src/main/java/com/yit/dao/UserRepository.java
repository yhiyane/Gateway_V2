package com.yit.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yit.entities.GwUser;

public interface UserRepository extends JpaRepository<GwUser, Long>{
	@Query("select u from GwUser u where u.firstName like :x")
	public Page<GwUser> chercher(@Param("x")String mc, Pageable pageable);
}
