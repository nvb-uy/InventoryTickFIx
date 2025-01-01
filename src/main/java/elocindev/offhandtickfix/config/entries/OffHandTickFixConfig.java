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

    @Comment("These items will not tick when they're in the off hand (Vanilla behavior) Supports regex by default!")
    @Comment("Examples: minecraft:diamond_sword (Blacklisting a diamond sword) | minecraft:.*_sword (Blacklisting all swords)")
    @Comment(" ")
    @Comment("Note: This is a blacklist, it's intended that you only add items that already do a workaround around this to avoid them ticking twice.")
    public List<String> tick_blacklist_regex = List.of(
        "examplemod:example_item",
        "examplemod:another_example_item"
    );

    @Comment("When enabled, it will disable tick_blacklist_regex and instead the mod will only tick items in the tick_regex config.")
    public boolean enable_inverted_logic = false;
    @Comment("If you want the mod to only fix certain items, you can use this config, just make sure that enable_inverted_logic is set to true.")
    @Comment("WANING: DISABLES THE BLACKLIST AND ONLY TICKS ITEMS THAT MATCH THE REGEX")
    public List<String> tick_regex = List.of(
        ".*"
    );
}