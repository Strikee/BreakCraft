package com.breakcraft.event.events;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;

import com.breakcraft.BC;
import com.breakcraft.event.Event;
import com.breakcraft.mod.Mod;

public class ScreenUpdate extends Event {

	private GuiScreen eventScreen;
	private List eventButtons;
	private List eventLabels;

	public ScreenUpdate(GuiScreen guiScreen, List buttonList, List labelList) {
		this.eventScreen = guiScreen;
		this.eventButtons = buttonList;
		this.eventLabels = labelList;
	}
	
	public void updateScreen() {
		for (Mod mod : BC.getModList().getMods()) if (mod.getEnabled()) mod.onScreenUpdate(this.eventScreen, this.eventButtons, this.eventLabels);
	}
}
