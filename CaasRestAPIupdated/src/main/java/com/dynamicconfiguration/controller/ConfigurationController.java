package com.dynamicconfiguration.controller;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dynamicconfiguration.dao.ConfigurationRepo;
import com.dynamicconfiguration.entity.ConfigurationEntity;
import com.dynamicconfiguration.excep.ConfigurationNotFound;
import com.dynamicconfiguration.model.ConfigDetails;



@RestController
public class ConfigurationController {
	@Autowired
	ConfigurationRepo configurationRepo;
 	
	List<ConfigurationEntity> configurationList= new ArrayList<ConfigurationEntity>();

	@GetMapping("/configuration/{appnm}")
	public List<ConfigurationEntity> getConfigurationByAppNm(@PathVariable String appNm) throws Exception{

		System.out.println("test");
		System.out.println("-----"+configurationRepo.findByAppNm(appNm).get(0).getUpdatedTimeStamp());
		return configurationRepo.findByAppNm(appNm);
		
	}
	
	@GetMapping("/configuration")
	public List<ConfigurationEntity> configurations(){
		return configurationRepo.findAll();
	}
	
	@PostMapping("/configuration/add")
	public String addConfiguration(@RequestBody ConfigurationEntity configuration) {

		if (configuration == null)
			return "Invalid input";
		ArrayList<ConfigurationEntity> configListByName = configurationRepo.findByAppNm(configuration.getAppNm());
		for (ConfigurationEntity configuration1 : configListByName) {
			if (configuration1.getConfigName().equalsIgnoreCase(configuration.getConfigName())) {
				return "Already exists";
			}

		}
		configuration.setCreatedTimeStamp(new Timestamp(System.currentTimeMillis()));
		configuration.setUpdatedTimeStamp(new Timestamp(System.currentTimeMillis()));
		configurationRepo.save(configuration);
		return "Added successfully";
	}
	
	@PostMapping("/configuration/addall")
	public ArrayList<ConfigurationEntity> addAll(@RequestBody ArrayList<ConfigurationEntity> configList){
		for (ConfigurationEntity configuration : configList) {
				configuration.setCreatedTimeStamp(new Timestamp(System.currentTimeMillis()));
				configuration.setUpdatedTimeStamp(new Timestamp(System.currentTimeMillis()));
			}
		ArrayList<ConfigurationEntity> result = (ArrayList<ConfigurationEntity>) configurationRepo.saveAll(configList);
		System.out.println(result.get(0).getUpdatedTimeStamp());
		return result;
	}
	
	@PostMapping("/configuration")
	public ConfigurationEntity getConfigurationByConfigName(@RequestParam String configName, @RequestBody ConfigDetails configDetails) throws Exception{
		ConfigurationEntity configurationObj=null;
		ArrayList<ConfigurationEntity> configListByName = configurationRepo.findByAppNm(configDetails.getAppNm());
		for (ConfigurationEntity configuration : configListByName) {
			if (configuration.getConfigName().equalsIgnoreCase(configName) ) {
				configurationObj= configuration;
			}
		}
		if(configurationObj==null){
			//Logger statement
			System.err.println("No configuration present with that name:");
			throw new ConfigurationNotFound("No configuration present with the name");
			
		}
		System.out.println(configurationObj.getUpdatedTimeStamp());
		return configurationObj;
	}
	
	@PostMapping("/configuration/contentupdate")
	public boolean update(@RequestBody ConfigDetails configDetails) throws Exception{
		ConfigurationEntity configurationByConfigName = getConfigurationByConfigName(configDetails.getConfigName(),configDetails);
		configurationByConfigName.setConfigContent(configDetails.getContent());
		configurationByConfigName.setUpdatedTimeStamp(new Timestamp(System.currentTimeMillis()));
		if(configDetails.getRefreshIntervel()!=null){
			configurationByConfigName.setRefreshIntervel(configDetails.getRefreshIntervel());
		}
		ConfigurationEntity save = configurationRepo.save(configurationByConfigName);
		if(save!=null){
			return true;
		}
		return false;
		
	}
	
	@DeleteMapping("/configuration/deleteall")
	public boolean deleteall(){
		configurationRepo.deleteAll();
		return true;
	}
	
	@GetMapping("/servicing/dev/configuration")
	public ConfigurationEntity servicing(@RequestParam String configName, @RequestParam String appName, @RequestParam boolean startup){
		ConfigurationEntity configurationObj = null;
		ArrayList<ConfigurationEntity> configListByName = configurationRepo.findByAppNm(appName);
		for (ConfigurationEntity configuration : configListByName) {
			if (configuration.getConfigName().equalsIgnoreCase(configName) ) {
				configurationObj = configuration;
			}
		}
		
		return configurationObj;
	}
}
