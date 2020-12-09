package com.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.dao.entity.Dependent;

public interface DependentDaoRepository extends JpaRepository<Dependent, Integer>{

}
