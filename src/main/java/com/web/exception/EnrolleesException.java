package com.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EnrolleesException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final transient Logger logger = LoggerFactory.getLogger(this.getClass());

	public EnrolleesException(String exception) {
		super(exception);
		logger.info(exception);
	}

}
