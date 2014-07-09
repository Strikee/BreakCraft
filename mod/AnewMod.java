package com.breakcraft.mod;

import org.lwjgl.input.Keyboard;

import com.breakcraft.BC;
import com.breakcraft.event.events.EditPacket;

public class AnewMod extends Mod {
	
	public AnewMod() {}
	
	// This is where you add some key info for the Mod (Name, Category, Function, KeyBind Key, Default Enabled State)
	private static final Mod mod = new AnewMod("AnewMod", modCategory.Misc, modFunction.Misc, Keyboard.CHAR_NONE, false);

	public AnewMod(String modName, modCategory modCategory, modFunction modFunction, int modKey, boolean modEnabled) {
		super(modName, modCategory, modFunction, modKey, modEnabled);
	}

	// This part never needs modification unless we want to change the debug output
	public void load() {
		if (this instanceof AnewMod) return; // Remove this after a mod is ready to use
		BC.getModList().addMod(mod);
		BC.debugMsg("--------------------------------------");
		BC.debugMsg("New Mod Added! - Total Mods: " + BC.getModList().getMods().size());
		BC.debugMsg("--------------------------------------");
		BC.debugMsg("Mod Name: " + mod.getName());
		BC.debugMsg("Mod Category: " + mod.getCategory());
		BC.debugMsg("Mod Function: " + mod.getFunction());
		BC.debugMsg("Mod KeyBind: " + mod.getKeyBind().getKeyName());
		BC.debugMsg("--------------------------------------");
	}

	@Override
	public void onOpenGui() {}

	@Override
	public void onClientTick() {}

	@Override
	public void onPreMotionUpdate() {}

	@Override
	public void onPostMotionUpdate() {}

	@Override
	public void onInGameRender() {}

	@Override
	public void onEntityRender() {}

	@Override
	public void onEnable() {}

	@Override
	public void onDisable() {}

	@Override
	public void onPacketEdit(EditPacket editPacket) {}
	
}
