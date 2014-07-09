package com.breakcraft.mod.mods;

import org.lwjgl.input.Keyboard;

import com.breakcraft.BC;
import com.breakcraft.event.events.EditPacket;
import com.breakcraft.mod.Mod;
import com.breakcraft.mod.Mod.modCategory;
import com.breakcraft.mod.Mod.modFunction;

public class NoFall extends Mod {
	
	private boolean originalOnGround;

	public NoFall() {}
	
	// This is where you add some key info for the Mod (Name, Category, Function, KeyBind Key, Default Enabled State)
	private static final Mod mod = new NoFall("NoFall", modCategory.Player, modFunction.Toggle, Keyboard.KEY_N, false);

	public NoFall(String modName, modCategory modCategory, modFunction modFunction, int modKey, boolean modEnabled) {
		super(modName, modCategory, modFunction, modKey, modEnabled);
	}

	// This part never needs modification unless we want to change the debug output
	public void load() {
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
	public void onPreMotionUpdate() {
		this.originalOnGround = BC.getMc().thePlayer.onGround;
		BC.getMc().thePlayer.onGround = true;		
	}

	@Override
	public void onPostMotionUpdate() {
		BC.getMc().thePlayer.onGround = this.originalOnGround;
	}
	
}
