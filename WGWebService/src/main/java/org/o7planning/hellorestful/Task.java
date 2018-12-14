package org.o7planning.hellorestful;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)	
public class Task {
	@JsonInclude(Include.NON_EMPTY)	
	private String uuid;
	@JsonInclude(Include.NON_NULL)	
	private Long id;
	@JsonInclude(Include.NON_NULL)
	private User asingedUser;
	@JsonInclude(Include.NON_EMPTY)	
	private String description;
	
	public void createDefault() {
		uuid = "uu1";
		id = new Long(1);
		description = "default";
	}
	// checks if the values in inTask are filled and if so it replaces them with his own
	public void insertPartialTask(Task inTask) {
		if(inTask.uuid != null) 		{this.uuid = inTask.uuid;}
		if(inTask.id != null) 			{this.id = inTask.id;}
		if(inTask.asingedUser != null) 	{this.asingedUser = inTask.asingedUser;}
		if(inTask.description != null)	{this.description = inTask.description;}
		
	}
	public Task() {		
	}
	public Task(String uuid, Long id, String description) {	
		this.uuid = uuid;
		this.id = id;
		this.description = description;
	}
	@Override
	public String toString() {
		return this.toJASON();
	}
	
	public String toJASON() {
		ObjectMapper mapper = new ObjectMapper();
		String json = "ERROR";
		try {
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAsingedUser() {
		return asingedUser;
	}

	public void setAsingedUser(User asingedUser) {
		this.asingedUser = asingedUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
