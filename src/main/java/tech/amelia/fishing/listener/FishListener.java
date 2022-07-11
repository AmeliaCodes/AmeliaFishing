package tech.amelia.fishing.listener;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import tech.amelia.fishing.AmeliaFishing;
import tech.amelia.fishing.config.Config;
import tech.amelia.fishing.events.CustomFishEvent;
import tech.amelia.fishing.reward.FishingReward;
import tech.amelia.fishing.reward.manager.RewardManager;

public final class FishListener implements Listener {

    private static final double CHANCE = Config.SETTINGS.getConfig().getDouble("Reward-Chance");
    private static final String PERMISSION = Config.SETTINGS.getConfig().getString("Permissions.Admin-Permission");

    private final AmeliaFishing plugin;
    private final RewardManager manager;

    public FishListener(final AmeliaFishing plugin) {
        this.plugin = plugin;
        this.manager = plugin.getRewardManager();

        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onFish(final PlayerFishEvent event) {

        final Player player = event.getPlayer();
        final double value = Math.random() * 100;

        if (event.getState() != PlayerFishEvent.State.BITE) return;
        if (!player.hasPermission(FishListener.PERMISSION)) return;
        if (value > FishListener.CHANCE) return;

        final FishingReward reward = this.manager.pickReward();
        final CustomFishEvent customEvent = new CustomFishEvent(reward);

        this.plugin.getServer().getPluginManager().callEvent(customEvent);

        if (customEvent.isCancelled()) return;

        reward.execute(player);
    }
}
