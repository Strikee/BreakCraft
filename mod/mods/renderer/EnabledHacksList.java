package com.breakcraft.mod.mods.renderer;

import org.lwjgl.input.Keyboard;

import com.breakcraft.BC;
import com.breakcraft.mod.Mod;
import com.breakcraft.mod.Mod.modCategory;
import com.breakcraft.mod.Mod.modFunction;
import com.breakcraft.mod.ModList;
import com.breakcraft.tools.Window;

public class EnabledHacksList extends Mod {

	public EnabledHacksList() {}

	// This is where the mod is defined by name, category, function, and the default keybind
	private static final Mod mod = new EnabledHacksList("Enabled Hacks List", modCategory.Render, modFunction.Toggle, Keyboard.KEY_O, true);

	public EnabledHacksList(String modName, modCategory modCategory, modFunction modFunction, int modKey, boolean modEnabled) {
		super(modName, modCategory, modFunction, modKey, modEnabled);
	}

	/*
	 * This part never needs modification unless we want to change the debug output
	 */
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
	public void onInGameRender() {
		String title = BC.getInfo().getClientName() + " v." + BC.getInfo().getClientVersion();
		int i = 0, w = BC.getMc().fontRenderer.getStringWidth(title), l = 0, size = 0, count = 0;
		for (Mod m : BC.getModList().getMods()) {
			if (m.getEnabled()) {
				size++;
				String s = m.getName() + "  [" + m.getKeyBind().getKeyName() + "]";
				s = s.replace("[NONE]", "");
				s = s.replace("NUMPAD", "");
				s = s.replace("CONTROL", "Ctrl");
				if (w < BC.getMc().fontRenderer.getStringWidth(s)) w = BC.getMc().fontRenderer.getStringWidth(s);
			}
		}
		BC.getWindow().drawRect(0, 0, w + 4, (size * 12) + 13, 0x40FFFFFF, 0x80000000);
		BC.getWindow().drawString(BC.getMc().fontRenderer, title, 2, 2, 0xFF3399FF);
		for (Mod m : BC.getModList().getMods()) {
			if (m.getEnabled()) {
				String s = m.getName();
				String s2 = "[" + m.getKeyBind().getKeyName() + "]";
				s2 = s2.replace("[NONE]", "");
				s2 = s2.replace("NUMPAD", "");
				s2 = s2.replace("CONTROL", "Ctrl");
				BC.getWindow().drawString(BC.getMc().fontRenderer, s, 2, (count * 12) + 14, 0xFFFFFFFF);
				BC.getWindow().drawString(BC.getMc().fontRenderer, s2, w - BC.getMc().fontRenderer.getStringWidth(s2), (count * 12) + 14, 0xFF3399FF);
				BC.getWindow().drawRect(0, (count * 12) + 11, w + 3, (count * 12) + 12, 0x40FFFFFF, 0x80000000);
				count++;
			}
		}
	}
}
