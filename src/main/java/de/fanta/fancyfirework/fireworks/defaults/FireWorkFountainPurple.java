package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FireWorkFountainPurple extends FireWorkFountain {

    // private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkFountainPurple() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "fountain_purple"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("ee74c23b-b797-4642-b8e1-8a059d93a064"), "Firework Rocket (black / purple)",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzQ2ZmQ3NTcwOTRlZTJkZmUyMmNjNjI2MzE4ZWRlNjc5MzY0ZTMzZjZjZjZmZTNmZjFmNTJkMDQ1ZjQifX19");

        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public Color randomColor() {
        java.awt.Color color = java.awt.Color.getHSBColor(0.75f, random.nextFloat(0.5f, 1), random.nextFloat(0.5f, 1));
        return Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }
}
