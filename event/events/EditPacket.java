package com.breakcraft.event.events;

import net.minecraft.network.Packet;

import com.breakcraft.BC;
import com.breakcraft.event.Event;
import com.breakcraft.mod.Mod;

public class EditPacket extends Event {

	private Packet packetData;
	private type packetType;

	public EditPacket(Packet packet, type type) {
		this.packetData = packet;
		this.packetType = type;
	}
	
	public void processPacket() {
		for (Mod mod : BC.getModList().getMods()) if (mod.getEnabled()) mod.onPacketEdit(this.packetData, this.packetType);
	}
	
	public enum type {
		get,
		send
	}
}
