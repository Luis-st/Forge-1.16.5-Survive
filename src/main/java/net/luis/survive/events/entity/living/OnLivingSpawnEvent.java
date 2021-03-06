package net.luis.survive.events.entity.living;

import net.luis.survive.Survive;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingSpawnEvent {

	@SubscribeEvent
	public static void SpecialSpawn(LivingSpawnEvent.SpecialSpawn event) {
		
		LivingEntity entity = event.getEntityLiving();
		World world = entity.getEntityWorld();
		
		if (entity instanceof BatEntity) {
			
			if (!world.getGameRules().getBoolean(ModGameRule.DO_BAT_SPAWNING.getRule())) {
				
				event.setResult(Result.DENY);
				
			}
			
		}
			
	}
	
	@SubscribeEvent
	public static void CheckSpawn(LivingSpawnEvent.CheckSpawn event) {
		
		LivingEntity entity = event.getEntityLiving();
		World world = entity.getEntityWorld();
		
		if (entity instanceof MonsterEntity) {
			
			if (!world.getGameRules().getBoolean(ModGameRule.DO_MONSTER_SPAWNING.getRule())) {
				
				event.setResult(Result.DENY);
				
			}
			
		}
			
	}

}

