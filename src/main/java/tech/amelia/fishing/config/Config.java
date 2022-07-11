package tech.amelia.fishing.config;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import tech.amelia.fishing.AmeliaFishing;

@Getter
public enum Config {

    SETTINGS("settings");

    private final FileConfiguration config;

    Config(final String path) {
        this.config = AmeliaFishing.PLUGIN.getConfigRegistry().getConfig(path);
    }
}
