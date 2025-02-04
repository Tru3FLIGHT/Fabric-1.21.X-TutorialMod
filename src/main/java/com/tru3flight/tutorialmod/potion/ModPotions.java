package com.tru3flight.tutorialmod.potion;

import com.tru3flight.tutorialmod.TutorialMod;
import com.tru3flight.tutorialmod.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final RegistryEntry<Potion> SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 1200, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(TutorialMod.MOD_ID, name), potion);
    }

    public static void  registerPotions() {
        TutorialMod.LOGGER.info("Registering potions");
    }
}
