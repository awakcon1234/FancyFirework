package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FireWorkBatteryRed extends FireWorkBattery {

    // private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkBatteryRed() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "battery_red"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("fd2a127d-f1ff-40b7-a7ab-117d0d81dcc0"), "Firework Rocket Red",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzE1YmJkYTEyZTFiODMyYTZhNmFmODVkODQzOTE1MmQ5MTU3Y2UxMDRlNmE3ZjdiMzZhZWFjY2M4NjM1NDQifX19");

        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public Color randomColor() {
       java.awt.Color color = java.awt.Color.getHSBColor(1f, random.nextFloat(0.5f, 1), random.nextFloat(0.3f, 1));
        return Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }
}
