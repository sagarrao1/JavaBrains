package com.javabrains.messenger.resources;

import java.util.List;
import com.javabrains.messenger.model.Comment;
import com.javabrains.messenger.service.CommentService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class CommentResource {

	CommentService cmtService = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageid") long messageid) {
		return cmtService.getAllComments(messageid);
	}

	@POST
	public Comment addcomment(@PathParam("messageid") long messageid, Comment cmt) {
		return cmtService.addComment(messageid, cmt);
	}

	@GET
	@Path("/{commentid}")
	public Comment getcomment(@PathParam("messageid") long messageid, @PathParam("commentid") long commentId) {
		System.out.println("commentId :"+commentId);
		System.out.println("messageid :"+messageid);
		return cmtService.getComment(messageid,commentId);
//		return " value : "+commentId;
	}

	@PUT
	@Path("/{commentid}")
	public Comment updatecomment(@PathParam("messageid") long messageid, @PathParam("commentid") long commentId, Comment cmt) {
		cmt.setId(commentId);
		return cmtService.updateComment(messageid,cmt);
	}

	@DELETE
	@Path("/{commentid}")
	public void removecomment(@PathParam("messageid") long messageid, @PathParam("commentid") long commentId) {
		cmtService.removeComment(messageid,commentId);
	}

}
