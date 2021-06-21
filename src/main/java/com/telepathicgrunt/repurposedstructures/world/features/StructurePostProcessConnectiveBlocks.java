package com.telepathicgrunt.repurposedstructures.world.features;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;


public class StructurePostProcessConnectiveBlocks extends Feature<DefaultFeatureConfig> {

    public StructurePostProcessConnectiveBlocks() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {

        BlockPos.Mutable currentBlockMutable = new BlockPos.Mutable();
        BlockPos.Mutable offsetMutable = new BlockPos.Mutable();
        ChunkPos currentChunkPos = new ChunkPos(context.getOrigin());
        Chunk currentChunk = context.getWorld().getChunk(currentChunkPos.x, currentChunkPos.z);
        for(int x = -1; x <= 1; x++){
            for(int z = -1; z <= 1; z++){
                for(int y = -2; y <= 0; y++){
                    currentBlockMutable.set(context.getOrigin()).move(x, y, z);

                    if (currentChunkPos.x != currentBlockMutable.getX() >> 4 || currentChunkPos.z != currentBlockMutable.getZ() >> 4) {
                        currentChunk = context.getWorld().getChunk(currentBlockMutable);
                        currentChunkPos = new ChunkPos(currentBlockMutable);
                    }

                    BlockState currentState = currentChunk.getBlockState(currentBlockMutable);
                    if(currentState.getBlock() instanceof WallBlock){
                        for(Direction direction : Direction.values()){
                            offsetMutable.set(currentBlockMutable).move(direction);
                            if (currentChunkPos.x != offsetMutable.getX() >> 4 || currentChunkPos.z != offsetMutable.getZ() >> 4) {
                                continue;
                            }
                            BlockState sideBlock = currentChunk.getBlockState(offsetMutable);
                            currentState  = currentState.getStateForNeighborUpdate(
                                    direction,
                                    sideBlock,
                                    context.getWorld(),
                                    currentBlockMutable,
                                    offsetMutable
                            );
                        }
                        context.getWorld().setBlockState(currentBlockMutable, currentState, 3);
                    }
                    else if(currentState.getBlock() instanceof FenceBlock){
                        for(Direction direction : Direction.Type.HORIZONTAL){
                            offsetMutable.set(currentBlockMutable).move(direction);
                            if (currentChunkPos.x != offsetMutable.getX() >> 4 || currentChunkPos.z != offsetMutable.getZ() >> 4) {
                                continue;
                            }
                            BlockState sideBlock = currentChunk.getBlockState(offsetMutable);
                            currentState  = currentState.getStateForNeighborUpdate(
                                    direction,
                                    sideBlock,
                                    context.getWorld(),
                                    currentBlockMutable,
                                    offsetMutable
                            );
                        }
                        context.getWorld().setBlockState(currentBlockMutable, currentState, 3);
                    }
                }
            }
        }

        return true;
    }
}