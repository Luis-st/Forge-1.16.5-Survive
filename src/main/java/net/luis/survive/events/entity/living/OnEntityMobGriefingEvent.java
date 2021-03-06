package net.luis.survive.events.entity.living;

import net.luis.survive.Survive;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityMobGriefingEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEntityMobGriefingEvent {
	
	@SubscribeEvent
	public static void PlayerLeaveWorld(EntityMobGriefingEvent event) {
		
		if (event.getEntity() != null) {
			
			Entity entity = event.getEntity();
			World world = entity.getEntityWorld();
			
			if (entity instanceof EndermanEntity) {
				
				if (world.getGameRules().getBoolean(ModGameRule.DISABLE_ENDERMAN_GRIEFING.getRule())) {
					
					event.setResult(Result.DENY);
					
				}
				
			}
			
			if (entity instanceof CreeperEntity) {
				
				if (world.getGameRules().getBoolean(ModGameRule.DISABLE_CREEPER_GRIEFING.getRule())) {
					
					event.setResult(Result.DENY);
					
				}
				
			}
			
			if (entity instanceof GhastEntity) {
				
				if (world.getGameRules().getBoolean(ModGameRule.DISABLE_GHAST_GRIEFING.getRule())) {
					
					event.setResult(Result.DENY);
					
				}
				
			}
			
		}
		
	}

}