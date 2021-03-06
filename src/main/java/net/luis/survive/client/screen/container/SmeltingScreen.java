package net.luis.survive.client.screen.container;

import net.luis.survive.common.inventory.container.SmeltingContainer;
import net.minecraft.client.gui.recipebook.FurnaceRecipeGui;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SmeltingScreen extends AbstractFurnaceScreen<SmeltingContainer> {
	
	private static final ResourceLocation GUI_TEXTURES = new ResourceLocation("textures/gui/container/furnace.png");

	public SmeltingScreen(SmeltingContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		
		super(screenContainer, new FurnaceRecipeGui(), inv, titleIn, GUI_TEXTURES);
		
	}

}
