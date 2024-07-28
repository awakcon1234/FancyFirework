package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FireWorkBatteryYellow extends FireWorkBattery {

    // private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkBatteryYellow() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "battery_yellow"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("c187fe06-c1e4-48f4-ae53-4abb6002c134"), "Firework Rocket Yellow", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmQ1NmE1NmFiYWZjYzlkNzk1NzNjZjI4MWQ1MTk0MDczNzFlOWQ0NDkyOTRmNjhhM2Q5MTliOTZjNzVhMyJ9fX0=");
        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public Color randomColor() {
        java.awt.Color color = java.awt.Color.getHSBColor(0.166f, random.nextFloat(0.8f, 1), random.nextFloat(0.3f, 1));
        return Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }
}
