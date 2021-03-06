package net.luis.survive.events.world.block;

import net.luis.survive.Survive;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnCreateFluidSourceEvent {
	
	@SubscribeEvent
	public static void CreateFluidSource(BlockEvent.CreateFluidSourceEvent event) {
		
		BlockState state = event.getState();
		World world = (World) event.getWorld();
		
		if (state.getBlock() == Blocks.LAVA) {
			
			if (world.getDimensionType().isUltrawarm()) {
				
				event.setResult(Result.ALLOW);
				
			}
			
			if (world.getGameRules().getBoolean(ModGameRule.ENABLE_LAVA_FLUID_SOURCE.getRule())) {
				
				event.setResult(Result.ALLOW);
				
			}
			
		}
		
	}
	
}

