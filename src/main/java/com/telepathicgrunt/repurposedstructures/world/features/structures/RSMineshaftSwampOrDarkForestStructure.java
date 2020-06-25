package com.telepathicgrunt.repurposedstructures.world.features.structures;

import com.mojang.serialization.Codec;
import com.telepathicgrunt.repurposedstructures.RepurposedStructures;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;


public class RSMineshaftSwampOrDarkForestStructure extends AbstractMineshaftStructure {
    public RSMineshaftSwampOrDarkForestStructure(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public double mineshaftProbability(){
        return RepurposedStructures.RSMineshaftsConfig.spawnrate.swampAndDarkForestMineshaftSpawnrate;
    }

    @Override
    public StructureFeature.StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return RSMineshaftSwampOrDarkForestStructure.Start::new;
    }


    @Override
    public String getName() {
        return RepurposedStructures.MODID + ":mineshaft_swamp_or_dark_forest";
    }

    public static class Start extends StructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureIn, int chunkX, int chunkZ, BlockBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }


        @Override
        public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int chunkX, int chunkZ, Biome biome, DefaultFeatureConfig defaultFeatureConfig) {
            RSMineshaftPieces.Room structuremineshaftpiecesua$room = new RSMineshaftPieces.Room(0, this.random, (chunkX << 4) + 2, (chunkZ << 4) + 2, RSMineshaftPieces.Type.SWAMPORDARKFOREST);
            this.children.add(structuremineshaftpiecesua$room);

            structuremineshaftpiecesua$room.placeJigsaw(structuremineshaftpiecesua$room, this.children, this.random);
            this.setBoundingBoxFromChildren();

            int minimum = RepurposedStructures.RSMineshaftsConfig.minHeight.swampAndDarkForestMineshaftMinHeight;
            int maximum = Math.max(RepurposedStructures.RSMineshaftsConfig.maxHeight.swampAndDarkForestMineshaftMaxHeight, minimum) + 1;

            int offset = this.random.nextInt(maximum - minimum) + minimum;
            this.boundingBox.offset(0, offset - 50, 0);

            for (StructurePiece structurepiece : this.children) {
                structurepiece.translate(0, offset - 50, 0);
            }
        }
    }
}
