package com.breakcraft.event;

import net.minecraft.network.Packet;

import com.breakcraft.BC;
import com.breakcraft.event.events.ClientTick;
import com.breakcraft.event.events.EditPacket;
import com.breakcraft.event.events.InGameRender;
import com.breakcraft.event.events.KeyPress;
import com.breakcraft.event.events.PostUpdate;
import com.breakcraft.event.events.PreUpdate;

public class Event {

	private boolean eventCanceled;
	private Packet eventPacket;

	public Packet getPacket() {
		return this.eventPacket;
	}
	
	public void setPacket(Packet packet) {
		this.eventPacket = packet;
	}
	
	public boolean getCanceled() {
		return this.eventCanceled;
	}

	public void setCanceled(Boolean canceled) {
		this.eventCanceled = canceled;
	}

	public static void newEvent(Event event) {
		if (event instanceof ClientTick) {
			((ClientTick) event).onClientTick();
		} else
			if (event instanceof PreUpdate) {
				((PreUpdate) event).onUpdate();
			} else
				if (event instanceof PostUpdate) {
					((PostUpdate) event).onUpdate();
				} else
					if (event instanceof KeyPress) {
						((KeyPress) event).pressKey();
					} else
						if (event instanceof InGameRender) {
							((InGameRender) event).onInGameRender();
						} else
							if (event instanceof EditPacket) {
								((EditPacket) event).processPacket();
							}
	}
}
