package net.luis.survive.events.entity.living.combat;

import net.luis.survive.Survive;
import net.luis.survive.init.ModEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEntityAttack {

	@SubscribeEvent
	public static void EntityAttack(LivingAttackEvent event) {
		
		LivingEntity target = event.getEntityLiving();
		Entity entity = event.getSource().getTrueSource();
		World world = target.getEntityWorld();
		
		if (entity instanceof PlayerEntity) {
			
			if (target instanceof LivingEntity) {
				
				PlayerEntity player = (PlayerEntity) entity;
				
				int enchPoison = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.POISON_ASPECT.get(), player.getHeldItemMainhand());
				int enchFrost = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.FROST_ASPECT.get(), player.getHeldItemMainhand());
				int enchThunderbolt = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.THUNDERBOLT.get(), player.getHeldItemMainhand());
				int enchCuresHarming = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.CURSE_OF_HARMING.get(), player.getHeldItemMainhand());
				
				if (enchPoison > 0) {
					
					target.addPotionEffect(new EffectInstance(Effects.POISON, 50 * (enchPoison + 2), (enchPoison + 1)));
					
				}
				
				if (enchFrost > 0) {
					
					target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100 * (enchFrost + 1), 2 + (enchFrost + 1)));
					
				}
				
				if (enchCuresHarming > 0) {
					
					float backAmount = event.getAmount() / 2 + enchCuresHarming;
					player.attackEntityFrom(new DamageSource("curse"), backAmount);
					
				}
				
				if (enchThunderbolt > 0) {
					
					LightningBoltEntity lightning = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
					lightning.setLocationAndAngles(target.getPosX(), target.getPosY(), target.getPosZ(), world.rand.nextFloat() * 360, 0);
					world.addEntity(lightning);
					
					if (!world.isRemote && world.rand.nextInt(10) == 0) {
						
						((ServerWorld) world).func_241113_a_(0, world.rand.nextInt(1000), true, true);
						
					}
					
					player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 30, 4, false, false));
					
				}
				
			}
			
		}

	}

}
