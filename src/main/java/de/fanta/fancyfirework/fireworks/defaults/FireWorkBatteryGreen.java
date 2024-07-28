package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.ChatUtil;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public class FireWorkBatteryGreen extends FireWorkBattery {

    private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkBatteryGreen() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "battery_green"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("88625629-4201-4397-bfcf-d19cbc7a2026"), "Firework Rocket Lime",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGU1ODg1N2I5ZmJiMTkyYjcxNmU0MzM2OGU1NjhjOTRmYjZiYzE5MTM4NGIxYzQ0ZGViNzVlYTQ2ZTE0MyJ9fX0=");
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatUtil.colorize("&fDàn phun &aXanh lá"));
        meta.setLore(FancyFirework.getPlugin().getConfig().getStringList("itemlore"));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    @Override
    public Color randomColor() {
        int red = (int) (Math.random() * 20);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 30);
        return Color.fromRGB(red, green, blue);
    }
}

