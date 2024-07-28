package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FireWorkFountainBlue extends FireWorkFountain {

    // private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkFountainBlue() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "fountain_blue"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("132a9e10-fca9-4a82-8459-b298b9b283b6"), "Firework Rocket (black / blue)",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2FlMzUyMjM5MmRhYzdlZTRkMTRkNjExYThmYTlhN2VjZDRiNjMzMThlMzMzYjliODNlNzhmMjRmNTlhMDFiIn19fQ==");

        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public Color randomColor() {
        java.awt.Color color = java.awt.Color.getHSBColor(0.66f, random.nextFloat(0.5f, 1), random.nextFloat(0.3f, 1));
        return Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }

}
