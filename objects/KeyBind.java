package com.breakcraft.objects;

import org.lwjgl.input.Keyboard;

import com.breakcraft.mod.Mod;

public class KeyBind {

	private int keyId;
	
	public KeyBind(int keyId) {
		this.keyId = keyId;
	}
	
	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}
	
	public int getKeyId() {
		return this.keyId;
	}
	
	public String getKeyName() {
		return Keyboard.getKeyName(this.keyId);
	}
}
