package trinity.config;

import nc.util.Lang;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.*;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.*;
import trinity.Reference;

import java.io.File;
import java.util.*;
import java.util.regex.*;

public class TrinityConfig {
	
	private static Configuration config = null;
	
	private static double salted = 50;
	
	private static int u233 = 130 / 2;
	private static int u235 = 108 / 2;
	private static int np237 = 81 / 2;
	private static int pu239 = 140 / 2;
	private static int am242 = 173 / 2;
	private static int cm247 = 124 / 2;
	private static int bk248 = 122 / 2;
	private static int cf249 = 194 / 2;
	private static int cf251 = 203 / 2;
	private static int cust1 = 100 / 2;
	private static int cust2 = 100 / 2;
	private static int cust3 = 100 / 2;
	private static int cust4 = 100 / 2;
	private static int custom_count = 4;
	private static int custom_nuke_default_radius = 100 / 2;
	private static String[] custom_nuke_default_ids = new String[] {"custom_1", "custom_2", "custom_3", "custom_4"};
	private static int icbm = 100 / 2;
	private static int anti = 50 / 2;
	private static int max = 1000;
	private static int speed = 512;
	// private static int cap = 300;
	private static float multiplier = 5;
	private static boolean render = true;
	
	private static boolean thermo = true;
	
	private static boolean custom = false;
	
	private static boolean lava = true;
	
	public static final String CATEGORY_NAME_OTHER = "Nuclear Weapons";
	
	public static double salted_burst;
	
	public static int u233_radius;
	
	public static int u235_radius;
	
	public static int np237_radius;
	
	public static int pu239_radius;
	
	public static int am242_radius;
	
	public static int cm247_radius;
	
	public static int bk248_radius;
	
	public static int cf249_radius;
	
	public static int cf251_radius;
	
	public static int custom_1_radius;
	
	public static int custom_2_radius;
	
	public static int custom_3_radius;
	
	public static int custom_4_radius;
	
	public static int[] custom_nuke_radii = new int[0];
	
	public static int custom_nuke_count;
	
	public static String[] custom_nuke_ids = new String[0];
	
	public static int antimatter_radius;
	
	public static int max_radius;
	
	public static int icbm_radius;
	
	public static int fallout_speed;
	
	public static double fallout_multiplier;
	
	public static boolean fallout_rendering;
	
	public static boolean thermonuclear;
	
	public static boolean custom_nukes;
	
	public static boolean lava_gen;
	
	// public static int capacity;
	
	public static void preInit() {
		File configFile = new File(Loader.instance().getConfigDir(), "trinity.cfg");
		config = new Configuration(configFile);
		syncFromFiles();
		
	}
	
	public static Configuration getConfig() {
		return config;
		
	}
	
	public static void clientPreInit() {
		MinecraftForge.EVENT_BUS.register(new ConfigEventHandler());
		
	}
	
	public static void syncFromFiles() {
		syncConfig(true, true);
		
	}
	
	public static void syncFromGui() {
		syncConfig(false, true);
		
	}
	
	public static void syncFromFields() {
		syncConfig(false, false);
		
	}
	
