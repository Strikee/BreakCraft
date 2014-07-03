package com.breakcraft.event.events;

import com.breakcraft.BC;
import com.breakcraft.event.Event;
import com.breakcraft.mod.Mod;

public class InGameRender extends Event {

	public void onInGameRender() {
		for (Mod mod : BC.getModList().getMods()) if (mod.getEnabled()) mod.onInGameRender();
	}

}
