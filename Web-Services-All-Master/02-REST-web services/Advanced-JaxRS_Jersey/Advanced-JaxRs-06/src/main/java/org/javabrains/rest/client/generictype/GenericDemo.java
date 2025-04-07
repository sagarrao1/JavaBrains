package org.javabrains.rest.client.generictype;

import java.util.List;

import org.javabrains.rest.client.invocation.InvocationDemo;

import com.javabrains.messenger.model.Message;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class GenericDemo {
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		// 1st way to access List<Messages> using genericType<>
		
		WebTarget baseTarget = client.target("http://localhost:8080/Advanced-JaxRs-06/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages/");
		
		Response response = messagesTarget
							.queryParam("year", 2025)
							.request(MediaType.APPLICATION_JSON)
							.get();
		List<Message> messagelist = response.readEntity(new GenericType<List<Message>>() {});
		messagelist.forEach(m -> System.out.println(m));


//		List response = messagesTarget
//				.queryParam("year", 2025)
//				.request(MediaType.APPLICATION_JSON)
//				.get(List.class);
//		
//		response.forEach(m -> System.out.println(m));

		
//		System.out.println();
		
		// 2nd way to access List<Messages> using genericType<>
//		List<Message> messagelist2 = messagesTarget
//				.queryParam("year", 2022)
//				.request(MediaType.APPLICATION_JSON)
//				.get(new GenericType<List<Message>>() {});
//
//		messagelist2.forEach(m -> System.out.println(m));
//		
//		System.out.println();
//		
//		//Accessing List<messages> using Invocation classs
//		InvocationDemo demo = new InvocationDemo();		
//		Invocation invocationYear = demo.prepareRequestMessagesByYear(2022);
//		Response response3 = invocationYear.invoke();
//		
//		if (response3.getStatus() != 200) {
//			System.out.println("Error..");
//		}
//		
//		List<Message> messagelist3 = response3.readEntity(new GenericType<List<Message>>() {});
//		messagelist3.forEach(m -> System.out.println(m));
	}

}
