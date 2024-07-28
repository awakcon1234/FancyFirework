package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.utils.ChatUtil;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import java.util.UUID;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FireWorkBatteryPurple extends FireWorkBattery {

    private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkBatteryPurple() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "battery_purple"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("6555a80f-7035-4ccb-8270-870380e56cde"), "Firework Rocket Purple",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmExM2M0MDEyZGRlZjRkZDI2MGYzODUyYjFjYmJkYjlhYTU0ZTU4NDJjYzUyNTczNGU3NjdmYWY5ODM0NDc3In19fQ==");
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatUtil.colorize("&fDàn Phun &#ad14ffMàu tím"));
        meta.setLore(FancyFirework.getPlugin().getConfig().getStringList("itemlore"));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    @Override
    public Color randomColor() {
        java.awt.Color color = java.awt.Color.getHSBColor(0.75f, random.nextFloat(0.5f, 1), random.nextFloat(0.5f, 1));
        return Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }
}


