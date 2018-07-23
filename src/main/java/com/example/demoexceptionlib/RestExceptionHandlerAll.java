package com.example.demoexceptionlib;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demoexceptionlib.model.BaseErrorDTO;

import lombok.extern.slf4j.Slf4j;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandlerAll {

	/**
	 * variable para dar formato a fecha
	 */
	private SimpleDateFormat dataFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

	/**
	 * Handle general Exception
	 *
	 **/
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<BaseErrorDTO> handleAllExceptions(Exception ex) {

		BaseErrorDTO baseError = BaseErrorDTO.builder()
				.message("Error inesperado")
				.timestamp(dataFormat.format(new Date()))
				.code("500-006").build();
		log.info("manejador de exceptions GENERAL");
		log.error("Error inesperado: ", ex);
		return new ResponseEntity<BaseErrorDTO>(baseError, INTERNAL_SERVER_ERROR);

	}

}
