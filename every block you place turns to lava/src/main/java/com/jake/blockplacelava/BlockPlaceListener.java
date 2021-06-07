package com.jake.blockplacelava;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (Blockplacelava.isStarted) {
            if (!(e.getBlock().getType() == Material.CRAFTING_TABLE || e.getBlock().getType() == Material.FURNACE || e.getBlock().getType() == Material.BLAST_FURNACE || e.getBlock().getType() == Material.SMOKER || e.getBlock().getType() == Material.BREWING_STAND || e.getBlock().getType() == Material.SMITHING_TABLE)) {
                e.getBlockPlaced().setType(Material.LAVA);
            }
        }
    }
}