	private static void syncConfig(boolean loadFromFile, boolean setFromConfig) {
		if (loadFromFile)
			config.load();
		
		Property propertyCustom = config.get(CATEGORY_NAME_OTHER, "custom_nukes", (custom), Lang.localize("gui.config.nuke.custom_nukes.comment"));
		propertyCustom.setLanguageKey("gui.config.nuke.custom_nukes");
		
		Property propertyCustomCount = config.get(CATEGORY_NAME_OTHER, "custom_nuke_count", custom_count, Lang.localize("gui.config.nuke.custom_nuke_count.comment"), 0, Integer.MAX_VALUE);
		propertyCustomCount.setLanguageKey("gui.config.nuke.custom_nuke_count");
		
		Property propertyCustomIds = config.get(CATEGORY_NAME_OTHER, "custom_nuke_ids", getDefaultCustomIds(propertyCustomCount.getInt()), Lang.localize("gui.config.nuke.custom_nuke_ids.comment"));
		propertyCustomIds.setLanguageKey("gui.config.nuke.custom_nuke_ids");
		
		Property propertyThermonuclear = config.get(CATEGORY_NAME_OTHER, "thermonuclear", (thermo), Lang.localize("gui.config.nuke.thermonuclear.comment"));
		propertyThermonuclear.setLanguageKey("gui.config.nuke.thermonuclear");
		
		Property propertyFalloutRender = config.get(CATEGORY_NAME_OTHER, "fallout_rendering", (render), Lang.localize("gui.config.fallout.fallout_rendering.comment"));
		propertyFalloutRender.setLanguageKey("gui.config.fallout.fallout_rendering");
		
		Property propertySaltedBurst = config.get(CATEGORY_NAME_OTHER, "salted_burst", (salted), Lang.localize("gui.config.fallout.salted_burst.comment"), 1, Double.MAX_VALUE);
		propertySaltedBurst.setLanguageKey("gui.config.fallout.salted_burst");
		
		Property propertyFalloutRadius = config.get(CATEGORY_NAME_OTHER, "fallout_multiplier", (multiplier), Lang.localize("gui.config.fallout.fallout_multiplier.comment"), 1, Double.MAX_VALUE);
		propertyFalloutRadius.setLanguageKey("gui.config.fallout.fallout_multiplier");
		
		Property propertyU233Radius = config.get(CATEGORY_NAME_OTHER, "u233_radius", (u233), Lang.localize("gui.config.nuke.u233_radius.comment"), 1, Integer.MAX_VALUE);
		propertyU233Radius.setLanguageKey("gui.config.nuke.u233_radius");
		
		Property propertyU235Radius = config.get(CATEGORY_NAME_OTHER, "u235_radius", (u235), Lang.localize("gui.config.nuke.u235_radius.comment"), 1, Integer.MAX_VALUE);
		propertyU233Radius.setLanguageKey("gui.config.nuke.u235_radius");
		
		Property propertyNp237Radius = config.get(CATEGORY_NAME_OTHER, "np237_radius", (np237), Lang.localize("gui.config.nuke.np237_radius.comment"), 1, Integer.MAX_VALUE);
		propertyNp237Radius.setLanguageKey("gui.config.nuke.np237_radius");
		
		Property propertyPu239Radius = config.get(CATEGORY_NAME_OTHER, "pu239_radius", (pu239), Lang.localize("gui.config.nuke.pu239_radius.comment"), 1, Integer.MAX_VALUE);
		propertyPu239Radius.setLanguageKey("gui.config.nuke.pu239_radius");
		
		Property propertyAm242Radius = config.get(CATEGORY_NAME_OTHER, "am242_radius", (am242), Lang.localize("gui.config.nuke.am242_radius.comment"), 1, Integer.MAX_VALUE);
		propertyPu239Radius.setLanguageKey("gui.config.nuke.am242_radius");
		
		Property propertyCm247Radius = config.get(CATEGORY_NAME_OTHER, "cm247_radius", (cm247), Lang.localize("gui.config.nuke.cm247_radius.comment"), 1, Integer.MAX_VALUE);
		propertyCm247Radius.setLanguageKey("gui.config.nuke.cm247_radius");
		
		Property propertyBk248Radius = config.get(CATEGORY_NAME_OTHER, "bk248_radius", (bk248), Lang.localize("gui.config.nuke.bk248_radius.comment"), 1, Integer.MAX_VALUE);
		propertyBk248Radius.setLanguageKey("gui.config.nuke.bk248_radius");
		
		Property propertyCf249Radius = config.get(CATEGORY_NAME_OTHER, "cf249_radius", (cf249), Lang.localize("gui.config.nuke.cf249_radius.comment"), 1, Integer.MAX_VALUE);
		propertyCf249Radius.setLanguageKey("gui.config.nuke.cf249_radius");
		
		Property propertyCf251Radius = config.get(CATEGORY_NAME_OTHER, "cf251_radius", (cf251), Lang.localize("gui.config.nuke.cf251_radius.comment"), 1, Integer.MAX_VALUE);
		propertyCf251Radius.setLanguageKey("gui.config.nuke.cf251_radius");
		
		Property propertyCustom1Radius = config.get(CATEGORY_NAME_OTHER, "custom1_radius", (cust1), Lang.localize("gui.config.nuke.cust1_radius.comment"), 1, Integer.MAX_VALUE);
		propertyCustom1Radius.setLanguageKey("gui.config.nuke.cust1_radius");
		
		Property propertyCustom2Radius = config.get(CATEGORY_NAME_OTHER, "custom2_radius", (cust2), Lang.localize("gui.config.nuke.cust2_radius.comment"), 1, Integer.MAX_VALUE);
		propertyCustom2Radius.setLanguageKey("gui.config.nuke.cust2_radius");
		
		Property propertyCustom3Radius = config.get(CATEGORY_NAME_OTHER, "custom3_radius", (cust3), Lang.localize("gui.config.nuke.cust3_radius.comment"), 1, Integer.MAX_VALUE);
		propertyCustom3Radius.setLanguageKey("gui.config.nuke.cust3_radius");
		
		Property propertyCustom4Radius = config.get(CATEGORY_NAME_OTHER, "custom4_radius", (cust4), Lang.localize("gui.config.nuke.cust4_radius.comment"), 1, Integer.MAX_VALUE);
		propertyCustom4Radius.setLanguageKey("gui.config.nuke.cust4_radius");
		
		int[] legacyCustomRadii = readCustomRadiusValues(getCustomRadiusProperties(propertyCustomCount.getInt(), propertyCustom1Radius, propertyCustom2Radius, propertyCustom3Radius, propertyCustom4Radius));
		int customCount = propertyCustomIds.getStringList().length;
		Property propertyCustomRadii = config.get(CATEGORY_NAME_OTHER, "custom_nuke_radii", getDefaultCustomRadii(customCount, legacyCustomRadii), Lang.localize("gui.config.nuke.custom_nuke_radii.comment"), 1, Integer.MAX_VALUE);
		propertyCustomRadii.setLanguageKey("gui.config.nuke.custom_nuke_radii");
		
		Property propertyICBMRadius = config.get(CATEGORY_NAME_OTHER, "icbm_radius", (icbm), Lang.localize("gui.config.nuke.icbm_radius.comment"), 1, Integer.MAX_VALUE);
		propertyICBMRadius.setLanguageKey("gui.config.nuke.icbm_radius");
		
		Property propertyAntimatterRadius = config.get(CATEGORY_NAME_OTHER, "antimatter_radius", (anti), Lang.localize("gui.config.nuke.antimatter_radius.comment"), 1, Integer.MAX_VALUE);
		propertyAntimatterRadius.setLanguageKey("gui.config.nuke.antimatter_radius");
		
		Property propertyMaxRadius = config.get(CATEGORY_NAME_OTHER, "max_radius", (max), Lang.localize("gui.config.nuke.max_radius.comment"), 1, Integer.MAX_VALUE);
		propertyU233Radius.setLanguageKey("gui.config.nuke.max_radius");
		
		Property propertySpeed = config.get(CATEGORY_NAME_OTHER, "speed", (speed), Lang.localize("gui.config.nuke.speed.comment"), 1, Integer.MAX_VALUE);
		propertyU233Radius.setLanguageKey("gui.config.nuke.speed");
		
		Property propertyLava = config.get(CATEGORY_NAME_OTHER, "lava_gen", (lava), Lang.localize("gui.config.fallout.lava_gen.comment"));
		propertyThermonuclear.setLanguageKey("gui.config.fallout.lava_gen");
		
		// Property propertyCapacity = config.get(CATEGORY_NAME_OTHER, "capacity", (cap), Lang.localize("gui.config.nuke.capacity.comment"), 1, Integer.MAX_VALUE);
		// propertyU233Radius.setLanguageKey("gui.config.nuke.capacity");
		
		List<String> propertyOrderOther = new ArrayList<String>();
		config.setCategoryPropertyOrder(CATEGORY_NAME_OTHER, propertyOrderOther);
		
		if (setFromConfig) {
			custom_nukes = propertyCustom.getBoolean();
			custom_nuke_count = propertyCustomCount.getInt();
			lava_gen = propertyLava.getBoolean();
			thermonuclear = propertyThermonuclear.getBoolean();
			fallout_rendering = propertyFalloutRender.getBoolean();
			fallout_multiplier = propertyFalloutRadius.getDouble();
			salted_burst = propertySaltedBurst.getDouble();
			u233_radius = propertyU233Radius.getInt();
			u235_radius = propertyU235Radius.getInt();
			np237_radius = propertyNp237Radius.getInt();
			pu239_radius = propertyPu239Radius.getInt();
			am242_radius = propertyAm242Radius.getInt();
			cm247_radius = propertyCm247Radius.getInt();
			bk248_radius = propertyBk248Radius.getInt();
			cf249_radius = propertyCf249Radius.getInt();
			cf251_radius = propertyCf251Radius.getInt();
			custom_nuke_ids = readCustomIds(propertyCustomIds.getStringList());
			custom_nuke_radii = readCustomRadii(propertyCustomRadii.getIntList(), custom_nuke_ids.length, legacyCustomRadii);
			custom_1_radius = getCustomNukeRadius(1);
			custom_2_radius = getCustomNukeRadius(2);
			custom_3_radius = getCustomNukeRadius(3);
			custom_4_radius = getCustomNukeRadius(4);
			icbm_radius = propertyICBMRadius.getInt();
			antimatter_radius = propertyAntimatterRadius.getInt();
			max_radius = propertyMaxRadius.getInt();
			fallout_speed = propertySpeed.getInt();
			// capacity = propertyCapacity.getInt();
		}
		propertyCustom.set(custom_nukes);
		propertyCustomCount.set(custom_nuke_ids.length);
		propertyCustomIds.set(custom_nuke_ids);
		propertyLava.set(lava_gen);
		propertyThermonuclear.set(thermonuclear);
		propertyFalloutRender.set(fallout_rendering);
		propertySaltedBurst.set(salted_burst);
		propertyFalloutRadius.set(fallout_multiplier);
		propertyU233Radius.set(u233_radius);
		propertyU235Radius.set(u235_radius);
		propertyNp237Radius.set(np237_radius);
		propertyPu239Radius.set(pu239_radius);
		propertyAm242Radius.set(am242_radius);
		propertyCm247Radius.set(cm247_radius);
		propertyBk248Radius.set(bk248_radius);
		propertyCf249Radius.set(cf249_radius);
		propertyCf251Radius.set(cf251_radius);
		propertyCustomRadii.set(custom_nuke_radii);
		propertyICBMRadius.set(icbm_radius);
		propertyAntimatterRadius.set(antimatter_radius);
		propertyMaxRadius.set(max_radius);
		propertySpeed.set(fallout_speed);
		// propertyCapacity.set(capacity);
		
		if (config.hasChanged())
			config.save();
		
	}
	
