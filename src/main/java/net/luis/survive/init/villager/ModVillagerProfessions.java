package net.luis.survive.init.villager;

import com.google.common.collect.ImmutableSet;

import net.luis.survive.Survive;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModVillagerProfessions {
	
	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Survive.MOD_ID);
	
	
	public static final RegistryObject<VillagerProfession> LUMBERJACK = PROFESSIONS.register("lumberjack", 
			() -> new VillagerProfession("lumberjack", ModPointOfInterestTypes.LUMBERJACK.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> MOB_HUNTER = PROFESSIONS.register("mob_hunter", 
			() -> new VillagerProfession("mob_hunter", ModPointOfInterestTypes.MOB_HUNTER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> MINER = PROFESSIONS.register("miner", 
			() -> new VillagerProfession("miner", ModPointOfInterestTypes.MINER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> ENCHANTER = PROFESSIONS.register("enchanter", 
			() -> new VillagerProfession("enchanter", ModPointOfInterestTypes.ENCHANTER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> BEEKEEPER = PROFESSIONS.register("beekeeper", 
			() -> new VillagerProfession("beekeeper", ModPointOfInterestTypes.BEEKEEPER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> NETHER_TRADER = PROFESSIONS.register("nether_trader", 
			() -> new VillagerProfession("nether_trader", ModPointOfInterestTypes.NETHER_TRADER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> END_TRADER = PROFESSIONS.register("end_trader", 
			() -> new VillagerProfession("end_trader", ModPointOfInterestTypes.END_TRADER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	
}
