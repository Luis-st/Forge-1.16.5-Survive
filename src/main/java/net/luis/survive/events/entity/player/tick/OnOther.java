package net.luis.survive.events.entity.player.tick;

import net.luis.survive.Survive;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnOther {

	@SubscribeEvent
	public static void PlayerTick(TickEvent.PlayerTickEvent event) {

		PlayerEntity player = event.player;
		World world = player.getEntityWorld();
		
		if (event.side.isServer() && event.phase == TickEvent.Phase.START) {
			
			if (world.getGameRules().getBoolean(ModGameRule.DISABLE_HUNGER.getRule())) {
				
				FoodStats foodStats = player.getFoodStats();
				foodStats.setFoodLevel(Math.min(foodStats.getFoodLevel() + 1, 20));
				
				if (!foodStats.needFood() && !player.shouldHeal() && foodStats.getSaturationLevel() == 0.0f) {
					
					foodStats.setFoodSaturationLevel(1.0f);
					
				}
				
			}
			
		}
		
	}
	
}
