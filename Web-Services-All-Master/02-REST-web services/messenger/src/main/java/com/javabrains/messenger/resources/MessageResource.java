package com.javabrains.messenger.resources;

import java.util.List;

import com.javabrains.messenger.model.Message;
import com.javabrains.messenger.resources.beans.MessageFilterBean;
import com.javabrains.messenger.service.MessageService;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/messages")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class MessageResource {
	
	MessageService service = new MessageService();
	
//	@GET
//	public List<Message> getMessage() {		
//		List<Message> messages = service.getAllMessages();		
//		for (Message message : messages) {
//			System.out.println(message.getMessage());
//		}		
////		GenericEntity<List<Message>> list = new GenericEntity<List<Message>>(messages) {};
////	    return Response.ok(list).build();
//	    
//		return service.getAllMessages();
//	}

	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		if (year>0) {
			return service.getAllmessagesForYear(year);
		}
		if (start>=0 && size>0) {
			return service.getAllmessagesPaginated(start, size);
		}
		
		return service.getAllMessages();
	}
	
   /* This is same as above if you have more params, we can use beanparam by creating new class	*/	
//	@GET
//	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
//		if (filterBean.getYear()>0) {
//			return service.getAllmessagesForYear(filterBean.getYear());
//		}
//		if (filterBean.getStart()>=0 && filterBean.getSize()>0) {
//			return service.getAllmessagesPaginated(filterBean.getStart(), filterBean.getSize());
//		}
//		
//		return service.getAllMessages();
//	}
	
	
	@POST
	public Message addMessage(Message msg) {		
		return service.addMessage(msg);
	}
	
	@GET
	@Path("/{messageid}")
	public Message getMessage(@PathParam("messageid") long messageId) {
		return service.getMessage(messageId);
//		return " value : "+messageId;
	}
		
	
	@PUT
	@Path("/{messageid}")
	public Message updateMessage(@PathParam("messageid") long id, Message msg) {
		msg.setId(id);
		return service.updateMessage(msg);
	}

	@DELETE
	@Path("/{messageid}")
	public void removeMessage(@PathParam("messageid") long id) {
		service.removeMessage(id);
	}

}
