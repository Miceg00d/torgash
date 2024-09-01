package me.micegood.torgash.menu;

import me.micegood.torgash.Util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SeellerMenu {

    public static SeellerMenu instance = new SeellerMenu();

     public Inventory inventory = Bukkit.createInventory(null, 36, "Меню");

     public final String villagerName = "ЭСПРЕС ТЕСТ ВОЛОДЯ";

    private List<ItemStack> itemsToSell = Arrays.asList(
            Util.createItemToSell(Material.STONE_PICKAXE, 30),
            Util.createItemToSell(Material.IRON_PICKAXE, 45),
            Util.createItemToSell(Material.DIAMOND_PICKAXE, 75),
            Util.createItemToSell(Material.NETHERITE_PICKAXE, 150),
            Util.createItemToSell(Material.IRON_SWORD, 35),
            Util.createItemToSell(Material.DIAMOND_SWORD, 80),
            Util.createItemToSell(Material.NETHERITE_SWORD, 200)
    );
    private SeellerMenu(){
        for (int i = 0; i < inventory.getSize(); i++){
            if (i < 10 || i > 16){
                inventory.setItem(i, Util.createDecorItem(Material.BLACK_STAINED_GLASS));
            }
            else{
                Random random = new Random();
                ItemStack itemStack = itemsToSell.get(random.nextInt(itemsToSell.size()));
                inventory.setItem(i, itemStack);
            }
        }
    }

}
