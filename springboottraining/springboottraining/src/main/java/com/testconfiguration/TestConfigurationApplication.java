package com.testconfiguration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tbank.dc.dynamicconfig.Configuration;
import com.tbank.dc.dynamicconfig.JsonStringConfiguration;
import com.tbank.dc.dynamicconfig.ReloadCallback;
import com.tbank.dc.dynamicconfig.XmlConfiguration;

@SpringBootApplication
public class TestConfigurationApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TestConfigurationApplication.class, args);
	}

	public void run(String... args) throws Exception{
		Configuration propertiesConfiguration = new Configuration("offer.properties",i->System.out.println("Hi"), true);
		JsonStringConfiguration jsonConfiguration = new JsonStringConfiguration("card.json", true);
		XmlConfiguration xmlConfiguration = new XmlConfiguration("account.xml", true);
		Configuration configConfiguration = new Configuration("db.conf", true);
		
	}
}

