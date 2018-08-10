package com.yit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yit.entities.GwRole;
@Repository

public interface RoleRepository extends JpaRepository<GwRole, Long>{

}
