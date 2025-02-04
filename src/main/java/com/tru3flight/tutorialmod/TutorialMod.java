package com.tru3flight.tutorialmod;

import com.tru3flight.tutorialmod.block.ModBlocks;
import com.tru3flight.tutorialmod.component.ModDataComponentTypes;
import com.tru3flight.tutorialmod.item.ModItemGroups;
import com.tru3flight.tutorialmod.item.ModItems;
import com.tru3flight.tutorialmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModDataComponentTypes.registerDataCompoenentTypes();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_AHSES, 600);
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}