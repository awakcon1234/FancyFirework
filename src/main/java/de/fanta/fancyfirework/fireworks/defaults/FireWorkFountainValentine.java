package de.fanta.fancyfirework.fireworks.defaults;

import com.google.common.util.concurrent.AtomicDouble;
import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.particle_effects.ISpawnParticle;
import de.fanta.fancyfirework.particle_effects.ParticleEffect;
import de.fanta.fancyfirework.particle_effects.ShapeHeart;
import de.fanta.fancyfirework.utils.CustomFireworkHeads;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;

public class FireWorkFountainValentine extends FireWorkFountain {

    private static final FancyFirework plugin = FancyFirework.getPlugin();

    public FireWorkFountainValentine() {
        super(new NamespacedKey(FancyFirework.getPlugin(), "fountain_valentine"));
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = CustomFireworkHeads.getCustomTextureHead(UUID.fromString("d844b56b-a11a-4d0b-8710-aea25178d1e"), "Heart Block", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGIyNTA1MjcwOWYyYjVlNTFmODcyYzYwNTdjMjc2NmNjNTMyMDZjMTIzNGI3MWVjYTMzOWIzM2Y1YSJ9fX0=");
        itemStack.setItemMeta(fillItemMeta(itemStack.getItemMeta()));
        return itemStack;
    }

    @Override
    public void onLit(Entity entity, @Nullable Player player) {
        entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_CREEPER_PRIMED, SoundCategory.AMBIENT, 1f, 1f);
        BatteryTask batteryTask = new BatteryTask(player, entity, 20 * 40, 20 * 5, 20, 1);
        
        batteryTask.setSpawnFireworkTask(task -> {
            // entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_GHAST_SCREAM, SoundCategory.AMBIENT, 2f, 1.5f);
            Entity taskEntity = task.getEntity();

            if (taskEntity == null)
                return;

            spawnRandomFirework(taskEntity.getLocation());
        });

        batteryTask.setSpawnFountainTask(task -> {
            // Create fountain
            Fountain fountain = new Fountain(20 * 60, random.nextInt(2, 5));
            fountain.setCreateEffects(() -> {
                // Create next fountain effect/s
                var percentage = random.nextDouble();

                if (percentage > 0.7)
                    entity.getWorld().playSound(entity.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, 1.5f, 0.6f);

                FountainEffect effect = new FountainEffect(random.nextInt(6, 20), random.nextDouble(0.4, 1), random.nextDouble(359), random.nextDouble(6));
                effect.setSpawnParticle(location -> location.getWorld().spawnParticle(Particle.HEART, location, 1));

                return List.of(effect);
            });

            return fountain;
        });

        batteryTask.start();
    }

    @Override
    public void onExplode(Firework firework) {
        Location location = firework.getLocation();
        spawn(location);
        location.getWorld().playSound(location, Sound.ENTITY_FIREWORK_ROCKET_BLAST_FAR, SoundCategory.AMBIENT, 8, 1);
        location.getWorld().playSound(location, Sound.ENTITY_FIREWORK_ROCKET_TWINKLE_FAR, SoundCategory.AMBIENT,8, 1);
    }

    @Override
    protected void spawnRandomFirework(Location location) {
        Random rand = ThreadLocalRandom.current();
        Firework firework = (Firework) location.getWorld().spawnEntity(location.add(0, 1.5, 0), EntityType.FIREWORK_ROCKET);
        firework.setVelocity(new Vector((rand.nextBoolean() ? 1 : -1) * rand.nextDouble(0.02), rand.nextDouble(0.5, 1.5), (rand.nextBoolean() ? 1 : -1) * rand.nextDouble(0.02)));
        FireworkMeta fireworkMeta = firework.getFireworkMeta();
        fireworkMeta.setPower(rand.nextInt(2) + 1);
        firework.setFireworkMeta(fireworkMeta);
        this.applyToEntity(firework);
    }

    @Override
    public Color randomColor() {
        java.awt.Color color = java.awt.Color.getHSBColor(random.nextFloat(0.83f, 1), random.nextFloat(0.8f, 1), random.nextFloat(0.8f, 1));
        return Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }

    public void spawn(Location origin) {
        Color color = randomColor();
        Vector rotation = new Vector(0, random.nextDouble(90), 0);
        ISpawnParticle spawnParticle = location -> location.getWorld().spawnParticle(Particle.DUST, location, 2, 0.2, 0.2, 0.2, 0, new Particle.DustOptions(color, 2), true);

        double maxSize = random.nextDouble(0.15, 0.5);
        AtomicDouble size = new AtomicDouble(0.05);
        AtomicInteger counter = new AtomicInteger();

        plugin.getScheduler().runLocalAtFixedRate(origin, task -> {
            if (counter.getAndIncrement() < 10) {
                double currentSize = size.get();
                if (currentSize < maxSize) {
                    size.getAndAdd(0.07);
                }
                ParticleEffect effect = new ParticleEffect(origin, rotation, new ShapeHeart(currentSize), spawnParticle);
                effect.draw();
            } else {
                task.cancel();
            }
        }, 1, 1);
    }
}
