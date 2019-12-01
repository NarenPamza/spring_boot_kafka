package com.naren.spring_boot_kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private KafkaTemplate<String, String> template;
	
	String TOPIC = "test";

	@GetMapping("/user/{name}")
	public ResponseEntity<String> getUser(@PathVariable("name") final String name) {
		String message = "Yes we are in the entity " + name;
		
		template.send(TOPIC,message);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
