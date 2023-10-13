package com.deliveryboy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryboy.KafkaService;

@RestController
public class KafkaController {

	@Autowired
	KafkaService service;
	
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation(){
		for(int i=0;i<2000000;i++) {
		service.updateLocation("( "+Math.round(Math.random()*100)+","+Math.round(Math.random()*100)+" )");
		}
		return new ResponseEntity<>(Map.of("Message","Updated Location"),HttpStatus.OK);
	}
}
