package net.luis.survive.core.message.backpack;

import java.util.function.Supplier;

import net.luis.survive.init.capability.BackpackCapability;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BackpackDownToolMessage {

	
	public static void encode(BackpackDownToolMessage message, PacketBuffer buffer) {
		
	}

	
	public static BackpackDownToolMessage decode(PacketBuffer buffer) {
		
		return new BackpackDownToolMessage();
		
	}

	
	public static void handle(BackpackDownToolMessage message, Supplier<Context> networkContext) {
		
		ServerPlayerEntity player = networkContext.get().getSender();
		networkContext.get().enqueueWork(() -> {
			
			IItemHandlerModifiable itemModifiable = player.getCapability(BackpackCapability.BACKPACK, null)
					.orElseThrow(() -> new NullPointerException("The mod Capability<IBackpackItemHandler> is null"));
			ItemStack main = player.getHeldItemMainhand().copy();
			ItemStack down = itemModifiable.getStackInSlot(37).copy();
			
			if (main.getItem() instanceof TieredItem) {
				
				player.setHeldItem(Hand.MAIN_HAND, down);
				itemModifiable.setStackInSlot(37, main);
				
			}
			
		});
		networkContext.get().setPacketHandled(true);
		
	}

}
