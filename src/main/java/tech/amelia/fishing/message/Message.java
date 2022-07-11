package tech.amelia.fishing.message;

import lombok.Data;
import org.bukkit.entity.Player;
import tech.amelia.fishing.config.Config;
import tech.amelia.fishing.utils.ColorUtil;

import java.util.List;

@Data
public final class Message {

    private final boolean enabled;
    private final List<String> values;

    public Message(final String path) {
        this.enabled = Config.SETTINGS.getConfig().getBoolean(path + ".Enabled");
        this.values = Config.SETTINGS.getConfig().getStringList(path + ".Value");
    }

    public void send(final Player player) {

        if (!this.enabled) return;

        for (String line : ColorUtil.colorize(this.values)) {
            player.sendMessage(line);
        }
    }

}
