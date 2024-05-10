package com.couturey.f3c.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import static com.couturey.f3c.F3C.MODID;

@Config(name=MODID)
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean modEnabled = true;

    @ConfigEntry.Gui.Tooltip
    public String chatOutput = "%d %d %d";
}
