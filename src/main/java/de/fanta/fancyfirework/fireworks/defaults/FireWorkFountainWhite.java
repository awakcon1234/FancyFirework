package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FireWorkFountainWhite extends FireWorkFountain {

    // private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkFountainWhite() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "fountain_white"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("1fe10433-a49e-4607-8ca3-8021e93a72c2"), "Firework Rocket (black / white)",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWNkZGJkMzMxYmQzOTdhMmVhZTFlOGEwZDg2NTEwMjAzY2MyZmJhNzJjZjc2NTIwZjA5ZjVjMjQ0MjVkMTcifX19");

        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public Color randomColor() {
        int value = random.nextInt(220 ,255);
        return Color.fromRGB(value, value, value);
    }
}
