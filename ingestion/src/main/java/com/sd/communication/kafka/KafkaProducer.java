package com.sd.communication.kafka;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

	private static final Logger LOGGER=Logger.getLogger(KafkaProducer.class);
	
	public void init(){
		
		LOGGER.info("Spring is initialized");
	}
}
