package com.dynamicconfiguration.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
//import org.springframework.data.annotation.Id;





@Entity
public class ConfigurationEntity implements Serializable {
	
	 private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=3)
	@Column(name="APP_NM")
	private String appNm;
	@Column(name="ENV")
	private String env;
	@Column(name="CONFIGNAME")
	private String configName;
	@Column(name="CONTENT")
	private String configContent;
	@Column(name = "ACTIVE")
	private boolean active;
	@Column(name = "CRTD_TS")
	private Timestamp createdTimeStamp;
	@Column(name = "UPDT_BY")
	private String updatedBy;
	@Column(name = "REFRESH_INTERVEL")
	private String refreshIntervel;
	@Column(name ="REFRESH_ACTIVE")
	private boolean refreshActive;
	@Column(name = "UPDT_TS")
	private Timestamp updatedTimeStamp;
	public ConfigurationEntity(){
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAppNm() {
		return appNm;
	}

	public void setAppNm(String appNm) {
		this.appNm = appNm;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}
	
	public String getConfigContent() {
		return configContent;
	}

	public void setConfigContent(String configContent) {
		this.configContent = configContent;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getRefreshIntervel() {
		return refreshIntervel;
	}

	public void setRefreshIntervel(String refreshIntervel) {
		this.refreshIntervel = refreshIntervel;
	}

	public boolean isRefreshActive() {
		return refreshActive;
	}

	public void setRefreshActive(boolean refreshActive) {
		this.refreshActive = refreshActive;
	}

	public Timestamp getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(Timestamp updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Configuration [id=" + id + ", appNm=" + appNm + ", env=" + env + ", configNm=" + configName
				+ ", configContent=" + configContent + "]";
	}
	
	

}
