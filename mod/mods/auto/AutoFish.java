package com.breakcraft.mod.mods.auto;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

import org.lwjgl.input.Keyboard;

import com.breakcraft.BC;
import com.breakcraft.event.events.EditPacket;
import com.breakcraft.mod.Mod;
import com.breakcraft.mod.Mod.modCategory;
import com.breakcraft.mod.Mod.modFunction;

public class AutoFish extends Mod {

	public AutoFish() {}

	// This is where you add some key info for the Mod (Name, Category, Function, KeyBind Key)
	private static final Mod mod = new AutoFish("Auto Fish", modCategory.Auto, modFunction.Toggle, Keyboard.CHAR_NONE, false);

	public AutoFish(String modName, modCategory modCategory, modFunction modFunction, int modKey, boolean modEnabled) {
		super(modName, modCategory, modFunction, modKey, modEnabled);
	}

	// This part never needs modification unless we want to change the debug output
	public void load() {
		BC.getModList().addMod(mod);
		BC.debugMsg("--------------------------------------");
		BC.debugMsg("New Mod Added! - Total Mods: " + BC.getModList().getMods().size());
		BC.debugMsg("--------------------------------------");
		BC.debugMsg("Mod Name: " + mod.getName());
		BC.debugMsg("Mod Category: " + mod.getCategory());
		BC.debugMsg("Mod Function: " + mod.getFunction());
		BC.debugMsg("Mod KeyBind: " + mod.getKeyBind().getKeyName());
		BC.debugMsg("--------------------------------------");
	}

	@Override
	public void onPacketEdit(EditPacket editPacket) {
		
		if (editPacket.getPacketType() == EditPacket.PacketType.get) {
			
			if (editPacket.getPacket() instanceof S12PacketEntityVelocity) {
				S12PacketEntityVelocity thePacket = (S12PacketEntityVelocity) editPacket.getPacket();
				Entity e = BC.getMc().theWorld.getEntityByID(thePacket.func_149412_c());

				/*
				 * Wait is this what I think it is?
				 */
				if (e instanceof EntityFishHook) {
					if (thePacket.func_149409_f() == 0 && thePacket.func_149411_d() == 0 && thePacket.func_149410_e() != 0) {
						/*
						 * OMG we got a fish!
						 */
						BC.getChatTools().addToChat("Ummm... I think we've got something!");
						/*
						 * Lets get that fish!
						 */
						for(int i = 0; i < 4; i++){
							if(i == 1 || i == 3) { // 1 = Get : 3 = Recast
								BC.getMc().getNetHandler().addToSendQueue(new C08PacketPlayerBlockPlacement(-1, -1, -1, 255, BC.getMc().thePlayer.inventory.getCurrentItem(), 0.0F, 0.0F, 0.0F));
							}
						}
						/*
						 * Did you get the fish?
						 */
						BC.getChatTools().addToChat("Holly shit it worked! You got a fish!");
					}
				}
			}
		}
	}
	
}