	private static String[] getDefaultCustomIds(int configuredCustomCount) {
		int customCount = Math.max(4, configuredCustomCount);
		String[] ids = new String[customCount];
		for (int i = 0; i < customCount; i++) {
			ids[i] = i < custom_nuke_default_ids.length ? custom_nuke_default_ids[i] : "custom_" + (i + 1);
		}
		return ids;
	}
	
	private static int[] getDefaultCustomRadii(int configuredCustomCount, int[] legacyCustomRadii) {
		int customCount = configuredCustomCount;
		int[] radii = new int[customCount];
		for (int i = 0; i < customCount; i++) {
			radii[i] = i < legacyCustomRadii.length ? legacyCustomRadii[i] : custom_nuke_default_radius;
		}
		return radii;
	}
	
	private static String[] readCustomIds(String[] configuredIds) {
		int customCount = configuredIds.length;
		String[] ids = new String[customCount];
		Set<String> usedIds = new HashSet<String>();
		for (int i = 0; i < customCount; i++) {
			String fallback = i < custom_nuke_default_ids.length ? custom_nuke_default_ids[i] : "custom_" + (i + 1);
			String rawId = i < configuredIds.length ? configuredIds[i] : fallback;
			String id = sanitizeCustomId(rawId, fallback);
			if (usedIds.contains(id)) {
				id = fallback;
			}
			while (usedIds.contains(id)) {
				id = id + "_" + (i + 1);
			}
			ids[i] = id;
			usedIds.add(id);
		}
		return ids;
	}
	
