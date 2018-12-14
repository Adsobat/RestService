package org.o7planning.hellorestful;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;


@Path("/json-payload/movies")
public class JsonPayloadResource {
	/*
	 * -Aufgaben innerhalb der WG erstellen /löschen /erledigen /user neu zuweisen
	 * /Aufgaben für bestimmten User ausgeben
	 * POST: Erstellen
	 * GET: Lesen
	 * PUT: Modifizieren
	 * DELETE: Löschen
	 * 
	 */
	@Path("{uuid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String giveMovie_JSON(@PathParam("uuid") String uuid)//
	{
		return "get works with uuid: " + uuid;
	}

	@POST
	//@Path()
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String takeAndGiveMovie_JSON(final Task task) {
		task.setDescription("I changed the descrition");		
		return task.toString();
	}
	@DELETE
	//@Path()
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteMovie_JSON(final Task task) {
		task.setDescription("I changed the descrition");		
		return "delete worked" + task.getUuid();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String changeMovie_JSON(final Task task) {
		Task dummyTask = new Task();
		
		dummyTask.createDefault();
		dummyTask.setAsingedUser(new User().createDefault());
		dummyTask.insertPartialTask(task);
//		if(!task.getDescription().isEmpty())
//		dummyTask.setDescription(task.getDescription());
//		if(task.getId() != null)
//		dummyTask.setId(task.getId());
//		if (!task.getUuid().isEmpty())
//		dummyTask.setUuid(task.getUuid());
		
		
		return dummyTask.toJASON();
		
	}
	
}
