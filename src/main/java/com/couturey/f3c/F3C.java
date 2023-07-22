package com.couturey.f3c;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class F3C implements ModInitializer {

	public static final String MOD_ID = "f3c";
    public static final Logger LOGGER = LoggerFactory.getLogger("f3c");

	@Override
	public void onInitialize() {
		LOGGER.info("Started initializing F3C Mod with mod_id: " + MOD_ID);
	}
}