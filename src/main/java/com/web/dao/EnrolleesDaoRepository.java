package com.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.dao.entity.Enrollees;

public interface EnrolleesDaoRepository extends JpaRepository<Enrollees, Integer>{
}
