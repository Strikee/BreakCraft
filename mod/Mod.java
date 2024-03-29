package com.breakcraft.mod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.Packet;

import com.breakcraft.BC;
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

	public Mod(String modName, modCategory modCategory, modFunction modFunction, int modKey, boolean modEnabled) {
		this.modName = modName;
		this.modCategory = modCategory;
		this.modFunction = modFunction;
		this.modKey = new KeyBind(modKey);
		this.modEnabled = modEnabled;
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
			this.setEnabled(!this.getEnabled()); // Switch Enabled State
			if (this.getEnabled()) {
				this.onEnable(); // Run when Enabled
			} else {
				this.onDisable(); // Run when Disabled
			}
		} else
			if (this.getFunction() == this.modFunction.OpenGui) {
				this.onOpenGui();
			} else {
				BC.getChatTools().addToConsole("Error with toggle");
			}
				
	}

	public void onOpenGui() {}
	public void onClientTick() {}
	public void onPreMotionUpdate() {}
	public void onPostMotionUpdate() {}
	public void onInGameRender() {}
	public void onEntityRender() {}
	public void onEnable() {}
	public void onDisable() {}
	public void onPacketEdit(EditPacket editPacket) {}
	public void onScreenUpdate(GuiScreen eventScreen, List eventButtons, List eventLabels) {}

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
