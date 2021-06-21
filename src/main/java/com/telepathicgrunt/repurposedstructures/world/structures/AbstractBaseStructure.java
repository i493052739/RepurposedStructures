package com.telepathicgrunt.repurposedstructures.world.structures;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public abstract class AbstractBaseStructure<C extends FeatureConfig> extends StructureFeature<C> {

    public AbstractBaseStructure(Codec<C> codec) {
        super(codec);
    }

    @Override
    public BlockPos locateStructure(WorldView world, StructureAccessor structureAccessor, BlockPos searchStartPos, int searchRadius, boolean skipExistingChunks, long worldSeed, StructureConfig config) {
        return AbstractBaseStructure.locateStructureFast(world, structureAccessor, searchStartPos, searchRadius, skipExistingChunks, worldSeed, config, this);
    }

    public static <C extends FeatureConfig> BlockPos locateStructureFast(WorldView worldView, StructureAccessor structureAccessor, BlockPos blockPos, int radius, boolean skipExistingChunks, long seed, StructureConfig structureConfig, StructureFeature<C> structure) {
        int spacing = structureConfig.getSpacing();
        int chunkPosX = blockPos.getX() >> 4;
        int chunkPosZ = blockPos.getZ() >> 4;
        int currentRadius = 0;

        for(ChunkRandom chunkRandom = new ChunkRandom(); currentRadius <= 100000; ++currentRadius) {
            for(int xRadius = -currentRadius; xRadius <= currentRadius; ++xRadius) {
                boolean xEdge = xRadius == -currentRadius || xRadius == currentRadius;

                for(int zRadius = -currentRadius; zRadius <= currentRadius; ++zRadius) {
                    boolean zEdge = zRadius == -currentRadius || zRadius == currentRadius;
                    if (xEdge || zEdge) {
                        int trueChunkX = chunkPosX + spacing * xRadius;
                        int trueChunkZ = chunkPosZ + spacing * zRadius;
                        ChunkPos chunkPos = structure.getStartChunk(structureConfig, seed, chunkRandom, trueChunkX, trueChunkZ);
                        if(worldView.getBiomeForNoiseGen((chunkPos.x << 2) + 2, 60, (chunkPos.z << 2) + 2).getGenerationSettings().hasStructureFeature(structure)) {
                            Chunk chunk = worldView.getChunk(chunkPos.x, chunkPos.z, ChunkStatus.STRUCTURE_STARTS);
                            StructureStart<?> structureStart = structureAccessor.getStructureStart(ChunkSectionPos.from(chunk.getPos(), 0), structure, chunk);
                            if (structureStart != null && structureStart.hasChildren()) {
                                if (skipExistingChunks && structureStart.isInExistingChunk()) {
                                    structureStart.incrementReferences();
                                    return structureStart.getBlockPos();
                                }

                                if (!skipExistingChunks) {
                                    return structureStart.getBlockPos();
                                }
                            }
                        }
                    }
                    else{
                        zRadius = currentRadius - 1;
                    }
                }
            }
        }

        return null;
    }
}
