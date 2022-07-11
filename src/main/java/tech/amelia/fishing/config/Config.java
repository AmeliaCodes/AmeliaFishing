package tech.amelia.fishing.config;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import tech.amelia.fishing.AmeliaFishing;

@Getter
public enum Config {

    SETTINGS("settings");

    private final AmeliaFishing plugin = new AmeliaFishing().getPlugin();
    private final FileConfiguration config;

    Config(final String path) {
        this.config = this.plugin.getConfigRegistry().getConfig(path);
    }
}
