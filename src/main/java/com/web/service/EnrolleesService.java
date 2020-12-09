package com.web.service;

import java.util.List;

import com.web.controller.vo.EnrolleesVO;

public interface EnrolleesService {

	void update(EnrolleesVO enrolleesVO);

	void save(EnrolleesVO enrolleesVO);
	
	void delete(int id);

	List<EnrolleesVO> findAll();

}
