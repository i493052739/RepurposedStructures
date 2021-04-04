package com.telepathicgrunt.repurposedstructures.world.features;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;


public class ShulkerMob extends Feature<DefaultFeatureConfig> {

    public ShulkerMob() {
        super(DefaultFeatureConfig.CODEC);
    }

    /**
     * This is necessary due to https://bugs.mojang.com/browse/MC-108149
     * TLDR: trying to spawn Shulker mobs from nbt files will not work and they will teleport back
     * to the original world position that they were saved at instead of the new structure's position.
     */
    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos position, DefaultFeatureConfig config) {
        // move down to spawn at the jigsaw block calling this
        position = position.down();

        ShulkerEntity shulkerEntity = EntityType.SHULKER.create(world.toServerWorld());
        shulkerEntity.setPersistent();
        shulkerEntity.updatePosition(
                (double)position.getX() + 0.5D,
                position.getY(),
                (double)position.getZ() + 0.5D);

        shulkerEntity.setAttachedBlock(position);
        world.spawnEntityAndPassengers(shulkerEntity);
        return true;
    }
}