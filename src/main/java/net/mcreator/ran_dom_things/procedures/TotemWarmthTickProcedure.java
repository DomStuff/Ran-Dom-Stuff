package net.mcreator.ran_dom_things.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.ran_dom_things.RanDomThingsModElements;
import net.mcreator.ran_dom_things.RanDomThingsMod;

import java.util.Random;
import java.util.Map;

@RanDomThingsModElements.ModElement.Tag
public class TotemWarmthTickProcedure extends RanDomThingsModElements.ModElement {
	public TotemWarmthTickProcedure(RanDomThingsModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RanDomThingsMod.LOGGER.warn("Failed to load dependency entity for procedure TotemWarmthTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				RanDomThingsMod.LOGGER.warn("Failed to load dependency itemstack for procedure TotemWarmthTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (true) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 20, (int) 1, (true), (false)));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 20);
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
	}
}
