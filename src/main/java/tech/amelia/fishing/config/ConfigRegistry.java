package tech.amelia.fishing.config;

import lombok.Data;
import org.bukkit.plugin.java.JavaPlugin;
import tech.amelia.fishing.AmeliaFishing;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Data
public final class ConfigRegistry {

    private final static Map<String, YMLConfig> CACHED_CONFIGS = new HashMap<>();
    private final JavaPlugin plugin;

    public ConfigRegistry(final JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerConfig(final String name) {

        final File fileToLoad = new File(this.plugin.getDataFolder(), name + ".yml");

        if (!fileToLoad.exists()) this.plugin.saveResource(name + ".yml", true);

        final YMLConfig configuration = YMLConfig.loadConfiguration(new File(this.plugin.getDataFolder(), name + ".yml"));
        ConfigRegistry.CACHED_CONFIGS.put(name, configuration);
    }

    public YMLConfig getConfig(final String file) {
        if (!ConfigRegistry.CACHED_CONFIGS.containsKey(file)) this.registerConfig(file);
        return ConfigRegistry.CACHED_CONFIGS.get(file);
    }
}
