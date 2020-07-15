package com.focamacho.fullbellysheep;

import com.focamacho.fullbellysheep.config.ConfigHolder;
import com.focamacho.fullbellysheep.config.FullBellySheepConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class FullBellySheep implements ModInitializer {

	@Override
	public void onInitialize() {
		AutoConfig.register(FullBellySheepConfig.class, JanksonConfigSerializer::new);
		ConfigHolder.initConfig();
	}

}
