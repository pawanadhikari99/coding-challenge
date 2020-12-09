package com.web.controller.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ApplicationResponseVO {
	private int code;
	private String message;
}