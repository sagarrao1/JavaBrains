package com.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.javabrains.messenger.database.DatabaseClass;
import com.javabrains.messenger.model.Comment;
import com.javabrains.messenger.model.ErrorMessage;
import com.javabrains.messenger.model.Message;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class CommentService {

//	public static Map<Long, Comment> Comments = DatabaseClass.getComments();
	public static Map<Long, Message> messages = DatabaseClass.getMessages();

//	{
//		Comments.put(1L, new Comment(1, "First Comment", new Date(), "sagar"));
//		Comments.put(2L, new Comment(2, "Second Comment", new Date(), "Murali"));
//		System.out.println(" CommentService constrctor is getting called");
//	}

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();			
		return new ArrayList<>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentid) {
 		ErrorMessage errMsg = new ErrorMessage("Message Not found",404,"http://localhost:8080/messenger/error");
		 Response response = Response.status(Status.NOT_FOUND)
						.entity(errMsg)
						.build();
		
		 Message message = messages.get(messageId);	
		if (message == null) {
			throw new WebApplicationException(response);
		}
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		Comment comment = comments.get(commentid);
		
		errMsg.setErrorMsg("Comment Not found");
		if (comment == null) {
			throw new NotFoundException(response);
		}
		return comments.get(commentid);
	}

	public void removeComment(long messageId, long commentid) {
		System.out.println("removing.....");
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments.remove(commentid);
	}

	public Comment addComment(long messageId, Comment cmt) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		cmt.setId(comments.size()+1);
		comments.put(cmt.getId(), cmt);		
		return cmt;
	}

	public Comment updateComment(long messageId, Comment cmt) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (cmt.getId() <= 0) {
			return null;
		}
		comments.put(cmt.getId(), cmt);
		return cmt;
	}

}
