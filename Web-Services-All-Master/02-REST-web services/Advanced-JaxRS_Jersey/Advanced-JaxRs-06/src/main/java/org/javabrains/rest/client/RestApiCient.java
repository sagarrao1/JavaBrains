package org.javabrains.rest.client;

import com.javabrains.messenger.model.Message;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RestApiCient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		
//		1nd way
//		WebTarget target = client.target("http://localhost:8080/Advanced-JaxRs-06/webapi/messages/2");
//		Builder request = target.request();
//		Response response = request.get();
//		Message message = response.readEntity(Message.class);
//		System.out.println(message.getMessage());

//		2nd way
//		Response response = client.target("http://localhost:8080/Advanced-JaxRs-06/webapi/messages/2").request().get();		
//		Message message = response.readEntity(Message.class);
//		System.out.println(message.getMessage());
		
		
//		3rd way
//		Message message = client.target("http://localhost:8080/Advanced-JaxRs-06/webapi/messages/2")
//				                  .request(MediaType.APPLICATION_JSON)
//				                  .get(Message.class);		
//		System.out.println(message.getMessage());
		
//		4th way
//		String message = client.target("http://localhost:8080/Advanced-JaxRs-06/webapi/messages/2")
//				                  .request(MediaType.APPLICATION_JSON)
//				                  .get(String.class);		
//		System.out.println(message);
		
		
//		5th way
		
		WebTarget baseTarget = client.target("http://localhost:8080/Advanced-JaxRs-06/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages/");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		Message message = singleMessageTarget
				.resolveTemplate("messageId", "1")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);		
		System.out.println(message.getMessage());
		
		Message message2 = singleMessageTarget
				.resolveTemplate("messageId", "2")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);		
		System.out.println(message2.getMessage());
		
	}

}
