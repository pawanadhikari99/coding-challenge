package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.web.controller.vo.ApplicationResponseVO;
import com.web.controller.vo.DependentVO;
import com.web.controller.vo.EnrolleesVO;
import com.web.service.DependentService;
import com.web.service.EnrolleesService;

@RestController
@RequestMapping("/v4")
public class EnrolleesApiController {

	@Autowired
	private EnrolleesService enrollessService;

	@Autowired
	private DependentService dependentService;

	@PostMapping("/enrollees/dependents")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ApplicationResponseVO addDependent(@RequestBody DependentVO dependentVO) {
		dependentService.save(dependentVO);
		ApplicationResponseVO applicationResponseVO = new ApplicationResponseVO();
		applicationResponseVO.setCode(200);
		applicationResponseVO.setMessage("Record is created successfully!");
		return applicationResponseVO;
	}

	@PutMapping("/enrollees/dependents")
	@ResponseStatus(code = HttpStatus.OK)
	public ApplicationResponseVO updateDependent(@RequestBody DependentVO dependentVO) {
		dependentService.update(dependentVO);
		ApplicationResponseVO applicationResponseVO = new ApplicationResponseVO();
		applicationResponseVO.setCode(200);
		applicationResponseVO.setMessage("Record is created successfully!");
		return applicationResponseVO;
	}

	@PutMapping("/enrollees/dependents/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ApplicationResponseVO deleteDependent(@PathVariable int id) {
		dependentService.delete(id);
		ApplicationResponseVO applicationResponseVO = new ApplicationResponseVO();
		applicationResponseVO.setCode(200);
		applicationResponseVO.setMessage("Record is delete successfully!");
		return applicationResponseVO;
	}

	@GetMapping("/enrollees/dependents")
	@ResponseStatus(code = HttpStatus.OK)
	public List<DependentVO> findDependents() {
		return dependentService.findAll();
	}

	@PostMapping("/enrollees")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ApplicationResponseVO addEnrollees(@RequestBody EnrolleesVO enrollees) {
		enrollessService.save(enrollees);
		ApplicationResponseVO applicationResponseVO = new ApplicationResponseVO();
		applicationResponseVO.setCode(200);
		applicationResponseVO.setMessage("Record is created successfully!");
		return applicationResponseVO;
	}

	@PutMapping("/enrollees")
	@ResponseStatus(code = HttpStatus.OK)
	public ApplicationResponseVO updateEnrollees(@ModelAttribute EnrolleesVO enrollees, Model model) {
		enrollessService.update(enrollees);
		ApplicationResponseVO applicationResponseVO = new ApplicationResponseVO();
		applicationResponseVO.setCode(201);
		applicationResponseVO.setMessage("Record is update successfully!");
		return applicationResponseVO;
	}

	@GetMapping("/enrollees")
	@ResponseStatus(code = HttpStatus.OK)
	public List<EnrolleesVO> getEnrollees() {
		return enrollessService.findAll();
	}

	@DeleteMapping("/enrollees/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ApplicationResponseVO deleteEnrollees(@PathVariable int id) {
		enrollessService.delete(id);
		ApplicationResponseVO applicationResponseVO = new ApplicationResponseVO();
		applicationResponseVO.setCode(201);
		applicationResponseVO.setMessage("Record is update successfully!");
		return applicationResponseVO;
	}

}
