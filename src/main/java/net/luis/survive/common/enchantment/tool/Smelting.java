package net.luis.survive.common.enchantment.tool;

import net.luis.survive.init.ModEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;

public class Smelting extends Enchantment {

	public Smelting(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 20;
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return 50;
		
	}
	
	@Override
	public int getMaxLevel() {

		return 1;
		
	}
	
	@Override
	public boolean isTreasureEnchantment() {
		
		return true;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		if (ench != Enchantments.SILK_TOUCH)
			return true;
		if (ench != ModEnchantment.DOUBLE_DROPS.get())
			return true;
		if (ench != ModEnchantment.BLASTING.get())
			return true;
		return false;
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		if (stack.getItem() instanceof HoeItem)
			return false;
		return super.canApply(stack);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() instanceof HoeItem)
			return false;
		return super.canApplyAtEnchantingTable(stack);
	}

}
