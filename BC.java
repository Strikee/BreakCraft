package com.breakcraft;

import com.breakcraft.mod.Mod;
import com.breakcraft.mod.ModList;
import com.breakcraft.tools.ChatTools;
import com.breakcraft.window.utils.Utils;

import net.minecraft.client.Minecraft;

public class BC {

	private static Minecraft bcMc;
	private static BCInfo bcInfo;
	private static ModList bcModList;
	private static Utils bcUtils;
	private static ChatTools bcChatTools;

	public static void init(Minecraft minecraft) {
		setMc(minecraft);
		setBCInfo(new BCInfo());
		setUtils(new Utils());
		setChatTools(new ChatTools());
		setModList(new ModList());
		
		getBCInfo().setClientName("BreakCraft");
		getBCInfo().setClientVersion("0.0.1");
		getBCInfo().setClientWebsite("BreakCraft.com");
		getBCInfo().setClientDeveloperName("SoWhoYou");
		getModList().loadMods("com.breakcraft.mod.mods");
		
		debugMsg("Inital Load Complete.");
	}
	
	/*
	 * Get/Set MineCraft
	 */
	public static Minecraft getMc() {
		return bcMc;
	}
	
	private static void setMc(Minecraft mc) {
		bcMc = mc;
	}
	
	/*
	 * Get/Set ClientInfo
	 */
	public static BCInfo getBCInfo() {
		return bcInfo;
	}
	
	private static void setBCInfo(BCInfo info) {
		bcInfo = info;
	}
	
	/*
	 * Get/Set ChatTools
	 */
	public static ChatTools getChatTools() {
		return bcChatTools;
	}
	
	private static void setChatTools(ChatTools chatTools) {
		bcChatTools = chatTools;
	}
	
	/*
	 * Get/Set Utils
	 */
	public static Utils getUtils() {
		return bcUtils;
	}
	
	private static void setUtils(Utils utils) {
		bcUtils = utils;
	}
	
	/*
	 * Get/Set ModList
	 */
	public static ModList getModList() {
		return bcModList;
	}
	
	private static void setModList(ModList modList) {
		bcModList = modList;
	}
	
	/*
	 * Debug Settings
	 */
	private static boolean getDebug() {
		return true;
	}
	
	public static void debugMsg(String debugMsg) {
		if (getDebug()) System.out.println("[" + bcInfo.getClientName() + "] " + debugMsg);
	}

}
