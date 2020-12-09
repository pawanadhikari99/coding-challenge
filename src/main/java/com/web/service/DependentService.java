package com.web.service;

import java.util.List;

import com.web.controller.vo.DependentVO;

public interface DependentService {

	void update(DependentVO dependentVO);

	void save(DependentVO dependentVO);
	
	void delete(int id);

	List<DependentVO> findAll();

}
