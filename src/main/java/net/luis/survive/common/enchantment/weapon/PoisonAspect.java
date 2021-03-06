package net.luis.survive.common.enchantment.weapon;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;

public class PoisonAspect extends Enchantment {

	public PoisonAspect(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 10 + 20 * (enchantmentLevel - 1);
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 50;
		
	}
	
	@Override
	public int getMaxLevel() {

		return 2;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return ench != Enchantments.FIRE_ASPECT;
	}

}
