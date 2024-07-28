package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.fireworks.ItemFireWork;
import de.fanta.fancyfirework.utils.ColorUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SmokeBombColor extends ItemFireWork {

    private static final FancyFirework plugin = FancyFirework.getPlugin();

    public SmokeBombColor() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "smoke_bomb_color"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack stack = new ItemStack(Material.EGG, 16);
        ItemMeta meta = stack.getItemMeta();

        if (meta != null) {
            meta = fillItemMeta(meta);
            meta.setCustomModelData(547855441);
            stack.setItemMeta(meta);
        }

        return stack;
    }

    @Override
    public void onLaunch(Player player, Projectile entity) {

    }

    @Override
    public void onHit(Player player, ProjectileHitEvent event) {
        Location loc = event.getEntity().getLocation();
        World world = loc.getWorld();
        world.playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, SoundCategory.AMBIENT, 2f, 1f);
        world.spawnParticle(Particle.DUST, loc, 150, 1, 1.5, 1, 0.008, new Particle.DustOptions(ColorUtils.getColor(plugin.getTime(), 2), 2.5f), true);
        world.spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, loc, 250, 0.5, 1.5, 0.5, 0.005, null, true);
    }
}
