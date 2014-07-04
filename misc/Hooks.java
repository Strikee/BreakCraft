package com.breakcraft.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;

import com.breakcraft.BC;
import com.breakcraft.event.Event;
import com.breakcraft.event.events.ClientTick;
import com.breakcraft.event.events.EditPacket;
import com.breakcraft.event.events.EditPacket.PacketType;
import com.breakcraft.event.events.InGameRender;
import com.breakcraft.event.events.KeyPress;
import com.breakcraft.event.events.PostUpdate;
import com.breakcraft.event.events.PreUpdate;

public class Hooks {

	/*
	 * Minecraft.java - Line 361
	 */
	public static void setMinecraft(Minecraft minecraft) {
		BC.init(minecraft);
	}

	/*
	 * MineCraft.java - Line 1886
	 */
	public static boolean getKey(int eventKey) {
		Event event = new KeyPress(eventKey);
		Event.newEvent(event);
		return event.getCanceled();
	}
	
	/*
	 * EntityClientPlayerMP.java - Line 101
	 */
	public static boolean clientTick() {
		Event event = new ClientTick();
		Event.newEvent(event);
		return event.getCanceled();
	}
	
	/*
	 * EntityClientPlayerMP.java - Line 110
	 */
	public static boolean preUpdate() {
		Event event = new PreUpdate();
		Event.newEvent(event);
		return event.getCanceled();
	}
	
	/*
	 * EntityClientPlayerMP.java - Line 112
	 */
	public static boolean postUpdate() {
		Event event = new PostUpdate();
		Event.newEvent(event);
		return event.getCanceled();
	}
	
	/*
	 * GuiIngame.java - Line 358
	 */
	public static void inGameRender() {
		Event event = new InGameRender();
		Event.newEvent(event);
	}
	
	/*
	 * NetHandlerPlayClient.java - Line 776
	 */
	public static Packet getSendingPacket(Packet packet, PacketType packetType) {
		Event event = new EditPacket(packet, packetType);
		Event.newEvent(event);
		return event.getPacket();
	}
	
	/*
	 * NetworkManager.java - Line 259
	 */
	public static boolean getReceivingPacket(Packet packet, PacketType packetType) {
		Event event = new EditPacket(packet, packetType);
		Event.newEvent(event);
		return event.getCanceled();
	}
}
