package net.luis.survive.common.inventory.container;

import net.luis.survive.init.recipe.ModRecipeType;
import net.luis.survive.init.util.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;

public class SmeltingContainer extends AbstractFurnaceContainer {
	
	public SmeltingContainer(int id, PlayerInventory playerInventory, IInventory inventory, IIntArray array) {
		
		super(ModContainerType.SMELTING.get(), ModRecipeType.SMELTING, RecipeBookCategory.FURNACE, id, playerInventory, inventory, array);
		
	}
	
	public SmeltingContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		
		super(ModContainerType.SMELTING.get(), ModRecipeType.SMELTING, RecipeBookCategory.FURNACE, id, playerInventory);
		
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}

}
