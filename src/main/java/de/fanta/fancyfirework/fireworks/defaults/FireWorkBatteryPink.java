package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FireWorkBatteryPink extends FireWorkBattery {

    // private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkBatteryPink() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "battery_pink"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("e0074ce5-decd-4c73-9376-8616adcb84b8"), "Firework Rocket Pink",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjlkNzNmYWMwZGI3YmI3YmQ4OTJhODdiZDQ0NzA4N2Q2YTQyOWMwODA4Mjg5MTg5YmM0NWNjZDk4YTNmYTFhIn19fQ==");
                
        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public Color randomColor() {
        java.awt.Color color = java.awt.Color.getHSBColor(0.83f, random.nextFloat(0.5f, 1), random.nextFloat(0.5f, 1));
        return Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }
}
