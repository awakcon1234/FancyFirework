package de.fanta.fancyfirework.utils;

import de.fanta.fancyfirework.FancyFirework;
import de.iani.cubesideutils.bukkit.ChatUtilBukkit;
import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtil {
    protected static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");
    protected static final char COLOR_CHAR = ChatColor.COLOR_CHAR;

    public static final ChatColor GREEN = ChatColor.of("#52ff9d");
    public static final ChatColor ORANGE = ChatColor.of("#ffac4d");
    public static final ChatColor RED = ChatColor.of("#ff6b6b");
    public static final ChatColor BLUE = ChatColor.of("#87f7ea");

    private ChatUtil() {
        // prevent instances
    }

    public static String colorize(String message) {
        message = translateColors(message);
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String translateColors(String message) {
        Matcher matcher = HEX_PATTERN.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);

        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x"
                + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1)
                + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3)
                + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5)
            );
        }

        return matcher.appendTail(buffer).toString();
    }

    public static void sendMessage(CommandSender sender, String colors, Object... messageParts) {
        ChatUtilBukkit.sendMessage(sender, FancyFirework.PREFIX, colors, messageParts);
    }

    public static void sendNormalMessage(CommandSender sender, Object... messageParts) {
        sendMessage(sender, GREEN.toString(), messageParts);
    }

    public static void sendWarningMessage(CommandSender sender, Object... messageParts) {
        sendMessage(sender, ORANGE.toString(), messageParts);
    }

    public static void sendErrorMessage(CommandSender sender, Object... messageParts) {
        sendMessage(sender, RED.toString(), messageParts);
    }

    public static void sendDebugMessage(CommandSender sender, Object... messageParts) {
        if (sender.hasPermission("fanta.debug")) {
            if (sender != null) {
                sendMessage(sender, ChatColor.of("#FF04F7").toString(), messageParts);
            }
        }
    }

    public static void sendBrodcastMessage(Object... messageParts) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            sendMessage(player, GREEN.toString(), messageParts);
        }
    }
}