	private static String sanitizeCustomId(String rawId, String fallback) {
		String id = rawId == null ? "" : rawId.trim().toLowerCase(Locale.ROOT);
		id = id.replaceAll("^_+", "");
		id = id.replaceAll("[^a-z0-9_]", "_");
		id = id.replaceAll("_+", "_");
		id = id.replaceAll("^_+|_+$", "");
		return id.isEmpty() ? fallback : id;
	}
	
	private static int[] readCustomRadii(int[] configuredRadii, int customCount, int[] legacyCustomRadii) {
		int[] radii = new int[customCount];
		for (int i = 0; i < customCount; i++) {
			if (i < configuredRadii.length) {
				radii[i] = Math.max(1, configuredRadii[i]);
			}
			else if (i < legacyCustomRadii.length) {
				radii[i] = Math.max(1, legacyCustomRadii[i]);
			}
			else {
				radii[i] = custom_nuke_default_radius;
			}
		}
		return radii;
	}
	
	private static Property[] getCustomRadiusProperties(int configuredCustomCount, Property propertyCustom1Radius, Property propertyCustom2Radius, Property propertyCustom3Radius, Property propertyCustom4Radius) {
		int customCount = Math.max(4, configuredCustomCount);
		Pattern customRadiusPattern = Pattern.compile("custom(\\d+)_radius");
		ConfigCategory category = config.getCategory(CATEGORY_NAME_OTHER);
		for (String propertyName : category.keySet()) {
			Matcher matcher = customRadiusPattern.matcher(propertyName);
			if (matcher.matches()) {
				customCount = Math.max(customCount, Integer.parseInt(matcher.group(1)));
			}
		}
		
		Property[] properties = new Property[customCount];
		properties[0] = propertyCustom1Radius;
		properties[1] = propertyCustom2Radius;
		properties[2] = propertyCustom3Radius;
		properties[3] = propertyCustom4Radius;
		for (int i = 4; i < customCount; i++) {
			int customIndex = i + 1;
			Property property = config.get(CATEGORY_NAME_OTHER, "custom" + customIndex + "_radius", custom_nuke_default_radius, Lang.localize("gui.config.nuke.custom_radius.comment"), 1, Integer.MAX_VALUE);
			property.setLanguageKey("gui.config.nuke.custom_radius");
			properties[i] = property;
		}
		return properties;
	}
	
