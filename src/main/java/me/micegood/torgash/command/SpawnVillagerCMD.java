package me.micegood.torgash.command;

import me.micegood.torgash.menu.SeellerMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class SpawnVillagerCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp() && sender instanceof Player){
            Player player = (Player) sender;

            Villager villager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
            villager.setCustomName(SeellerMenu.instance.villagerName);
        }
        return true;
    }
}
