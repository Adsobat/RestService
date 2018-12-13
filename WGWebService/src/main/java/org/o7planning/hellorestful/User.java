package org.o7planning.hellorestful;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class User {
	private String uuid;
	private Long id;
	private String name;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User() {
		
	}
	public User(String uuid, long id, String name) {
		this.uuid = uuid;
		this.id = id;
		this.name = name;
	}
}
