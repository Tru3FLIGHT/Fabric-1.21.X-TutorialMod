package com.tru3flight.tutorialmod;

import com.tru3flight.tutorialmod.block.ModBlocks;
import com.tru3flight.tutorialmod.component.ModDataComponentTypes;
import com.tru3flight.tutorialmod.effect.ModEffects;
import com.tru3flight.tutorialmod.item.ModItemGroups;
import com.tru3flight.tutorialmod.item.ModItems;
import com.tru3flight.tutorialmod.potion.ModPotions;
import com.tru3flight.tutorialmod.sound.ModSounds;
import com.tru3flight.tutorialmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();

		ModDataComponentTypes.registerDataCompoenentTypes();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_AHSES, 600);
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register(((playerEntity, world, hand, entity, entityHitResult) -> {
			if(entity instanceof SheepEntity sheepEntity && !world.isClient()) {
				if(playerEntity.getMainHandStack().getItem() == Items.END_ROD) {
					playerEntity.sendMessage(Text.literal("The player hit a sheep with an end rod, you sick fuck"));
					playerEntity.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 80, 6));
				}
				return ActionResult.PASS;
			}
			return ActionResult.PASS;
		}));

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});
	}
}