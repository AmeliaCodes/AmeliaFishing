package tech.amelia.fishing.config;

import java.io.File;

import lombok.SneakyThrows;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public final class YMLConfig extends YamlConfiguration {

    private final File file;

    public YMLConfig(final File file) {
        this.file = file;
    }

    @SneakyThrows
    public static YMLConfig loadConfiguration(final File file) {

        final YMLConfig config = new YMLConfig(file);
        config.load(file);
        return config;
    }

    @SneakyThrows
    public void save() {
        save(this.file);
    }

    public ConfigurationSection getConfigurationSection(final String path) {
        return super.getConfigurationSection(path);
    }
}