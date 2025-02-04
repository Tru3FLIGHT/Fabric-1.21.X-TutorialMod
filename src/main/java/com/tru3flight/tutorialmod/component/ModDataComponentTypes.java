package com.tru3flight.tutorialmod.component;

import com.tru3flight.tutorialmod.TutorialMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<BlockPos> COORDINATES =
            register("coordinates", builder -> builder.codec(BlockPos.CODEC));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(TutorialMod.MOD_ID, name),
                builderUnaryOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataCompoenentTypes() {
        TutorialMod.LOGGER.info("Registering Data Component Types for " + TutorialMod.MOD_ID);
    }
}
