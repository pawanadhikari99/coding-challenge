package com.web.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.web.controller.vo.EnrolleesVO;
import com.web.service.DependentService;
import com.web.service.EnrolleesService;
import com.web.test.TestUtil;

public class EnrolleesApiControllerTest {

	private MockMvc mockMvc;

	@Mock
	private EnrolleesService enrollessService;

	@Mock
	private DependentService dependentService;

	@InjectMocks
	private EnrolleesApiController enrolleesApiController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(enrolleesApiController).build();
	}
	
	
	@Test
	public	void testAddEnrolleesWhenSuccess() throws Exception {
		EnrolleesVO enrolleesVO=new EnrolleesVO();
		enrolleesVO.setActive(true);
		enrolleesVO.setName("Maks");
		enrolleesVO.setPhoneNumber(new Long(1323));
		
	 	 mockMvc.perform(MockMvcRequestBuilders.post("/v4/enrollees")
	 	        .contentType(MediaType.APPLICATION_JSON)
	 	        .content(TestUtil.convertObjectToJsonBytes(enrolleesVO))
	 			.accept(MediaType.APPLICATION_JSON))
	 			.andExpect(jsonPath("$.code").exists())
	 			.andExpect(jsonPath("$.message").exists())
	 			.andExpect(jsonPath("$.code").value("200"))
	 			.andExpect(jsonPath("$.message").value("Record is created successfully!"))
	 			.andDo(print());
	}


	@Test
	public void testGetEnrolleesWhenNotEmpty() throws Exception {
		List<EnrolleesVO> enrolleesVOs = new ArrayList<>();
		EnrolleesVO enrolleesVO1 = new EnrolleesVO();
		enrolleesVO1.setActive(true);
		enrolleesVO1.setDob(new Date());
		enrolleesVO1.setName("Jack");

		EnrolleesVO enrolleesVO2 = new EnrolleesVO();
		enrolleesVO2.setActive(false);
		enrolleesVO2.setDob(new Date());
		enrolleesVO2.setName("Maks");
		enrolleesVOs.add(enrolleesVO1);
		enrolleesVOs.add(enrolleesVO2);

		when(enrollessService.findAll()).thenReturn(enrolleesVOs);

		mockMvc.perform(get("/v4/enrollees")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", is("Jack"))).andExpect(jsonPath("$[1].name", is("Maks")));
		verify(enrollessService, times(1)).findAll();
		verifyNoMoreInteractions(enrollessService);
	}
	
	@Test
	public void testGetEnrolleesWhenEmpty() throws Exception {
		List<EnrolleesVO> enrolleesVOs = new ArrayList<>();
		when(enrollessService.findAll()).thenReturn(enrolleesVOs);
		mockMvc.perform(get("/v4/enrollees")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(0)));
		verify(enrollessService, times(1)).findAll();
		verifyNoMoreInteractions(enrollessService);
	}

}
