package com.breakcraft.mod;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ModList {

	public static List<Mod> mods = new ArrayList<Mod>();
	
	public ModList() {}

	public List<Mod> getMods() {
		return this.mods;
	}
	
	public void addMod(Mod mod) {
		this.mods.add(mod);
	}
	
	public void removeMod(Mod mod) {
		this.mods.remove(mod);
	}
	
	public void loadMods(String pkg) {
		File directory = null;
		String relPath = pkg.replace('.', '/');
		URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);
		if (resource == null) return;

		try {
			directory = new File(resource.toURI());
		} catch (IllegalArgumentException | URISyntaxException e) {
			directory = null;
		}

		if (directory != null && directory.exists()) {
			String[] files = directory.list();
			for (int i = 0; i < files.length; i++) {
				if (files[i].endsWith(".class")) {
					String className = pkg + '.' + files[i].substring(0, files[i].length() - 6);
					try {
						Class c = Class.forName(className);
						for (Method m : c.getMethods()) {
							Object o = c.newInstance();
							if (m.getName().contains("load")) {
								try {
									m.setAccessible(true);
									m.invoke(o);
								} catch (IllegalAccessException | InvocationTargetException e) {}
							}
						}
					} catch (IllegalArgumentException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {}
				}
			}
		}
	}
}
