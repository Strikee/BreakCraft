package com.breakcraft.mod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.network.Packet;

import com.breakcraft.event.events.EditPacket;
import com.breakcraft.event.events.EditPacket.PacketType;
import com.breakcraft.objects.KeyBind;

public class Mod {

	private String modName;
	private modCategory modCategory;
	private modFunction modFunction;
	private KeyBind modKey;
	private boolean modEnabled;
	private boolean modCancelable;

	public Mod() {}
	
	public Mod(String modName, modCategory modCategory, modFunction modFunction, int modKey) {
		this.modName = modName;
		this.modCategory = modCategory;
		this.modFunction = modFunction;
		this.modKey = new KeyBind(modKey);
	}

	public String getName() {
		return this.modName;
	}

	public void setName(String modName) {
		this.modName = modName;
	}
	
	public modCategory getCategory() {
		return this.modCategory;
	}

	public void setModCategory(modCategory modCategory) {
		this.modCategory = modCategory;
	}
	
	public modFunction getFunction() {
		return this.modFunction;
	}

	public void setModFunction(modFunction modFunction) {
		this.modFunction = modFunction;
	}
	
	public KeyBind getKeyBind() {
		return this.modKey;
	}

	public void setKeyBind(KeyBind keyBind) {
		this.modKey = keyBind;
	}
	
	public boolean getEnabled() {
		return this.modEnabled;
	}

	public void setEnabled(boolean enabled) {
		this.modEnabled = enabled;
	}
	
	public boolean getCancelable() {
		return this.modCancelable;
	}

	public void setCancelable(boolean cancelable) {
		this.modCancelable = cancelable;
	}
	
	public void keyPressed() {
		if (this.getFunction() == this.modFunction.Toggle) {
			this.onToggleMod();
		} else
			if (this.getFunction() == this.modFunction.OpenGui) {
				this.onOpenGui();
			}
	}
	
	public void onOpenGui() {}
	public void onToggleMod() {}
	public void onClientTick() {}
	public void onPreMotionUpdate() {}
	public void onPostMotionUpdate() {}
	public void onInGameRender() {}
	public void onEnable() {}
	public void onDisable() {}
	public void onPacketEdit(EditPacket editPacket, Packet packetData, PacketType packetType) {}
	
	public enum modCategory {
		Player,
		Render,
		World,
		Combat,
		Auto,
		Misc
	}
	
	public enum modFunction {
		Default,
		Toggle,
		OpenGui,
		Misc
	}
}
