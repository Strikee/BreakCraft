package com.breakcraft.event.events;

import org.lwjgl.input.Keyboard;

import com.breakcraft.BC;
import com.breakcraft.event.Event;
import com.breakcraft.mod.Mod;
import com.breakcraft.objects.KeyBind;

public class KeyPress extends Event {

	private int eventKey;

	public KeyPress(int eventKey) { 
		this.eventKey = eventKey;
	}

	public void pressKey() {
		for (Mod mod : BC.getModList().getMods()) {
			
			if (mod.getKeyBind().getKeyId() == this.eventKey) {
				BC.debugMsg("Mod: " + mod.getName() + " Action: KeyPressed");
				mod.keyPressed();
				
				if (mod.getCancelable()) {
					BC.debugMsg("Mod: " + mod.getName() + " Action: Setting canceled");
					this.setCanceled(true);
				}
			}
		}
	}
}
