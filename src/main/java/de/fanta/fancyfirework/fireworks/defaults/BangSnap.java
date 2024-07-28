package de.fanta.fancyfirework.fireworks.defaults;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.fireworks.ItemFireWork;

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

public class BangSnap extends ItemFireWork {

    public BangSnap() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "bang_snap"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack stack = new ItemStack(Material.EGG, 16);
        ItemMeta meta = stack.getItemMeta();

        if (meta != null) {
            meta = fillItemMeta(meta);
            meta.setCustomModelData(1286028928);
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
        world.playSound(loc, Sound.ENTITY_FIREWORK_ROCKET_BLAST, SoundCategory.AMBIENT, 1f, 2f);
        world.spawnParticle(Particle.FLAME, loc, 6, 0, 0, 0, 0.025, null, true);
    }
}
