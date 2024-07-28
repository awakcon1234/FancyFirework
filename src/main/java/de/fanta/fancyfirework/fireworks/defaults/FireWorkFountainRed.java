package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FireWorkFountainRed extends FireWorkFountain {

    // private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkFountainRed() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "fountain_red"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("7880715e-910e-4d5e-b582-e523f49d8b0b"), "Firework Rocket (black / red)",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY0MTM2MjBmYWNjMmE3MWYxMzc2ZGE4ZTk4MzkwMjlkNjM5YjQ3ZTgyZTA1ZjZiZWM5NjJkNmNkNzZjY2Q5In19fQ==");

        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public Color randomColor() {
        java.awt.Color color = java.awt.Color.getHSBColor(1f, random.nextFloat(0.5f, 1), random.nextFloat(0.3f, 1));
        return Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }
}
