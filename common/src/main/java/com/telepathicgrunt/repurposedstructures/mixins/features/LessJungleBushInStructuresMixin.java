package com.telepathicgrunt.repurposedstructures.mixins.features;

import com.telepathicgrunt.repurposedstructures.modinit.RSTags;
import com.telepathicgrunt.repurposedstructures.utils.GeneralUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(TreeFeature.class)
public class LessJungleBushInStructuresMixin {

    @Inject(
            method = "place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void repurposedstructures_lessJungleBushInStructures(FeaturePlaceContext<TreeConfiguration> context, CallbackInfoReturnable<Boolean> cir) {
        // Detect jungle bush like tree
        if(context.level() instanceof WorldGenRegion &&
            context.config().foliagePlacer instanceof BushFoliagePlacer &&
            context.config().minimumSize.minClippedHeight().orElse(0) < 2)
        {
            // Rate for removal of bush
            if(context.random().nextFloat() < 0.85f) {
                Registry<Structure> configuredStructureFeatureRegistry = context.level().registryAccess().registryOrThrow(Registries.STRUCTURE);
                StructureManager structureManager = context.level().getLevel().structureManager();

                for (Holder<Structure> structure : configuredStructureFeatureRegistry.getOrCreateTag(RSTags.LESS_JUNGLE_BUSHES)) {
                    if (GeneralUtils.getStructureAt(context.level(), structureManager, context.origin(), structure.value()).isValid()) {
                        cir.setReturnValue(false);
                        return;
                    }
                }
            }
        }
    }
}
