package com.dynamicconfiguration.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dynamicconfiguration.entity.ConfigurationEntity;

@Repository
public interface ConfigurationRepo extends JpaRepository<ConfigurationEntity, Long> {
	
	public ArrayList<ConfigurationEntity> findByAppNm(String appNm);
}
