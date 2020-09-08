package com.telepathicgrunt.repurposedstructures.world.features;

import com.mojang.serialization.Codec;
import com.telepathicgrunt.repurposedstructures.RSFeatures;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;


public class SwampVillageVines extends Feature<DefaultFeatureConfig> {

    public SwampVillageVines() {
        super(DefaultFeatureConfig.CODEC);
    }


    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos position, DefaultFeatureConfig config) {
        if (world.isAir(position) && world.getStructures(ChunkSectionPos.from(position), RSFeatures.SWAMP_VILLAGE).findAny().isPresent()) {
            RSFeatures.SHORT_VINES.generate(world, chunkGenerator, random, position, DefaultFeatureConfig.DEFAULT);
            return true;
        }
        return false;
    }
}