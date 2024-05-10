package com.couturey.f3c;

import com.couturey.f3c.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class F3C implements ModInitializer {

	public static final String MODID = "f3c";
    public static final Logger LOGGER = LoggerFactory.getLogger("f3c");

	@Override
	public void onInitialize() {
		LOGGER.info("Started initializing F3C Mod with mod_id: " + MODID);

		AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
	}
}