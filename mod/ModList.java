package com.breakcraft.mod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import com.breakcraft.BC;

public class ModList {

	public static List<Mod> mods = new ArrayList<Mod>();
	private final static char DOT = '.';
	private final static char SLASH = '/';
	private final static String CLASS_SUFFIX = ".class";
	private final static String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the given '%s' package exists?";

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
		try {
			List<Class<?>> classes = this.find(pkg);
			for(Class<?> c : classes) {
				for (Method m : c.getMethods()) {
					Object o = c.newInstance();
					if (m.getName().contains("load")) {
						m.setAccessible(true);
						m.invoke(o);
					}
				}
			}
		} catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {}

	}

	public final static List<Class<?>> find(final String scannedPackage) {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		final String scannedPath = scannedPackage.replace(DOT, SLASH);
		final Enumeration<URL> resources;
		try {
			resources = classLoader.getResources(scannedPath);
		} catch (IOException e) {
			throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage), e);
		}
		final List<Class<?>> classes = new LinkedList<Class<?>>();
		while (resources.hasMoreElements()) {
			final File file = new File(resources.nextElement().getFile());
			classes.addAll(find(file, scannedPackage));
		}
		return classes;
	}

	private final static List<Class<?>> find(final File file, final String scannedPackage) {
		final List<Class<?>> classes = new LinkedList<Class<?>>();
		final String resource = scannedPackage + DOT + file.getName();
		if (file.isDirectory()) {
			for (File nestedFile : file.listFiles()) {
				classes.addAll(find(nestedFile, scannedPackage + (scannedPackage.contains(file.getName()) ? "" : DOT + file.getName())));
			}
		} else if (resource.endsWith(CLASS_SUFFIX)) {
			final int beginIndex = 0;
			final int endIndex = resource.length() - CLASS_SUFFIX.length();
			final String className = resource.substring(beginIndex, endIndex);
			try {
				classes.add(Class.forName(className));
			} catch (ClassNotFoundException e) {}
		}
		return classes;
	}
}
