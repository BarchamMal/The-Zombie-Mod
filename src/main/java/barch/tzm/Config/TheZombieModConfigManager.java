package barch.tzm.Config;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.api.SyntaxError;
import net.fabricmc.api.ModInitializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TheZombieModConfigManager implements ModInitializer {
    private static final Jankson jankson = Jankson.builder().build();
    private static TheZombieModConfig config;
    private static final File configFile = new File("config/tzmconfig.cfg");

    @Override
    public void onInitialize() {
        loadConfig();
    }

    public static TheZombieModConfig getConfig() {
        return config;
    }

    public static void loadConfig() {
        if (!configFile.exists()) {
            config = new TheZombieModConfig();
            saveConfig();
        } else {
            try {
                config = jankson.fromJson(jankson.load(configFile), TheZombieModConfig.class);
            } catch (IOException | SyntaxError e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveConfig() {
        try (FileWriter writer = new FileWriter(configFile)) {
            writer.write(jankson.toJson(config).toJson(true, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}