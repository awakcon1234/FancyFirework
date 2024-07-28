package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.ColorUtils;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FireWorkBatteryPride extends FireWorkBattery {

    private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkBatteryPride() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "battery_pride"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("67e8c714-b4f1-4feb-8034-4a693723fdae"), "Easter Egg (rainbow)",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2JlNzU0NTI5N2RmZDYyNjZiYmFhMjA1MTgyNWU4ODc5Y2JmYTQyYzdlN2UyNGU1MDc5NmYyN2NhNmExOCJ9fX0=");
                
        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public Color randomColor() {
        return ColorUtils.getColor(plugin.getTime(), 2);
    }
}
