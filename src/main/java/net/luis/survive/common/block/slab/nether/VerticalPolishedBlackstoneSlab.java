package net.luis.survive.common.block.slab.nether;

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

public class VerticalPolishedBlackstoneSlab extends AbstractVerticalSlab {
	
	public VerticalPolishedBlackstoneSlab() {

		super(AbstractBlock.Properties.from(Blocks.POLISHED_BLACKSTONE_SLAB));
		
	}

	@Override
	@SuppressWarnings("deprecation")
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	
		if (hit.getFace().getOpposite() == state.get(VerticalBlackstoneSlab.FACING)
				&& !state.get(VerticalBlackstoneSlab.FULL)
				&& player.getHeldItem(handIn).getItem() == ModVerticalBlockItems.POLISHED_VERTICAL_BLACKSTONE_SLAB_ITEM.get()) {

			worldIn.setBlockState(pos, state.with(VerticalBlackstoneSlab.FULL, true));

			if (!player.isCreative()) {

				player.getHeldItem(handIn).setCount(player.getHeldItem(handIn).getCount() - 1);

			}

			return ActionResultType.SUCCESS;

		}

		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);

	}
	
}
