package com.breakcraft;

import com.breakcraft.mod.Mod;
import com.breakcraft.mod.ModList;
import com.breakcraft.tools.ChatTools;
import com.breakcraft.tools.Info;
import com.breakcraft.tools.Utils;

import net.minecraft.client.Minecraft;

public class BC {

	private static Minecraft bcMc;
	private static Info Info;
	private static ModList bcModList;
	private static Utils bcUtils;
	private static ChatTools bcChatTools;

	public static void init(Minecraft minecraft) {
		setMc(minecraft);
		
		setInfo(new Info());
		getInfo().setClientName("BreakCraft");
		getInfo().setClientVersion("0.0.1");
		getInfo().setClientWebsite("BreakCraft.com");
		getInfo().setClientDeveloperName("SoWhoYou");
		
		setUtils(new Utils());
		setChatTools(new ChatTools());
		
		setModList(new ModList());
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
		debugMsg("Minecraft set to: " + mc);
	}
	
	/*
	 * Get/Set ClientInfo
	 */
	public static Info getInfo() {
		return Info;
	}
	
	private static void setInfo(Info info) {
		Info = info;
		debugMsg("Info set to: " + info);
	}
	
	/*
	 * Get/Set ChatTools
	 */
	public static ChatTools getChatTools() {
		return bcChatTools;
	}
	
	private static void setChatTools(ChatTools chatTools) {
		bcChatTools = chatTools;
		debugMsg("ChatTools set to: " + chatTools);
	}
	
	/*
	 * Get/Set Utils
	 */
	public static Utils getUtils() {
		return bcUtils;
	}
	
	private static void setUtils(Utils utils) {
		bcUtils = utils;
		debugMsg("Utils set to: " + utils);
	}
	
	/*
	 * Get/Set ModList
	 */
	public static ModList getModList() {
		return bcModList;
	}
	
	private static void setModList(ModList modList) {
		bcModList = modList;
		debugMsg("ModList set to: " + modList);
	}
	
	/*
	 * Debug Settings
	 */
	private static boolean getDebug() {
		return true;
	}
	
	public static void debugMsg(String debugMsg) {
		try {
		if (getDebug()) System.out.println("[" + getInfo().getClientName() + "] " + debugMsg);
		} catch (Exception e) {
			
		}
	}

}
