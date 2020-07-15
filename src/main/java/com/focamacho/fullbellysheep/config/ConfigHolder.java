package com.focamacho.fullbellysheep.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;

public class ConfigHolder {

    public static FullBellySheepConfig config;
    public static boolean restoreWool;

    public static void initConfig() {
        config = AutoConfig.getConfigHolder(FullBellySheepConfig.class).getConfig();

        restoreWool = config.restoreWool;
    }

}
