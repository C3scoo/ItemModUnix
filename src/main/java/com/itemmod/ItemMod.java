package com.itemmod;

import net.fabricmc.api.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemMod implements ModInitializer {
 
    // an instance of our new item
    public static final Item ITEM_UNO = new Item(new FabricItemSettings());
	public static final Block BLOCCO_UNO  = new Block(FabricBlockSettings.create().strength(4.0f));
 
		// inizializzazione registri
    @Override
    public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("itemmod", "item_uno"), ITEM_UNO);
		Registry.register(Registries.ITEM_GROUP, new Identifier("itemmod", "test_group"), ITEM_GROUP);
		Registry.register(Registries.BLOCK, new Identifier("itemmod", "blocco_uno"), BLOCCO_UNO);
		Registry.register(Registries.ITEM, new Identifier("itemmod", "blocco_uno"), new BlockItem(BLOCCO_UNO, new FabricItemSettings()));
    }
	
	// Tab della Mod in gioco
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
	.icon(() -> new ItemStack(ITEM_UNO))
	.displayName(Text.translatable("itemGroup.itemmod"))
        .entries((context, entries) -> {
		entries.add(ITEM_UNO);
		entries.add(BLOCCO_UNO);
	})
	.build();
}