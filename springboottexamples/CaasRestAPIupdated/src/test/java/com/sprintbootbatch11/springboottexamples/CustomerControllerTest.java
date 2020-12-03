/*package com.sprintbootbatch11.springboottexamples;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

public class CustomerControllerTest {

	RestTemplate restTemplate;
	ResponseEntity response;
	
	@Before
    public void setup() throws Exception {
        restTemplate = new RestTemplate();
        response = null;
    }

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089);

	@Test
	public void CustomerControllerTest() {
		
		
		
		RestTemplate restTemplate = new RestTemplate();
		 
        response = restTemplate.getForEntity("http://localhost:8089/customer", String.class);
 

	}

}
*/