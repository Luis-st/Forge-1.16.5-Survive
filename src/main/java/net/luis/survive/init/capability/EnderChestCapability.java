package net.luis.survive.init.capability;

import java.util.concurrent.Callable;

import net.luis.survive.api.capability.IEnderChestItemHandler;
import net.luis.survive.api.capability.EnderChestItemStackHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.items.wrapper.InvWrapper;

public class EnderChestCapability {
	
	@CapabilityInject(IEnderChestItemHandler.class)
	public static Capability<IItemHandlerModifiable> ENDERCHEST = null;
	
	public static class EnderChestStorage implements IStorage<IEnderChestItemHandler> {
		@Override
		public INBT writeNBT(Capability<IEnderChestItemHandler> capability, IEnderChestItemHandler instance, Direction side) {
			return null;
		}
		@Override
		public void readNBT(Capability<IEnderChestItemHandler> capability, IEnderChestItemHandler instance, Direction side, INBT nbt) {
		}
	}
	
	public static class EnderChestFactory implements Callable<IEnderChestItemHandler> {
		@Override
		public IEnderChestItemHandler call() throws Exception {
			return null;
		}
	}
	
	public static class EnderChestProvider implements ICapabilitySerializable<CompoundNBT> {
		
		private EnderChestItemStackHandler inventory = new EnderChestItemStackHandler(27);
		private PlayerEntity player;
		private LazyOptional<EnderChestItemStackHandler> enderChestHandler = LazyOptional.of(() -> inventory);
		private LazyOptional<CombinedInvWrapper> combinedInventory = LazyOptional.of(() -> {
			
			EnderChestInventory enderChestInventory = player.getInventoryEnderChest();
			InvWrapper invWrapper = new InvWrapper(enderChestInventory);
			CombinedInvWrapper combinedInvWrapper = new CombinedInvWrapper(invWrapper, inventory);
			
			return combinedInvWrapper;
			
		});
		
		public EnderChestProvider(PlayerEntity playerIn) {
			
			this.player = playerIn;
			
		}
		
		@Override
		@SuppressWarnings({ "unchecked" })
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			LazyOptional<?> ret = side == null ? combinedInventory : enderChestHandler;
			return cap == ENDERCHEST ? (LazyOptional<T>) ret : LazyOptional.empty();
			
		}

		@Override
		public CompoundNBT serializeNBT() {
			
			return inventory.serializeNBT();
			
		}

		@Override
		public void deserializeNBT(CompoundNBT nbt) {
			
			inventory.deserializeNBT(nbt);
			
		}
		
	}
	
}
