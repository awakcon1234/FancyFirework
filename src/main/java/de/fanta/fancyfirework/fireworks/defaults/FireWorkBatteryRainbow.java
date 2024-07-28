package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.ColorUtils;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FireWorkBatteryRainbow extends FireWorkBattery {

    private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkBatteryRainbow() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "battery_rainbow"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("a4873b7d-e892-4502-b435-a6090b3d5210"), "Firework Rocket Rainbow",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjU1ZWE0M2U1OTI3ODVkMDE2YWNkZWVhOWE0YTZmOWNmMjJjMjc1M2U2OTU0MDVlOGM4M2QyZTA5ZWJjZjY0NyJ9fX0=");
        
        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public Color randomColor() {
        return ColorUtils.getColor(plugin.getTime(), 0.1);
    }
}
