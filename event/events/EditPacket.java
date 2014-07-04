package com.breakcraft.event.events;

import net.minecraft.network.Packet;

import com.breakcraft.BC;
import com.breakcraft.event.Event;
import com.breakcraft.mod.Mod;

public class EditPacket extends Event {

	public EditPacket(Packet packet, PacketType packetType) {
		this.setPacket(packet);
		this.setPacketType(packetType);
	}
	
	public void processPacket() {
		for (Mod mod : BC.getModList().getMods()) if (mod.getEnabled()) mod.onPacketEdit(this, this.getPacket(), this.getPacketType());
	}
	
	public enum PacketType {
		get,
		send
	}
}
