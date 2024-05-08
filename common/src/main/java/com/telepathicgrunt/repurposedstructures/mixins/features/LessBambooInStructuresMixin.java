package com.telepathicgrunt.repurposedstructures.mixins.features;

import com.telepathicgrunt.repurposedstructures.modinit.RSTags;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.levelgen.feature.BambooFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(BambooFeature.class)
public class LessBambooInStructuresMixin {

    @Inject(
            method = "place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void repurposedstructures_lessBambooInStructures(FeaturePlaceContext<ProbabilityFeatureConfiguration> context, CallbackInfoReturnable<Boolean> cir) {
        if(context.level() instanceof WorldGenRegion) {
            // Rate for removal of bamboo in structure
            if(context.random().nextBoolean()) {
                Registry<Structure> configuredStructureFeatureRegistry = context.level().registryAccess().registryOrThrow(Registries.STRUCTURE);
                StructureManager structureManager = context.level().getLevel().structureManager();

                for (Holder<Structure> configuredStructureFeature : configuredStructureFeatureRegistry.getOrCreateTag(RSTags.LESS_BAMBOO)) {
                    if (structureManager.getStructureAt(context.origin(), configuredStructureFeature.value()).isValid()) {
                        cir.setReturnValue(false);
                        return;
                    }
                }
            }
        }
    }
}
