package de.fanta.fancyfirework;

import com.google.common.base.Preconditions;
import de.fanta.fancyfirework.fireworks.AbstractFireWork;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class FireWorksRegistry {

    private final Map<NamespacedKey, AbstractFireWork> fireWorkMap;
    private final Map<NamespacedKey, AbstractFireWork> valentineFireWorkMap;
    private final Map<NamespacedKey, AbstractFireWork> halloweenFireWorkMap;

    // private final FancyFirework plugin;

    FireWorksRegistry(FancyFirework plugin) {
        this.fireWorkMap = new HashMap<>();
        this.valentineFireWorkMap = new HashMap<>();
        this.halloweenFireWorkMap = new HashMap<>();
        // this.plugin = plugin;
    }

    public void register(AbstractFireWork fireWork) {
        Preconditions.checkArgument(fireWork != null, "Không thể đăng ký một pháo hoa trống được!");
        NamespacedKey key = fireWork.getKey();
        Preconditions.checkArgument(!fireWorkMap.containsKey(key), "Một pháo hoa với khóa " + key + " đã được đăng ký sẵn rồi!");
        fireWorkMap.put(key, fireWork);

        if (key.toString().contains("valentine"))
            valentineFireWorkMap.put(key, fireWork);

        if (key.toString().contains("halloween") || key.toString().contains("spooky"))
            halloweenFireWorkMap.put(key, fireWork);
    }

    public void clearAllFirework() {
        this.fireWorkMap.clear();
        this.valentineFireWorkMap.clear();
        this.halloweenFireWorkMap.clear();
    }

    public AbstractFireWork get(NamespacedKey key) {
        return fireWorkMap.get(key);
    }

    public AbstractFireWork getByItemStack(ItemStack itemStack) {
        if (itemStack != null && !itemStack.getType().isAir()) {
            ItemMeta meta = itemStack.getItemMeta();
            if (meta != null) {
                String keyString = meta.getPersistentDataContainer().get(AbstractFireWork.FIREWORK_ID, PersistentDataType.STRING);
                if (keyString != null) {
                    return get(NamespacedKey.fromString(keyString));
                }
            }
        }
        return null;
    }

    public AbstractFireWork getByEntity(Entity entity) {
        String keyString = entity.getPersistentDataContainer().get(AbstractFireWork.FIREWORK_ID, PersistentDataType.STRING);
        
        if (keyString != null)
            return get(NamespacedKey.fromString(keyString));

        return null;
    }

    public List<NamespacedKey> getKeys() {
        return List.copyOf(fireWorkMap.keySet());
    }

    public ItemStack getRandomFireWorkItem() {
        Random rand = new Random();
        NamespacedKey randomkey = getKeys().get(rand.nextInt(getKeys().size()));
        AbstractFireWork fireWork = get(randomkey);
        assert fireWork != null;
        return fireWork.getItemStack().clone();
    }

    public ItemStack getRandomValentineFireWorkItem() {
        Random rand = new Random();
        List<NamespacedKey> list = List.copyOf(valentineFireWorkMap.keySet());
        NamespacedKey randomkey = list.get(rand.nextInt(list.size()));
        AbstractFireWork fireWork = get(randomkey);
        assert fireWork != null;
        return fireWork.getItemStack().clone();
    }

    public ItemStack getRandomHalloweenFireWorkItem() {
        Random rand = new Random();
        List<NamespacedKey> list = List.copyOf(halloweenFireWorkMap.keySet());
        NamespacedKey randomkey = list.get(rand.nextInt(list.size()));
        AbstractFireWork fireWork = get(randomkey);
        assert fireWork != null;
        return fireWork.getItemStack().clone();
    }
}
