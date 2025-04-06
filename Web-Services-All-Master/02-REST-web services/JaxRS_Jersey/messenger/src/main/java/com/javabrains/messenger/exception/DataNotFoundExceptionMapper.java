package com.javabrains.messenger.exception;

import com.javabrains.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404,"http://localhost:8080/messenger/error");

		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		
	}

}
