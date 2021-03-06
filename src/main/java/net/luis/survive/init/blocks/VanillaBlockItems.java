package net.luis.survive.init.blocks;

import net.luis.survive.Survive;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VanillaBlockItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Survive.MINECRAFT_ID);

	
	public static final RegistryObject<Item> BARREL_ITEM = ITEMS.register("barrel", 
			() -> new BlockItem(VanillaBlocks.BARREL.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> ENCHANTING_TABLE_ITEM = ITEMS.register("enchanting_table", 
			() -> new BlockItem(VanillaBlocks.ENCHANTING_TABLE.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> BEACON_ITEM = ITEMS.register("beacon", 
			() -> new BlockItem(VanillaBlocks.BEACON.get(), new Item.Properties().group(ItemGroup.MISC)));

}
