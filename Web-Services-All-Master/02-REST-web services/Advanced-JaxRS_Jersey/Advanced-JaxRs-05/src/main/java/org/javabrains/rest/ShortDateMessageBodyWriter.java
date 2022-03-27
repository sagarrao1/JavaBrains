package org.javabrains.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Date;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces("text/shortdate")
public class ShortDateMessageBodyWriter  implements MessageBodyWriter<Date>{

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		
		return Date.class.isAssignableFrom(type);		
		/*
		 * System.out.println(type.getName()); System.out.println(Date.class.getName());
		 * We can use below as well to verify equalit
		 */
//		return type.getName().equals(Date.class.getName());
		
	}

	@Override
	public void writeTo(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
//		String shortDate= date.getDate()+"/"+date.getMonth()+" / "+date.getYear();
		LocalDate localDate = LocalDate.now();
//		System.out.println(localDate.toString());
		entityStream.write(localDate.toString().getBytes());
	}

}
