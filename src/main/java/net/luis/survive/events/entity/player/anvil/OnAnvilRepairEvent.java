package net.luis.survive.events.entity.player.anvil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.luis.survive.Survive;
import net.luis.survive.api.enchantment.EnchantmentManager;
import net.luis.survive.init.blocks.ModBlocks;
import net.luis.survive.init.util.ModGameRule;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;

@Mod.EventBusSubscriber(modid=Survive.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnAnvilRepairEvent {

	@SubscribeEvent
	public static void AnvilRepair(AnvilRepairEvent event) {
		
		ItemStack inputLeft = event.getItemInput();
		ItemStack inputRight = event.getIngredientInput();
		ItemStack output = event.getItemResult();
		PlayerEntity player = event.getPlayer();
		World world = player.getEntityWorld();
		BlockPos pos = new BlockPos(player.getLookVec());
		
		if (world.getBlockState(pos).getBlock() == ModBlocks.INFINITE_ANVIL.get()) {
			
			event.setBreakChance(0f);
			
		} else {
			
			event.setBreakChance(0.06f);
			
		}
		
		if (world.getGameRules().getBoolean(ModGameRule.ENABLE_ENCHANTMENT_TRANSFER.getRule())) {
			
			if (EnchantmentManager.enchantmentTransferCase1(inputLeft, inputRight)) {
				
				handelCase(event, player, inputLeft, inputRight, output);
				
			} else if (EnchantmentManager.enchantmentTransferCase2(inputLeft, inputRight)) {
				
				handelCase(event, player, inputLeft, inputRight, output);
				
			}
			
		}
		
		output.setRepairCost(output.getRepairCost() / 2);
		
	}
	
	private static void handelCase(AnvilRepairEvent event, PlayerEntity player, ItemStack inputLeft, ItemStack inputRight, ItemStack output) {
		
		ItemStack inputBack = inputLeft.copy();
		Map<Enchantment, Integer> enchantmentsInput = EnchantmentHelper.getEnchantments(inputLeft);
		Map<Enchantment, Integer> enchantmentsOutput = EnchantmentHelper.getEnchantments(output);
		
		List<Enchantment> enchantmenList = new ArrayList<Enchantment>(enchantmentsOutput.keySet());
		
		if (!enchantmenList.isEmpty()) {
			
			Enchantment Ench = enchantmenList.get(0);
			
			if (enchantmentsOutput.size() >= 1) {
				
				enchantmentsInput.remove(Ench);
				EnchantmentHelper.setEnchantments(enchantmentsInput, inputBack);
				inputBack.setRepairCost(0);
				ItemHandlerHelper.giveItemToPlayer(player, inputBack);
				
			} else {
				
				ItemHandlerHelper.giveItemToPlayer(player, inputBack);
				
			}
			
		} else {
			
			ItemHandlerHelper.giveItemToPlayer(player, inputBack);
			
		}
		
	}

}
