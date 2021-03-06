package net.luis.survive.events.entity.living;

import net.luis.survive.Survive;
import net.luis.survive.api.entity.EntityManager;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEnderTeleportEvent {

	@SubscribeEvent
	public static void EnderTeleport(EnderTeleportEvent event) {
		
		LivingEntity entity = event.getEntityLiving();
		World world = entity.getEntityWorld();
		
		if (entity instanceof PlayerEntity) {
			
			if (!world.getGameRules().getBoolean(ModGameRule.DO_ENDERPEARL_DAMAGE.getRule())) {
				
				event.setAttackDamage(0.0f);
				
			}
			
		}
		
		if (entity instanceof EndermanEntity) {
			
			if (world.getGameRules().getBoolean(ModGameRule.DISABLE_ENDERMAN_TELEPORT.getRule())) {
				
				event.setCanceled(true);
				
			}

			if (world.getGameRules().getBoolean(ModGameRule.DISABLE_ENDERMAN_ATTACK_TELEPORT.getRule())) {
				
				event.setCanceled(EntityManager.hasMaxHealth(entity));
				
			}
			
		}
		
		if (entity instanceof ShulkerEntity) {
			
			if (world.getGameRules().getBoolean(ModGameRule.DISABLE_SHULKER_TELEPORT.getRule())) {
				
				event.setCanceled(true);
				
			}

			if (world.getGameRules().getBoolean(ModGameRule.DISABLE_SHULKER_ATTACK_TELEPORT.getRule())) {
				
				event.setCanceled(EntityManager.hasMaxHealth(entity));
				
			}
			
		}

	}
	
}

