
package net.mcreator.ran_dom_things.block;

import net.minecraft.block.material.Material;

@RanDomThingsModElements.ModElement.Tag
public class PebblesBlock extends RanDomThingsModElements.ModElement {

	@ObjectHolder("ran_dom_things:pebbles")
	public static final Block block = null;

	public PebblesBlock(RanDomThingsModElements instance) {
		super(instance, 1);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(DecorItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {

		public static final DirectionProperty FACING = DirectionalBlock.FACING;

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).notSolid()
							.setOpaque((bs, br, bp) -> false));

			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.SOUTH));

			setRegistryName("pebbles");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vector3d offset = state.getOffset(world, pos);
			switch ((Direction) state.get(FACING)) {
				case SOUTH :
				case NORTH :
				default :
					return VoxelShapes.or(makeCuboidShape(0, 0, 0, 16, 4, 16)

					)

							.withOffset(offset.x, offset.y, offset.z);
				case EAST :
				case WEST :
					return VoxelShapes.or(makeCuboidShape(0, 16, 0, 16, 0, 4)

					)

							.withOffset(offset.x, offset.y, offset.z);
				case UP :
				case DOWN :
					return VoxelShapes.or(makeCuboidShape(0, 16, 16, 4, 0, 0)

					)

							.withOffset(offset.x, offset.y, offset.z);
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		@Override
		public BlockState rotate(BlockState state, Rotation rot) {
			if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
				if ((Direction) state.get(FACING) == Direction.WEST || (Direction) state.get(FACING) == Direction.EAST) {
					return state.with(FACING, Direction.UP);
				} else if ((Direction) state.get(FACING) == Direction.UP || (Direction) state.get(FACING) == Direction.DOWN) {
					return state.with(FACING, Direction.WEST);
				}
			}
			return state;
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			Direction facing = context.getFace();
			if (facing == Direction.WEST || facing == Direction.EAST)
				facing = Direction.UP;
			else if (facing == Direction.NORTH || facing == Direction.SOUTH)
				facing = Direction.EAST;
			else
				facing = Direction.SOUTH;;
			return this.getDefaultState().with(FACING, facing);
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
