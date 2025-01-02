package elocindev.offhandtickfix.config.entries;

import java.util.List;

import elocindev.offhandtickfix.OffHandTickFix;
import elocindev.necronomicon.api.config.v1.NecConfigAPI;
import elocindev.necronomicon.config.Comment;
import elocindev.necronomicon.config.NecConfig;

public class OffHandTickFixConfig {
    @NecConfig public static OffHandTickFixConfig INSTANCE;

    public static String getFile() {
        return NecConfigAPI.getFile(OffHandTickFix.MODID+".json5");
    }

    @Comment("If you want the mod to only fix certain items, you can use this config.")
    @Comment("Example: minecraft:stick will only fix sticks. But you can use regex, so for example")
    @Comment("if you want to fix all items from vanilla, use 'minecraft:.*' (This is not necessary as vanilla items don't have any bugs related to this)")
    public List<String> tick_regex = List.of(
        "simplyswords:.*"
    );
}