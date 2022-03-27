package org.javabrains.rest.client.invocation;

import java.util.List;

import com.javabrains.messenger.model.Message;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class InvocationDemo {

	public static void main(String[] args) {
		InvocationDemo demo = new InvocationDemo();
		
		// using id for http://localhost:8080/Advanced-JaxRs-06/webapi/messages/2
//		Invocation invocation = demo.getMessageUsingId(2);
//		Response response = invocation.invoke();
//		if (response.getStatus() != 200) {
//			System.out.println("Error..");
//		}
//		
//		Message message = response.readEntity(Message.class);
//		System.out.println(message.getAuthor());		
		
		
		// using year with Query param as year for http://localhost:8080/Advanced-JaxRs-06/webapi/messages?year=2022
		Invocation invocationYear = demo.getMessageUsingYear(2022);
		Response response2 = invocationYear.invoke();
		
		if (response2.getStatus() != 200) {
			System.out.println("Error..");
		}
		
//		Message message = response2.readEntity(Message.class);
//		System.out.println(message.getAuthor());
		
		List<Message> messagelist = response2.readEntity(new GenericType<List<Message>>() {});
//		System.out.println(messagelist.toString());
		messagelist.forEach(m -> System.out.println(m));
		
	}

	public Invocation getMessageUsingId(int id) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/Advanced-JaxRs-06/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages/");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		Invocation invocation = singleMessageTarget
							.resolveTemplate("messageId", id)
							.request(MediaType.APPLICATION_JSON)
							.buildGet();
		return invocation;				
		
	}
	
	
	public Invocation getMessageUsingYear(int year) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/Advanced-JaxRs-06/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages/");
		
		Invocation invocation = messagesTarget
							.queryParam("year", year)
							.request(MediaType.APPLICATION_JSON)
							.buildGet();
		return invocation;				
		
	}

}

