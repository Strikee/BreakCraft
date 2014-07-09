package com.breakcraft.mod.mods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.breakcraft.BC;
import com.breakcraft.event.events.EditPacket;
import com.breakcraft.mod.Mod;
import com.breakcraft.mod.Mod.modCategory;
import com.breakcraft.mod.Mod.modFunction;

public class Tracers extends Mod {
	
	private boolean originalViewBobbing;

	public Tracers() {}
	
	// This is where you add some key info for the Mod (Name, Category, Function, KeyBind Key, Default Enabled State)
	private static final Mod mod = new Tracers("Tracers", modCategory.Render, modFunction.Toggle, Keyboard.KEY_L, false);

	public Tracers(String modName, modCategory modCategory, modFunction modFunction, int modKey, boolean modEnabled) {
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
	
	@SuppressWarnings("unused")
	@Override
	public void onEntityRender() {
		BC.getMc().gameSettings.viewBobbing = false;
		float dist, r, g, b, a;
		double X, Y, Z, xt, xb, yt, yb, zt, zb, xx, yy, zz;
		for (int listpos = 0; listpos < BC.getMc().theWorld.loadedEntityList.size(); listpos++) {
			Object o = BC.getMc().theWorld.loadedEntityList.get(listpos);
			if (!(o instanceof Entity)) continue;
			Entity ep = (Entity) o;
//			if(ep.isDead || !ep.isEntityAlive() || ep == BC.getMc().thePlayer) continue;

			dist = BC.getMc().thePlayer.getDistanceToEntity(ep);

			// Tracer Pos
			X = ep.boundingBox.minX - BC.getMc().thePlayer.boundingBox.minX;
			Y = ep.boundingBox.maxY - BC.getMc().thePlayer.boundingBox.maxY - 1.5;
			Z = ep.boundingBox.minZ - BC.getMc().thePlayer.boundingBox.minZ;

			// Box Edits
			xb = ep.boundingBox.minX - BC.getMc().thePlayer.boundingBox.minX - 0.5;
			yb = ep.boundingBox.minY - BC.getMc().thePlayer.boundingBox.minY - 1.7;
			zb = ep.boundingBox.minZ - BC.getMc().thePlayer.boundingBox.minZ - 0.5;
			xt = (ep.boundingBox.maxX - BC.getMc().thePlayer.boundingBox.maxX) + 0.5;
			yt = (ep.boundingBox.maxY - BC.getMc().thePlayer.boundingBox.maxY) + 0.4;
			zt = (ep.boundingBox.maxZ - BC.getMc().thePlayer.boundingBox.maxZ) + 0.5;

			// Sphere Pos
			// xx = ep.posX - mc.thePlayer.posX;
			// yy = ep.posY - mc.thePlayer.posY;
			// zz = ep.posZ - mc.thePlayer.posZ;

			float lw = 1.0F;
//
//			if (Friend.isFriend(StringUtils.stripControlCodes(ep
//					.getCommandSenderName()))
//					|| ep.getCommandSenderName().equals(
//							Hooks.getPlayerName() + "-FreeCam")) {
			if (ep instanceof EntityMob) {
				r = 1.0F;
				g = 0.0F;
				b = 0.0F;
				a = 0.5F;
			} else
				if (ep instanceof EntityAnimal) {
					r = 0.0F;
					g = 1.0F;
					b = 0.0F;
					a = 0.5F;
				} else 
				if (ep instanceof EntityItem) {
					r = 1.0F;
					g = 1.0F;
					b = 1.0F;
					a = 0.5F;
				} else {
					r = 0.0F;
					g = 0.0F;
					b = 1.0F;
					a = 0.5F;
				}
//				lw = (float) Values.linewidthtracersfriends.value;
//			} else {
//				lw = (float) Values.linewidthtracers.value;
//				int color = GetColor.hexColor((int) dist);
//				r = GetColor.getRedFromHex(color);
//				g = GetColor.getGreenFromHex(color);
//				b = GetColor.getBlueFromHex(color);
//				a = GetColor.getAlphaFromHex(color);
//			}

			GL11.glPushMatrix();
			GL11.glColor4f(r, g, b, (float) ((0 > 0) ? 0.75 : 0.25));
			GL11.glLineWidth(lw);
			GL11.glDisable(3553);
			// GL11.glDisable(2896 /*GL_LIGHTING*/);
			GL11.glDepthMask(false);
			GL11.glBlendFunc(770, 771);
			GL11.glEnable(GL11.GL_LINE_SMOOTH);
			GL11.glEnable(3042 /* GL_BLEND */);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(2929 /* GL_DEPTH_TEST */);

			// Tracers
			GL11.glBegin(GL11.GL_LINE_LOOP);
			GL11.glVertex3d(0, 0, 0);
			GL11.glVertex3d(X, Y, Z);
			GL11.glEnd();

			// //Player Boxes
			// GL11.glColor4d(r, g, b, 0.11F);
			// // GL11.glRotatef(ep.hurtTime * 90, 0, 0, 0);
			// drawBoundingBox(new AxisAlignedBB(xb, yb, zb, xt, yt, zt));
			// GL11.glColor4d(r, g, b, a);
			// drawOutlinedBoundingBox(new AxisAlignedBB(xb, yb, zb, xt, yt,
			// zt));

			// Hit Sphere
			// if(mc.thePlayer.canEntityBeSeen(ep)){
			// GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
			// }
			// GL11.glColor4d(r, g, b, 0.11F);
			// GL11.glTranslated(xx, yy, zz);
			// GL11.glRotatef(ep.hurtTime * 90, 0, 0, 0);
			// GL11.glColor4d(r, g, b, 0.50);
			// Sphere s = new Sphere();
			// s.setDrawStyle(GLU.GLU_LINE);
			// s.draw(4.0f, 25, 25);
			// if(mc.thePlayer.canEntityBeSeen(ep)){
			// GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
			// }

			GL11.glEnable(2929 /* GL_DEPTH_TEST */);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(3042 /* GL_BLEND */);
			GL11.glDisable(GL11.GL_LINE_SMOOTH);
			GL11.glDepthMask(true);
			// GL11.glEnable(2896 /*GL_LIGHTING*/);
			GL11.glEnable(3553);
			GL11.glPopMatrix();
		}
	}

	@Override
	public void onEnable() {
		this.originalViewBobbing = BC.getMc().gameSettings.viewBobbing;
		BC.getMc().gameSettings.viewBobbing = false;
	}

	@Override
	public void onDisable() {
		BC.getMc().gameSettings.viewBobbing = this.originalViewBobbing;
	}
}
