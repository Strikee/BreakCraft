package com.breakcraft.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

import com.breakcraft.BC;
import com.breakcraft.event.Event;
import com.breakcraft.event.events.ClientTick;
import com.breakcraft.event.events.EditPacket;
import com.breakcraft.event.events.EditPacket.PacketType;
import com.breakcraft.event.events.InEntityRender;
import com.breakcraft.event.events.InGameRender;
import com.breakcraft.event.events.KeyPress;
import com.breakcraft.event.events.PostUpdate;
import com.breakcraft.event.events.PreUpdate;

public class Hooks {

	private static NetworkManager networkManager;
	private static NetHandlerPlayClient netHandlerPlayClient;

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
	 * NetHandlerPlayClient.java - Line 777
	 */
	public static Packet getSendingPacket(Packet packet, PacketType packetType) {
		Event event = new EditPacket(packet, packetType);
		Event.newEvent(event);
		return event.getCanceled() ? null : event.getPacket();
	}
	
	/*
	 * NetworkManager.java - Line 260
	 */
	public static Packet getReceivingPacket(Packet packet, PacketType packetType) {
		Event event = new EditPacket(packet, packetType);
		Event.newEvent(event);
		return event.getCanceled() ? null : event.getPacket();
	}

	/*
	 * EntityRenderer.java - Line 1449
	 */
	public static void entityRenderer() {
		Event event = new InEntityRender();
		Event.newEvent(event);
		
	}
}
