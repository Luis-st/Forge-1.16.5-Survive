package net.luis.survive.events.world.block.destroy;

import net.luis.survive.Survive;
import net.luis.survive.init.ModEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnExperience {
	
	@SubscribeEvent
	public static void Experience(BlockEvent.BreakEvent event) {
		
		PlayerEntity player = event.getPlayer();

		if (player instanceof PlayerEntity) {
			
			if (event.getExpToDrop() > 0 && !player.abilities.isCreativeMode) {
				
				int xp = event.getExpToDrop();
				int enchExperience = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.EXPERIENCE.get(), player.getHeldItemMainhand());
				int enchFortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItemMainhand());
				int enchDoubleDrop = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.DOUBLE_DROPS.get(), player.getHeldItemMainhand());
				int enchSilkTouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand());
				
				if (enchExperience > 0) {
					
					if (enchSilkTouch == 0) {
						
						event.setExpToDrop((xp * ((enchExperience + 1) * ((enchExperience * 2) + enchFortune))) * (enchDoubleDrop + 1));
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
