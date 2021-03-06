package net.luis.survive.client.screen.container;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.luis.survive.common.inventory.container.ModChestContainer17x8;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ModChestScreen17x8 extends ContainerScreen<ModChestContainer17x8> implements IHasContainer<ModChestContainer17x8> {

	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("survive:textures/gui/container/generic_136.png");

	public ModChestScreen17x8(ModChestContainer17x8 container, PlayerInventory playerInventory, ITextComponent title) {
		
		super(container, playerInventory, title);
		this.passEvents = false;
		this.ySize = 114 + 8 * 18;
		this.titleX = this.xSize - 240;
		this.playerInventoryTitleY = this.ySize - 93;
		
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
		
	}

	@Override
	@SuppressWarnings("deprecation")
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
		int i = (this.width - (this.xSize + 144)) / 2;
		int j = (this.height - this.ySize) / 2;
		AbstractGui.blit(matrixStack, i, j, 0, 0, 320, 168, 512, 512);
		AbstractGui.blit(matrixStack, i, j + 168, 0, 168, 320, 89, 512, 512);
		
	}
	
}
