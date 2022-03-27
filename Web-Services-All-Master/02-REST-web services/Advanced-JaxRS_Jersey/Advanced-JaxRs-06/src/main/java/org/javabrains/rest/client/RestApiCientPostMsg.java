package org.javabrains.rest.client;

import java.util.Date;

import com.javabrains.messenger.model.Message;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RestApiCientPostMsg {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/Advanced-JaxRs-06/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages/");
		
		Message postMsg= new Message(13, "Posting Message using Rest client", new Date(), "Bharat");
		
		Response postResponse = messagesTarget
								.request()
								.post(Entity.json(postMsg));
		
		if (postResponse.getStatus() !=201) {
			System.out.println("Error ..");
		}
		
		System.out.println(postResponse.getStatus());
		Message message = postResponse.readEntity(Message.class);
		System.out.println(message.getMessage());
		
		
	
	}

}
