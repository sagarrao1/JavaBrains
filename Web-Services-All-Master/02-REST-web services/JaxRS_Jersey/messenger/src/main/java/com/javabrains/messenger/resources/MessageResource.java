package com.javabrains.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.javabrains.messenger.model.Message;
import com.javabrains.messenger.resources.beans.MessageFilterBean;
import com.javabrains.messenger.service.MessageService;

import jakarta.inject.Singleton;
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
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriInfo;

@Path("/messages")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
//@Produces({MediaType.APPLICATION_JSON})
public class MessageResource {
	
	MessageService service = new MessageService();
	
//	@GET
//	public List<Message> getMessages() {		
//		List<Message> messages = service.getAllMessages();		
//		for (Message message : messages) {
//			System.out.println(message.getMessage());
//		}		
////		GenericEntity<List<Message>> list = new GenericEntity<List<Message>>(messages) {};
////	    return Response.ok(list).build();
//	    
//		return service.getAllMessages();
//	}

//	http://localhost:8080/messenger/webapi/messages?year=2001
//	http://localhost:8080/messenger/webapi/messages?start=1&size=1
	
//	Page nation and Filtering
	
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
//		return service.getAllMessages();
//	}
	
	
	@POST
	public Response addMessage(Message msg , @Context UriInfo uriInfo) throws URISyntaxException{
//		without Response
//		return service.addMessage(msg);
		
		Message addMessage = service.addMessage(msg);
		
		/* 1st way of sending status code 201 created instead of standard 200 ok*/
//		return Response.status(Status.CREATED)
//				.entity(addMessage)
//				.build();
//		
//		/* 2nd way it will set status created and URI*/
//		return Response.created(new URI("/messenger/webapi/messages/"+ addMessage.getId()))
//				.entity(addMessage)
//				.build();	
//		
//		/* 3nd way better way than 2nd*/		
		String newId = String.valueOf(addMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(addMessage)
				.build();
	}
	
	@GET
	@Path("/{messageid}")
	public Message getMessage(@PathParam("messageid") long messageId, @Context UriInfo uriInfo) {
		Message message = service.getMessage(messageId);
		/* 1st way */
//		message.addLink(uriInfo.getAbsolutePath().toString(), "self");
		
		/* 2nd way */
		message.addLink(getUriForSelf(message, uriInfo), "self");
		message.addLink(getUriForprofile(message, uriInfo), "profile");
		message.addLink(getUriForComments(message, uriInfo), "comments");
		return message;
	}

	private String getUriForComments(Message message, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder()    // http://localhost:8080/messenger/webapi
					.path(MessageResource.class)  //messages
				   .path(MessageResource.class, "getCommentResource")  //comments
				   .resolveTemplate("messageid", message.getId())     // to replace /{messageid}/comments we need to use resolveTemplate which takes 2 parameter one is arument another is value
				   .build()
				   .toString();
			return uri;
	}

	private String getUriForSelf(Message message, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder()    // http://localhost:8080/messenger/webapi
			   .path(MessageResource.class)  //messages
			   .path(Long.toString(message.getId()))
			   .build()
			   .toString();
		return uri;
	}
		
	private String getUriForprofile(Message message, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder()    // http://localhost:8080/messenger/webapi
				   .path(ProfileResource.class)  //profiles
				   .path(message.getAuthor())    // get author
				   .build()
				   .toString();
			return uri;
	}
	
	@PUT
	@Path("/{messageid}")
	public Message updateMessage(@PathParam("messageid") long id, Message msg) {
		msg.setId(id);
		return service.updateMessage(msg);
	}

	@DELETE
	@Path("/{messageid}")
	public Message removeMessage(@PathParam("messageid") long msgId) {
		return service.removeMessage(msgId);
	}
	
	/* important we should not add @GET here. it won't work if we add */
	
	@Path("/{messageid}/comments")
	@Singleton
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
	
//	to differentiate json and xml method . depends client calls in accept as text/xml or application/json from postman
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Message> getJSONMessages() {		
//		System.out.println("JSON method is called");
//		return service.getAllMessages();
//	}
//	
//	@GET
//	@Produces(MediaType.TEXT_XML)
//	public List<Message> getXMLMessages() {
//		System.out.println("Xml method is called");
//		return service.getAllMessages();
//	}

}
