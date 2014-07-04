package com.breakcraft.mod.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S14PacketEntity;

import com.breakcraft.BC;
import com.breakcraft.event.events.EditPacket;
import com.breakcraft.event.events.EditPacket.PacketType;
import com.breakcraft.mod.Mod;
import com.breakcraft.mod.ModList;
import com.breakcraft.tools.Utils;
import com.breakcraft.window.windows.TestGui;

public class TestMod extends Mod {

	private boolean originalOnGround;
	private float originalGammaSettings;

	public TestMod() {}
	
	// This is where the mod is defined by name, category, function, and the default keybind
	private static final Mod mod = new TestMod("Test Mod", modCategory.Misc, modFunction.Misc, Keyboard.KEY_F12);

	public TestMod(String modName, modCategory modCategory, modFunction modFunction, int modKey) {
		super(modName, modCategory, modFunction, modKey);
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
		/*
		 * Basic FullBright is ok?
		 */
		this.originalGammaSettings = BC.getMc().gameSettings.gammaSetting;
		BC.getMc().gameSettings.gammaSetting = 1000;
		BC.getChatTools().addToChat(this.getName() + " Enabled");
	}

	@Override
	public void onDisable() {
		/*
		 * Basic FullBright is done!
		 */
		BC.getMc().gameSettings.gammaSetting = this.originalGammaSettings;
		BC.getChatTools().addToChat(this.getName() + " Disabled");
	}

	@Override
	public void onInGameRender() {
		/*
		 * This is here just for debug reasons, it will not be in the final release.
		 */
		Utils u = BC.getUtils();
		u.drawRect(0, 0, BC.getMc().fontRenderer.getStringWidth(this.getName()) + 4, 12, 0x80FFFFFF, 0x80000000);
		u.drawString(BC.getMc().fontRenderer, this.getName(), 2, 2, 0xFFFFFFFF);
	}

	@Override
	public void onOpenGui() {
		/*
		 * Lets open a GUI No?
		 */
		BC.getMc().displayGuiScreen(new TestGui());
	}

	@Override
	public void onPacketEdit(EditPacket event, Packet packetData, PacketType packetType) {
		Packet packet = packetData;
		
		/*
		 * Lets examine incoming packets
		 */
		if (packetType == PacketType.get) {
			
			if (packet instanceof S12PacketEntityVelocity) {
				S12PacketEntityVelocity ev = (S12PacketEntityVelocity) packet;
				Entity e = BC.getMc().theWorld.getEntityByID(ev.func_149412_c());
				
				if (e instanceof EntityFishHook) {
					if (ev.func_149409_f() == 0 && ev.func_149411_d() == 0 && ev.func_149410_e() != 0) {
						BC.getChatTools().addToChat("Pull the Fish in, hurry!");
					}
				}
			}
		} else
			
			/*
			 * Lets examine outgoing packets
			 */
			if (packetType == PacketType.send) {
				
				/*
				 * Lets stop chat messages from being sent to the chat and/or the server
				 */
				if(packet instanceof S02PacketChat) {
					event.setCanceled(true);
				}
			}
	}
}
