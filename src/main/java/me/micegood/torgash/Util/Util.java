package me.micegood.torgash.Util;


import org.bukkit.Material;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class Util {

    public static ItemStack createDecorItem(Material material) {
        ItemStack itemStack = new ItemStack(material);

        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName("  ");

        itemStack.setItemMeta(meta);

        return itemStack;



    }

    public static ItemStack createItemToSell(Material material, int price){
        ItemStack itemStack = new ItemStack(material);

        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(Arrays.asList("Цена: " + price + " \uD83C\uDF40"));
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("price"), PersistentDataType.INTEGER, price);

        itemStack.setItemMeta(meta);

        return itemStack;

    }
}
