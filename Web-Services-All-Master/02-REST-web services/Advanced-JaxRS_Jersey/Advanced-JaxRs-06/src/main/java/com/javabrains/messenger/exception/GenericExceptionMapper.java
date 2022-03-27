package com.javabrains.messenger.exception;

import com.javabrains.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

//@Provider
public class GenericExceptionMapper implements  ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errMsg = new ErrorMessage(exception.getMessage(),500,"http://localhost:8080/messenger/error");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(errMsg)
						.build();
	}

}
