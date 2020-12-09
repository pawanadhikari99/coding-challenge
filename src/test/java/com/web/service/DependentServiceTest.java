package com.web.service;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.web.controller.vo.DependentVO;
import com.web.dao.DependentDaoRepository;
import com.web.dao.EnrolleesDaoRepository;
import com.web.dao.entity.Dependent;
import com.web.dao.entity.Enrollees;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class DependentServiceTest {

	@Mock
	private EnrolleesDaoRepository enrolleesDaoRepository;
	
	@Mock
	private DependentDaoRepository dependentDaoRepository;

	@InjectMocks
	private DependentServiceImpl dependentServiceImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldSave() {
		DependentVO dependentVO = new DependentVO();
		dependentVO.setId(1);
		dependentVO.setDob(new Date());
		dependentVO.setEnrolleesId(1);
		dependentVO.setName("test");
		Enrollees enrollees = new Enrollees();
		Mockito.when(enrolleesDaoRepository.findById(dependentVO.getEnrolleesId())).thenReturn(Optional.of(enrollees));
		Mockito.when(dependentDaoRepository.save(Mockito.mock(Dependent.class))).thenReturn(new Dependent());
		dependentServiceImpl.update(dependentVO);
		Mockito.verify(dependentDaoRepository, Mockito.times(1)).save(Mockito.any());
	}

	@Test
	public void shouldDelete() {
		DependentVO dependentVO = new DependentVO();
		dependentVO.setId(1);
		doNothing().when(dependentDaoRepository).deleteById(dependentVO.getId());
		dependentServiceImpl.delete(dependentVO.getId());
		Mockito.verify(dependentDaoRepository, Mockito.times(1)).deleteById(Mockito.any());
	}

	@Test
	public void shouldUpdate() {
		DependentVO dependentVO = new DependentVO();
		dependentVO.setId(1);
		dependentVO.setDob(new Date());
		dependentVO.setEnrolleesId(1);
		dependentVO.setName("test");
		Enrollees enrollees = new Enrollees();
		Mockito.when(enrolleesDaoRepository.findById(dependentVO.getEnrolleesId())).thenReturn(Optional.of(enrollees));
		Mockito.when(dependentDaoRepository.save(Mockito.mock(Dependent.class))).thenReturn(new Dependent());
		dependentServiceImpl.update(dependentVO);
		Mockito.verify(dependentDaoRepository, Mockito.times(1)).save(Mockito.any());
	}

}
