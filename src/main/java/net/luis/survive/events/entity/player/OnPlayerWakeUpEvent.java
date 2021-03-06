package net.luis.survive.events.entity.player;

import net.luis.survive.Survive;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnPlayerWakeUpEvent {
	
	@SubscribeEvent
	public static void PlayerWakeUp(PlayerWakeUpEvent event) {
		
		PlayerEntity player = event.getPlayer();
		World world = player.getEntityWorld();
		
		if (!world.isRemote) {
			
			ServerWorld serverWorld = (ServerWorld) world;
			
			if (serverWorld.isThundering() || serverWorld.isRaining()) {
				
				serverWorld.func_241113_a_(0, 0, false, false);
				
			}
			
		}
		
	}
	
}
