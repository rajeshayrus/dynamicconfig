package com.testconfiguration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.tbank.dc.dynamicconfig.Configuration;
import com.tbank.dc.dynamicconfig.JsonStringConfiguration;
import com.tbank.dc.dynamicconfig.XmlConfiguration;
import com.typesafe.config.Config;

@RestController
public class RestAPIController {

	@GetMapping("/loadconfig/properties")
	public Config loadproperties(){
		
		Configuration con = new Configuration("offer.properties", true);
		return con.getConfig();
		
	}
	
	@GetMapping("/loadconfig/json")
	public JsonNode loadjson(){
		
		JsonStringConfiguration con = new JsonStringConfiguration("user.conf", true);
		return con.getConfig();
	}
	
	@GetMapping("/loadconfig/xml")
	public Document loadxml(){
		
		XmlConfiguration con = new XmlConfiguration("account.xml", true);
		return con.getConfig();
	}
}
