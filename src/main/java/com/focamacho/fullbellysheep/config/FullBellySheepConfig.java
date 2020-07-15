package com.focamacho.fullbellysheep.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "fullbellysheep")
public class FullBellySheepConfig implements ConfigData {

    @Comment(value = "Feeding sheep with grass(item) restores its wool")
    boolean restoreWool = true;

}
