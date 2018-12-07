package org.o7planning.hellorestful;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Task {
	private String uuid;
	private long id;
	@JsonInclude(Include.NON_NULL)
	private User asingedUser;	
	private String description;
	
	public Task() {		
	}
	public Task(String uuid, long id, String description) {	
		this.uuid = uuid;
		this.id = id;
		this.description = description;
	}
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
