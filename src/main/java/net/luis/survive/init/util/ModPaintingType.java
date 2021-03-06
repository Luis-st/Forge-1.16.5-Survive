package net.luis.survive.init.util;

import net.luis.survive.Survive;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPaintingType {

	public static final DeferredRegister<PaintingType> PAINTING_TYPES = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, Survive.MOD_ID);
	
	
	public static final RegistryObject<PaintingType> SCREEN_1X1 = PAINTING_TYPES.register("screen1x1", 
			() -> new PaintingType(16, 16));
	
	public static final RegistryObject<PaintingType> SCREEN_4X3 = PAINTING_TYPES.register("screen4x3", 
			() -> new PaintingType(64, 48));
	
}
