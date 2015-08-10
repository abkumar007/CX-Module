package com.sd.communication.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.communication.kafka.KafkaProducer;

@Component
@Path("cx")
public class ActivityController {
	
	private static final Logger LOGGER=Logger.getLogger(ActivityController.class);
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@GET
	public Response activityGet()
	{
		LOGGER.info("Rest End point");
		return Response.status(200).entity("OK").build();
	}
	
	
}