	private static int[] readCustomRadiusValues(Property[] customRadiusProperties) {
		int[] values = new int[customRadiusProperties.length];
		for (int i = 0; i < customRadiusProperties.length; i++) {
			values[i] = customRadiusProperties[i].getInt();
		}
		return values;
	}
	
	public static int getCustomNukeRadius(int customIndex) {
		if (custom_nuke_radii == null || custom_nuke_radii.length == 0) {
			return custom_nuke_default_radius;
		}
		if (customIndex < 1 || customIndex > custom_nuke_radii.length) {
			return custom_nuke_default_radius;
		}
		return custom_nuke_radii[customIndex - 1];
	}
	
	private static double[] readDoubleArrayFromConfig(Property property) {
		int currentLength = property.getDoubleList().length;
		int defaultLength = property.getDefaults().length;
		if (currentLength == defaultLength) {
			return property.getDoubleList();
		}
		double[] newArray = new double[defaultLength];
		if (currentLength > defaultLength) {
			for (int i = 0; i < defaultLength; i++) {
				newArray[i] = property.getDoubleList()[i];
			}
		}
		else {
			for (int i = 0; i < currentLength; i++) {
				newArray[i] = property.getDoubleList()[i];
			}
			for (int i = currentLength; i < defaultLength; i++) {
				newArray[i] = property.setToDefault().getDoubleList()[i];
			}
		}
		return newArray;
	}
	
	public static class ConfigEventHandler {
		
		@SubscribeEvent(priority = EventPriority.LOWEST)
		public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MOD_ID)) {
				syncFromGui();
				
			}
		}
	}
}
