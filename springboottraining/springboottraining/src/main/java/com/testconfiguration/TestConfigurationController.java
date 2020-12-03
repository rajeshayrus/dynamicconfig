package com.testconfiguration;

import org.w3c.dom.Document;

import com.tbank.dc.dynamicconfig.Configuration;
import com.tbank.dc.dynamicconfig.XmlConfiguration;
import com.typesafe.config.Config;

public class TestConfigurationController {

	public static void main(String[] args) {

		//Configuration con = new Configuration("user.json", false);
		XmlConfiguration con = new XmlConfiguration("account.xml", true);
		Document config = con.getConfig();
		System.out.println(config);
	}

}
