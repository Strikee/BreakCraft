package com.breakcraft.tools;

import com.breakcraft.BC;

import net.minecraft.client.Minecraft;

public class Info {

	private String clientName;
	private String clientVersion;
	private String clientWebsite;
	private String clientDeveloperName;
	
	public Info() {}
	
	public String getClientName() {
		return this.clientName;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
		BC.debugMsg("Client Name: " + this.clientName);
	}
	
	public String getClientVersion() {
		return this.clientVersion;
	}
	
	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
		BC.debugMsg("Client Version: " + this.clientVersion);
	}
	
	public String getClientWebsite() {
		return this.clientWebsite;
	}
	
	public void setClientWebsite(String clientWebsite) {
		this.clientWebsite = clientWebsite;
		BC.debugMsg("Client Website: " + this.clientWebsite);
	}
	
	public String getClientDeveloperName() {
		return this.clientDeveloperName;
	}
	
	public void setClientDeveloperName(String clientDeveloperName) {
		this.clientDeveloperName = clientDeveloperName;
		BC.debugMsg("Client Developer Name: " + this.clientDeveloperName);
	}
}
