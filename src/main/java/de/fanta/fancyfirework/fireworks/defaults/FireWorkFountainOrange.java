package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FireWorkFountainOrange extends FireWorkFountain {

    // private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkFountainOrange() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "fountain_orange"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("24f265b4-119d-4a1e-a72c-01e34150bf44"), "Firework Rocket (black / orange)",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzVmZDRhMmI0NzY4NmRhZTgyYTNiZWVlOTRhMzI1NGFjYTJlODQyMzdmZGY2ZjgyMDQzZTU3YWE3OGMzYzYyIn19fQ==");

        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public Color randomColor() {
        java.awt.Color color = java.awt.Color.getHSBColor(0.07f, random.nextFloat(0.5f, 1), random.nextFloat(0.5f, 1));
        return Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }
}
