
package net.mcreator.ran_dom_things.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.ran_dom_things.procedures.TotemWarmthTickProcedure;
import net.mcreator.ran_dom_things.RanDomThingsModElements;

import java.util.Map;
import java.util.HashMap;

@RanDomThingsModElements.ModElement.Tag
public class TotemOfWarmthItem extends RanDomThingsModElements.ModElement {
	@ObjectHolder("ran_dom_things:totem_of_warmth")
	public static final Item block = null;
	public TotemOfWarmthItem(RanDomThingsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxDamage(360).isImmuneToFire().rarity(Rarity.UNCOMMON));
			setRegistryName("totem_of_warmth");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (selected) {
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				TotemWarmthTickProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
