package de.fanta.fancyfirework.commands;

import de.fanta.fancyfirework.FancyFirework;
import de.fanta.fancyfirework.fireworks.AbstractFireWork;
import de.fanta.fancyfirework.utils.ChatUtil;
import de.iani.cubesideutils.bukkit.commands.SubCommand;
import de.iani.cubesideutils.commands.ArgsParser;
import net.kyori.adventure.text.TextComponent;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class FireWorkGiveCommand extends SubCommand {

    private final FancyFirework plugin;

    public FireWorkGiveCommand(FancyFirework plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String s1, ArgsParser args) {
        if (!(sender instanceof Player p)) {
            ChatUtil.sendErrorMessage(sender, "Bạn không phải là người chơi");
            return true;
        }

        Player givePlayer = p;
        if (args.hasNext()) {
            String key = args.getNext();
            AbstractFireWork fireWork = plugin.getRegistry().get(NamespacedKey.fromString(key));
            int amount;
            
            if (args.hasNext()) {
                int next = args.getNext(1);
                if (next < 1 || next > 64) {
                    ChatUtil.sendErrorMessage(p, "Số lượng phải từ 1 đến 64.");
                    return true;
                }

                amount = next;

                if (args.hasNext()) {
                    if (!p.hasPermission(FancyFirework.ADMIN_PERMISSION)) {
                        ChatUtil.sendErrorMessage(p, "Bạn không có quyền tặng pháo hoa tới một người chơi khác.");
                        return true;
                    }
                    String giveName = args.getNext();
                    givePlayer = Bukkit.getPlayer(giveName);

                    if (givePlayer == null) {
                        ChatUtil.sendErrorMessage(p, "Người chơi " + giveName + " hiện không trực tuyến.");
                        return true;
                    }
                }
            } else {
                amount = 1;
            }

            if (fireWork != null) {
                Inventory inv = givePlayer.getInventory();
                ItemStack itemStack = fireWork.getItemStack();
                itemStack.setAmount(amount);

                if (inv.firstEmpty() == -1) {
                    ChatUtil.sendErrorMessage(p, "Không thể thêm item vào túi đồ của bạn vì nó đang đầy!");
                } else {
                    givePlayer.getInventory().addItem(itemStack);
                    ChatUtil.sendNormalMessage(givePlayer, amount + "x " + ((TextComponent) itemStack.getItemMeta().displayName()).content() + ChatUtil.GREEN + " đã được thêm vào túi đồ của bạn");
                    
                    if (!p.getUniqueId().equals(givePlayer.getUniqueId()))
                        ChatUtil.sendNormalMessage(p, amount + "x " + ((TextComponent) itemStack.getItemMeta().displayName()).content() + ChatUtil.GREEN + " đã được thêm vào túi đồ của " + givePlayer.getName());
                }
            } else {
                ChatUtil.sendErrorMessage(p, "Pháo hoa " + key + " hiện không khả dụng.");
            }
        } else {
            ChatUtil.sendWarningMessage(p, "/ff give <key> [amount] [player]");
            return true;
        }

        return true;
    }

    @Override
    public ArrayList<String> onTabComplete(CommandSender sender, Command command, String alias, ArgsParser args) {
        if (sender.hasPermission(FancyFirework.MOD_PERMISSION)) {
            int i = args.remaining();

            if (i == 1) {
                ArrayList<String> li = new ArrayList<>();
                plugin.getRegistry().getKeys().forEach((x) -> li.add(x.toString()));
                return li;
            }

            if (sender.hasPermission(FancyFirework.ADMIN_PERMISSION)) {
                if (i == 3) {
                    ArrayList<String> li = new ArrayList<>();
                    Bukkit.getOnlinePlayers().forEach((player) -> li.add(player.getName()));
                    return li;
                }
            }

            return new ArrayList<>();
        }

        return null;
    }

    @Override
    public String getRequiredPermission() {
        return FancyFirework.MOD_PERMISSION;
    }
}
