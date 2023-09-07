package com.CSC340f23.APIprototype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPrototypeApplication.class, args);
                randomJoke();
                System.exit(0);
	}
    public static void randomJoke() {
        try {
            String url = "https://v2.jokeapi.dev/joke/Programming?type=twopart";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonJoke = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonJoke);

            //gets joke setup
            String jokeSetUp = root.findValue("setup").asText();
            //gets joke delivery
            String jokeDelivery = root.findValue("delivery").asText();
            //print vals
            System.out.println("SetUp: " + jokeSetUp);
            System.out.println("Delivery: " + jokeDelivery);
            

        } catch (JsonProcessingException ex) {
            System.out.println("error in randomJoke");
        }
    }

}

