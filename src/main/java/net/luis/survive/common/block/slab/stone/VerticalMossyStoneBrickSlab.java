package net.luis.survive.common.block.slab.stone;

import net.luis.survive.api.world.block.api.AbstractVerticalSlab;
import net.luis.survive.init.blocks.ModVerticalBlockItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class VerticalMossyStoneBrickSlab extends AbstractVerticalSlab {
	
	public VerticalMossyStoneBrickSlab() {

		super(AbstractBlock.Properties.from(Blocks.MOSSY_STONE_BRICK_SLAB));

	}

	@Override
	@SuppressWarnings("deprecation")
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	
		if (hit.getFace().getOpposite() == state.get(VerticalMossyStoneBrickSlab.FACING)
				&& !state.get(VerticalMossyStoneBrickSlab.FULL)
				&& player.getHeldItem(handIn).getItem() == ModVerticalBlockItems.VERTICAL_MOSSY_STONE_BRICK_SLAB_ITEM.get()) {

			worldIn.setBlockState(pos, state.with(VerticalMossyStoneBrickSlab.FULL, true));

			if (!player.isCreative()) {

				player.getHeldItem(handIn).setCount(player.getHeldItem(handIn).getCount() - 1);

			}

			return ActionResultType.SUCCESS;

		}

		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);

	}
	
}
