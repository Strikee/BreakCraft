package com.breakcraft;

import com.breakcraft.mod.Mod;
import com.breakcraft.mod.ModList;
import com.breakcraft.tools.Chat;
import com.breakcraft.tools.Client;
import com.breakcraft.tools.Window;

import net.minecraft.client.Minecraft;

public class BC {

	private static Minecraft bcMc;
	private static Client Info;
	private static ModList bcModList;
	private static Window bcWindow;
	private static Chat bcChatTools;

	public static void init(Minecraft minecraft) {
		setMc(minecraft);
		setInfo(new Client());
		setWindow(new Window());
		setChatTools(new Chat());
		setModList(new ModList());

		getInfo().setClientName("BreakCraft");
		getInfo().setClientVersion("0.0.1");
		getInfo().setClientWebsite("BreakCraft.com");
		getInfo().setClientDeveloperName("SoWhoYou");

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
	public static Client getInfo() {
		return Info;
	}

	private static void setInfo(Client info) {
		Info = info;
	}

	/*
	 * Get/Set ChatTools
	 */
	public static Chat getChatTools() {
		return bcChatTools;
	}

	private static void setChatTools(Chat chatTools) {
		bcChatTools = chatTools;
	}

	/*
	 * Get/Set Utils
	 */
	public static Window getWindow() {
		return bcWindow;
	}

	private static void setWindow(Window window) {
		bcWindow = window;
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
		try {
			if (getDebug()) System.out.println("[" + getInfo().getClientName() + "] " + debugMsg);
		} catch (Exception e) {

		}
	}

}
