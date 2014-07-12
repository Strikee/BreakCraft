package com.breakcraft.window.windows;

import com.breakcraft.BC;
import com.breakcraft.tools.Screen;
import com.breakcraft.window.Window;

import net.minecraft.client.gui.GuiButton;

public class TestGui extends Window {

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);
		BC.getUtils().drawRect((this.width / 2) - (this.width / 4), (this.height / 2) - (this.height / 4), (this.width / 2) + (this.width / 4), (this.height / 2) + (this.height / 4), 0x803399FF, 0x80000000);
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		super.keyTyped(par1, par2);
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		super.mouseClicked(par1, par2, par3);
	}

	@Override
	protected void actionPerformed(GuiButton p_146284_1_) {
		super.actionPerformed(p_146284_1_);
	}

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	public void handleInput() {
		super.handleInput();
	}

	@Override
	public void handleMouseInput() {
		super.handleMouseInput();
	}

	@Override
	public void handleKeyboardInput() {
		super.handleKeyboardInput();
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	public void drawDefaultBackground() {
		super.drawDefaultBackground();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return super.doesGuiPauseGame();
	}

}
