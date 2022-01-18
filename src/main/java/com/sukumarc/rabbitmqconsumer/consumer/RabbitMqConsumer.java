package com.sukumarc.rabbitmqconsumer.consumer;

import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sukumarc.rabbitmq.model.Employee;

@Service
public class RabbitMqConsumer {
	
	@Autowired
	private RestTemplate restTemplate;
	
	final String baseUrl = "http://mongodb-springboot-1.herokuapp.com:"+""+"/mongodb/create";

	@RabbitListener(queues = "Queue1")
	public void getMessage(Employee employee) {
		
		System.out.println(employee.getName());
		
		// create request body
		JSONObject obj = new JSONObject();
		obj.put("employeeId", employee.getEmployeeId());
		obj.put("name", employee.getName());	
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	   
	    HttpEntity<String> request = new HttpEntity<>(obj.toString(), headers);
	    
	    restTemplate.exchange(
	    		baseUrl, HttpMethod.POST, request, String.class);
	     
	    
	}	
}
