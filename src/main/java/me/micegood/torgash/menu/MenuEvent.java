package me.micegood.torgash.menu;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;


public class MenuEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event ){
        if (event.getInventory() == SeellerMenu.instance.inventory){
            event.setCancelled(true);

            if (event.getCurrentItem() != null){
                if (event.getCurrentItem().getItemMeta().getPersistentDataContainer().has(
                        NamespacedKey.fromString("price"), PersistentDataType.INTEGER)){
                    int price = event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(
                            NamespacedKey.fromString("price"), PersistentDataType.INTEGER);

                    if (event.getWhoClicked().getInventory().contains(Material.EMERALD, price)){
                        event.getWhoClicked().getInventory().removeItem(new ItemStack(Material.EMERALD, price));
                        event.getWhoClicked().getInventory().addItem(event.getCurrentItem());

                    }
                    else {
                        event.getWhoClicked().sendMessage("Недостаточно изумрудов!");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event){
        if (event.getRightClicked().getName().equals(SeellerMenu.instance.villagerName)){
            event.getPlayer().openInventory(SeellerMenu.instance.inventory);
        }

    }
}
