package com.breakcraft.tools;

import com.breakcraft.BC;

import net.minecraft.client.Minecraft;

public class Client {

	private String name;
	private String version;
	private String website;
	private String developer;
	
	public Client() {}
	
	public String getClientName() {
		return this.name;
	}
	
	public void setClientName(String name) {
		this.name = name;
		BC.debugMsg("Client Name: " + this.name);
	}
	
	public String getClientVersion() {
		return this.version;
	}
	
	public void setClientVersion(String version) {
		this.version = version;
		BC.debugMsg("Client Version: " + this.version);
	}
	
	public String getClientWebsite() {
		return this.website;
	}
	
	public void setClientWebsite(String website) {
		this.website = website;
		BC.debugMsg("Client Website: " + this.website);
	}
	
	public String getClientDeveloperName() {
		return this.developer;
	}
	
	public void setClientDeveloperName(String developer) {
		this.developer = developer;
		BC.debugMsg("Client Developer Name: " + this.developer);
	}
}
