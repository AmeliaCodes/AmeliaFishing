package tech.amelia.fishing.utils;

import org.bukkit.ChatColor;

import java.util.LinkedList;
import java.util.List;

public class ColorUtil {

    public static String colorize(final String line) {
        return ChatColor.translateAlternateColorCodes('&', line);
    }

    public static List<String> colorize(final List<String> list) {

        final List<String> parsed = new LinkedList<>();

        for (final String line : list) {
            parsed.add(colorize(line));
        }

        return parsed;
    }
}
