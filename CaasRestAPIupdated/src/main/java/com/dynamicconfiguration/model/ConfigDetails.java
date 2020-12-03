package com.dynamicconfiguration.model;

public class ConfigDetails {
	
	private String appNm;
	private String env;
	private String configName;
	private String content;
	private String refreshIntervel;
	
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
	public String getAppNm() {
		return appNm;
	}
	public void setAppNm(String appNm) {
		this.appNm = appNm;
	}
	@Override
	public String toString() {
		return "ConfigDetails [appNm=" + appNm + ", env=" + env + ", configName=" + configName + "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRefreshIntervel() {
		return refreshIntervel;
	}
	public void setRefreshIntervel(String refreshIntervel) {
		this.refreshIntervel = refreshIntervel;
	}
	
}
