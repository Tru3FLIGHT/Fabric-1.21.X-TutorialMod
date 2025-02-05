package com.tru3flight.tutorialmod.world.tree;

import com.tru3flight.tutorialmod.TutorialMod;
import com.tru3flight.tutorialmod.world.ModConfiguredFeatures;
import com.tru3flight.tutorialmod.world.gen.ModOreGeneration;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerator {
    public static final SaplingGenerator DRIFTWOOD = new SaplingGenerator(TutorialMod.MOD_ID + ":driftwoood" ,
            Optional.empty(), Optional.of(ModConfiguredFeatures.DRIFTWOOD_KEY), Optional.empty());
}
