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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/v1/tasks")
public class TaskController {

	/*
	 * -Aufgaben innerhalb der WG erstellen /löschen /erledigen /user neu zuweisen
	 * /Aufgaben für bestimmten User ausgeben
	 */

	// Gibt den Task an der stelle id zurueck
	@Path("{id}")
	@GET
//	   @Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTasks_JSON(@PathParam("id") String id)//
	{
		long newId = Long.parseLong(id);
		Task dummyTask = new Task("my uuid", newId, "do shit");
		
		dummyTask.setDescription("Hey ich bin eine Beschreibung");
		ObjectMapper mapper = new ObjectMapper();
		String json = "ERROR";
		try {
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dummyTask);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}
	// Gibt den Task an der stelle id zurueck

	// gibt alle Tasks zurück
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllTasks_JSON()//
	{
		return "You selected all the Tasks";
	}
	
	
		@Path("{id}")
		@POST//		  
		@Produces(MediaType.APPLICATION_JSON)
		public String createTasks_JSON(@PathParam("id") String id)//
		{
			return" User wurde angelegt" + id;
		}
}
