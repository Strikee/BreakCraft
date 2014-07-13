package com.breakcraft.mod.mods;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockSponge;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;

import com.breakcraft.BC;
import com.breakcraft.Hooks;
import com.breakcraft.event.Event;
import com.breakcraft.event.events.EditPacket;
import com.breakcraft.event.events.EditPacket.PacketType;
import com.breakcraft.mod.Mod;
import com.breakcraft.mod.ModList;
import com.breakcraft.tools.Window;

public class TestMod extends Mod {

	private float originalGammaSettings;
	private int tickCount;

	public TestMod() {}

	// This is where the mod is defined by name, category, function, and the default keybind
	private static final Mod mod = new TestMod("Test Mod", modCategory.Misc, modFunction.Toggle, Keyboard.KEY_F12, true);

	public TestMod(String modName, modCategory modCategory, modFunction modFunction, int modKey, boolean modEnabled) {
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
	public void onClientTick() {
		/*
		 * Like ticks?
		 */
		//		if (this.tickCount >= 20) {
		//			BC.getChatTools().addToConsole("20 Ticks");
		//			this.tickCount = 0;
		//		} else {
		//			BC.getChatTools().addToConsole("Tick " + this.tickCount);
		//			this.tickCount++;
		//		}
	}

	@Override
	public void onEnable() {
		//BC.getChatTools().addToConsole(this.getName() + " Enabled");
	}

	@Override
	public void onDisable() {
		//BC.getChatTools().addToConsole(this.getName() + " Disabled");
	}

	@Override
	public void onOpenGui() {
		/*
		 * Lets open a GUI No?
		 */
		//		BC.getMc().displayGuiScreen(new TestGui());
	}

	@Override
	public void onScreenUpdate(GuiScreen eventScreen, List eventButtons, List eventLabels) {
		GuiScreen gui = eventScreen;
		for (Object o : eventButtons) {
			GuiButton b = (GuiButton)o;
			BC.debugMsg(b.displayString);
		}
	}


}
