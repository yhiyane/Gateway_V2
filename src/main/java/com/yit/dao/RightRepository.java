package com.yit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yit.entities.GwRight;
@Repository
public interface RightRepository extends JpaRepository<GwRight, Long>{

}
