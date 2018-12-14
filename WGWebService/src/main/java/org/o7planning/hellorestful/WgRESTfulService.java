package org.o7planning.hellorestful;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/wgser")
public class WgRESTfulService {
     	   
	  // EXAMPLE CODE      	   
	  private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	@Path("{location}/{date}")
	   @GET
	   @Produces("application/xml")
	   public String getEcho_XML(@PathParam("location") String location,//
	            @PathParam("date") String dateStr) {
	       Date date = null;
	       if (dateStr == null || dateStr.length() == 0) {
	           date = new Date();
	       } else {
	           try {
	               date = df.parse(dateStr);
	           } catch (ParseException e) {
	               date = new Date();
	           }
	       }
	       dateStr = df.format(date); 
	    
	 
	       return "<daten>"//
	               + "<date>" + dateStr + "</date>"//
	               + "<location>" + location + "</location>"//	
	               + "<test>" + "Hallo Welt" + "</test>" //		
	               + "</daten>";
	   }
}
