package tech.amelia.fishing.reward;

import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import tech.amelia.fishing.config.Config;
import tech.amelia.fishing.message.Message;

import java.util.LinkedList;
import java.util.List;

@Data
public final class FishingReward {

    private final String identifier;
    private final double chance;
    private final List<String> commands;
    private final Message message;

    public FishingReward(final String identifier, final double chance, final Message message) {
        this.identifier = identifier;
        this.chance = chance;
        this.commands = new LinkedList<>();
        this.message = message;
    }

    public FishingReward(final String identifier) {
        this.identifier = identifier;
        this.chance = Config.SETTINGS.getConfig().getDouble("Rewards." + identifier + ".Chance");
        this.commands = Config.SETTINGS.getConfig().getStringList("Rewards." + identifier + ".Commands");
        this.message = new Message("Rewards." + identifier + ".Message");
    }

    public void execute(final Player player) {

        for (final String command : this.commands) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", player.getName()));
        }

        message.send(player);
    }
}
