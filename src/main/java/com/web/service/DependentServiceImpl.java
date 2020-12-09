package com.web.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.controller.vo.DependentVO;
import com.web.dao.DependentDaoRepository;
import com.web.dao.EnrolleesDaoRepository;
import com.web.dao.entity.Dependent;
import com.web.dao.entity.Enrollees;

@Service
public class DependentServiceImpl implements DependentService {

	@Autowired
	private EnrolleesDaoRepository enrolleesDaoRepository;

	@Autowired
	private DependentDaoRepository dependentDaoRepository;

	@Override
	@Transactional
	public void update(DependentVO dependentVO) {
		saveDependent(dependentVO);
	}

	@Override
	@Transactional
	public void save(DependentVO dependentVO) {
		saveDependent(dependentVO);
	}

	private void saveDependent(DependentVO dependentVO) {
		Enrollees enrollees = enrolleesDaoRepository.findById(dependentVO.getEnrolleesId()).orElseThrow(
				() -> new EntityNotFoundException("No Enrollee found with Id:" + dependentVO.getEnrolleesId()));
		Dependent dependent = new Dependent();
		BeanUtils.copyProperties(dependentVO, dependent);
		dependent.setEnrollees(enrollees);
		dependentDaoRepository.save(dependent);
	}

	@Override
	@Transactional
	public void delete(int id) {
		dependentDaoRepository.deleteById(id);
	}

	@Override
	public List<DependentVO> findAll() {
		return enrolleesDaoRepository.findAll().stream().map(item -> {
			DependentVO dependentVO = new DependentVO();
			BeanUtils.copyProperties(item, dependentVO);
			return dependentVO;
		}).collect(Collectors.toList());
	}

}
