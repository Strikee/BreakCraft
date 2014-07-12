package com.breakcraft.mod.mods.world;

import org.lwjgl.input.Keyboard;

import com.breakcraft.BC;
import com.breakcraft.event.events.EditPacket;
import com.breakcraft.mod.Mod;
import com.breakcraft.mod.Mod.modCategory;
import com.breakcraft.mod.Mod.modFunction;

public class FullBright extends Mod {
	
	private float originalGammaSettings;

	public FullBright() {}
	
	// This is where you add some key info for the Mod (Name, Category, Function, KeyBind Key, Default Enabled State)
	private static final Mod mod = new FullBright("FullBright", modCategory.World, modFunction.Toggle, Keyboard.KEY_F, false);

	public FullBright(String modName, modCategory modCategory, modFunction modFunction, int modKey, boolean modEnabled) {
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
	public void onEnable() {
		this.originalGammaSettings = BC.getMc().gameSettings.gammaSetting;
		BC.getMc().gameSettings.gammaSetting = 1000;
	}

	@Override
	public void onDisable() {
		BC.getMc().gameSettings.gammaSetting = this.originalGammaSettings;
	}
}
