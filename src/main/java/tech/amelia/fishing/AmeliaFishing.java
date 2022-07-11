package tech.amelia.fishing;

import lombok.Data;
import org.bukkit.plugin.java.JavaPlugin;
import tech.amelia.fishing.config.ConfigRegistry;
import tech.amelia.fishing.listener.FishListener;
import tech.amelia.fishing.reward.manager.RewardManager;

@Data
public final class AmeliaFishing extends JavaPlugin {

    public static AmeliaFishing PLUGIN;
    private ConfigRegistry<AmeliaFishing> configRegistry;
    private RewardManager rewardManager;

    @Override
    public void onEnable() {
        AmeliaFishing.PLUGIN = this;

        this.loadConfiguration();
        this.loadRewards();
        this.loadListeners();
    }

    private void loadConfiguration() {
        this.configRegistry = new ConfigRegistry<>(this);

        this.configRegistry.registerConfig("settings");
    }

    private void loadRewards() {
        this.rewardManager = new RewardManager();
    }

    private void loadListeners() {
        new FishListener(this);
    }
}
