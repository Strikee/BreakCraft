package com.breakcraft.mod.mods;

import org.lwjgl.input.Keyboard;

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
import com.breakcraft.window.windows.TestGui;

public class TestMod extends Mod {

	private boolean originalOnGround;

	public TestMod() {}

	private static final Mod mod = new TestMod("Test Mod", modCategory.Misc, modFunction.Misc, Keyboard.KEY_F12);

	public TestMod(String modName, modCategory modCategory, modFunction modFunction, int modKey) {
		super(modName, modCategory, modFunction, modKey);
	}

	public void load() {
//		BC.getModList().addMod(mod);
//		BC.debugMsg("--------------------------------------");
//		BC.debugMsg("New Mod Added! - Total Mods: " + BC.getModList().getMods().size());
//		BC.debugMsg("--------------------------------------");
//		BC.debugMsg("Mod Name: " + mod.getName());
//		BC.debugMsg("Mod Category: " + mod.getCategory());
//		BC.debugMsg("Mod Function: " + mod.getFunction());
//		BC.debugMsg("Mod KeyBind: " + mod.getKeyBind().getKeyName());
//		BC.debugMsg("--------------------------------------");
	}

	@Override
	public void onClientTick() {
		/*
		 * Like ticks?
		 */
		BC.getChatTools().addToConsole("Tick");
	}

	@Override
	public void onPreMotionUpdate() {
		/*
		 * NoFall, why not?
		 */
		this.originalOnGround = BC.getMc().thePlayer.onGround;
		BC.getMc().thePlayer.onGround = true;		
	}

	@Override
	public void onPostMotionUpdate() {
		/*
		 * NoFall is done!
		 */
		BC.getMc().thePlayer.onGround = this.originalOnGround;
	}

	@Override
	public void onToggleMod() {
		this.setEnabled(!this.getEnabled()); // Switch Enabled State
		if (this.getEnabled()) {
			this.onEnable(); // Run when Enabled
		} else {
			this.onDisable(); // Run when Disabled
		}
	}

	@Override
	public void onEnable() {
		BC.getChatTools().addToChat(this.getName() + " Enabled");
	}

	@Override
	public void onDisable() {
		BC.getChatTools().addToChat(this.getName() + " Disabled");
	}

	@Override
	public void onInGameRender() {
		Utils u = BC.getUtils();
		u.drawRect(0, 0, BC.getMc().fontRenderer.getStringWidth(this.getName()) + 4, 12, 0x80FFFFFF, 0x80000000);
		u.drawString(BC.getMc().fontRenderer, this.getName(), 2, 2, 0xFFFFFFFF);
	}

	@Override
	public void onOpenGui() {
		BC.getMc().displayGuiScreen(new TestGui());
	}

	@Override
	public void onPacketEdit(Packet packetData, type packetType) {
		Packet p = packetData;
		
		if (packetType == type.get) {
			
			if (p instanceof S12PacketEntityVelocity) {
				S12PacketEntityVelocity ev = (S12PacketEntityVelocity) p;
				Entity e = BC.getMc().theWorld.getEntityByID(ev.func_149412_c());
				
				if (e instanceof EntityFishHook) {
					if (ev.func_149409_f() == 0 && ev.func_149411_d() == 0 && ev.func_149410_e() != 0) {
						BC.getChatTools().addToChat("Pull the Fish in, hurry!");
					}
				}
			}
		} else
			
			if (packetType == type.send) {
				
			}
	}
}
