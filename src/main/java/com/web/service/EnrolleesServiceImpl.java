package com.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.controller.vo.EnrolleesVO;
import com.web.dao.EnrolleesDaoRepository;
import com.web.dao.entity.Enrollees;

@Service
public class EnrolleesServiceImpl implements EnrolleesService {

	@Autowired
	private EnrolleesDaoRepository enrolleesDaoRepository;


	@Override
	@Transactional
	public void update(EnrolleesVO enrolleesVO) {
		Enrollees entity = new Enrollees();
		BeanUtils.copyProperties(enrolleesVO, entity);
		enrolleesDaoRepository.save(entity);
	}

	@Override
	@Transactional
	public void save(EnrolleesVO enrolleesVO) {
		Enrollees entity = new Enrollees();
		BeanUtils.copyProperties(enrolleesVO, entity);
		enrolleesDaoRepository.save(entity);
	}

	@Override
	@Transactional
	public void delete(int id) {
		enrolleesDaoRepository.deleteById(id);
	}

	@Override
	public List<EnrolleesVO> findAll() {
		return enrolleesDaoRepository.findAll().stream().map(item->{
			EnrolleesVO enrolleesVO = new EnrolleesVO();
			BeanUtils.copyProperties(item, enrolleesVO);
			return enrolleesVO;
		}).collect(Collectors.toList());
	}

}
