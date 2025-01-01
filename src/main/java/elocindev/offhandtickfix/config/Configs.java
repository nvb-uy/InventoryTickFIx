package elocindev.offhandtickfix.config;

import elocindev.offhandtickfix.config.entries.OffHandTickFixConfig;
import elocindev.necronomicon.api.config.v1.NecConfigAPI;

public class Configs {
    public static OffHandTickFixConfig MAIN = OffHandTickFixConfig.INSTANCE;

    public static void loadCommonConfigs() {
        NecConfigAPI.registerConfig(OffHandTickFixConfig.class);
    }

    public static void loadClientConfigs() {}
}
