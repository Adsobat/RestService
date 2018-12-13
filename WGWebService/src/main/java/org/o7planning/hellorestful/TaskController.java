package org.o7planning.hellorestful;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/v1/tasks")
public class TaskController {

	/*
	 * -Aufgaben innerhalb der WG erstellen /löschen /erledigen /user neu zuweisen
	 * /Aufgaben für bestimmten User ausgeben
	 * POST: Erstellen
	 * GET: Lesen
	 * PUT: Modifizieren
	 * DELETE: Löschen
	 */

	// Gibt einen bestimmten Task zurueck
	@Path("{uuid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTasks_JSON(@PathParam("uuid") String uuid)//
	{
		long newId = Long.parseLong(uuid);
		Task dummyTask = new Task("my uuid", newId, "do shit");

		dummyTask.setDescription("Hey ich bin eine Beschreibung");

		return dummyTask.toJASON();
	}

	// gibt alle Tasks zurück
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllTasks_JSON()//
	{
		return "You selected all the Tasks";
	}

	@Path("user={User_uuid}%desc={description}")
	@POST //
	@Produces(MediaType.APPLICATION_JSON)
	public String createTasks_JSON(@PathParam("User_uuid") String User_uuid,
			@PathParam("description") String description)//
	{
		Task dummyTask = new Task();
		dummyTask.setDescription(description);
		User dummyUser = new User();
		dummyUser.setUuid(User_uuid);
		dummyTask.setAsingedUser(dummyUser);

		return dummyTask.toJASON();
	}
	
	
	@Path("{task_uuid}")
	@DELETE //
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteTasks_JSON(@PathParam("task_uuid") String task_uuid)
	{
		return "you deleted task: " + task_uuid ;
	}
	
	

	@PUT //
	@Path("{task_uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public String edditasks_JSON(Task msg, @PathParam("task_uuid") String task_uuid)
	{
		return "you deleted task: " + msg.toJASON() ;
	}
	
}
