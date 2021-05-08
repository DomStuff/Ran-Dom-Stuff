
package net.mcreator.ran_dom_things.itemgroup;

@RanDomThingsModElements.ModElement.Tag
public class DecorItemGroup extends RanDomThingsModElements.ModElement {

	public DecorItemGroup(RanDomThingsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdecor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.POTTED_CACTUS, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
