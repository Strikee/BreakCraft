package com.breakcraft.mod.mods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S14PacketEntity;

import com.breakcraft.BC;
import com.breakcraft.event.events.EditPacket.type;
import com.breakcraft.mod.Mod;
import com.breakcraft.mod.ModList;
import com.breakcraft.window.utils.Utils;

public class FullBright extends Mod {

	private float originalGammaSetting;

	public FullBright() {}

	private static final Mod mod = new FullBright("FullBright", modCategory.World, modFunction.Toggle, 88);

	public FullBright(String modName, modCategory modCategory, modFunction modFunction, int modKey) {
		super(modName, modCategory, modFunction, modKey);
	}

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
	public void onToggleMod() {
		this.setEnabled(!this.getEnabled());
		
		if (this.getEnabled()) {
			this.onEnable();
		} else {
			this.onDisable();
		}
	}

	@Override
	public void onEnable() {
		this.originalGammaSetting = BC.getMc().gameSettings.gammaSetting;
		BC.getMc().gameSettings.gammaSetting = 1000;
	}

	@Override
	public void onDisable() {
		BC.getMc().gameSettings.gammaSetting = this.originalGammaSetting;
	}

	@Override
	public void onInGameRender() {
		Utils u = BC.getUtils();
		u.drawRect(0, 0, BC.getMc().fontRenderer.getStringWidth(this.getName()) + 4, 12, 0x80FFFFFF, 0x80000000);
		u.drawString(BC.getMc().fontRenderer, this.getName(), 2, 2, 0xFFFFFFFF);
	}
}
