package com.web.controller.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrolleesVO {
	private int id;
	private String name;
	private boolean active;
	private Date dob;
	private Long phoneNumber;
    	
}
