package com.telepathicgrunt.repurposedstructures.modinit;

import com.telepathicgrunt.repurposedstructures.RepurposedStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public final class RSTags {
    public static void initTags() {}

    public static TagKey<Structure> NO_LAKES = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "no_lakes"));

    public static TagKey<Structure> LESS_JUNGLE_BUSHES = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "less_jungle_bushes"));

    public static TagKey<Structure> LESS_BAMBOO = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "less_bamboo"));

    public static TagKey<Structure> NO_JUNGLE_VINES = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "no_jungle_vines"));

    public static TagKey<Structure> NO_LAVAFALLS = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "no_lavafalls"));

    public static TagKey<Structure> NO_WATERFALLS = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "no_waterfalls"));

    public static TagKey<Structure> NO_BASALT = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "no_basalt"));

    public static TagKey<Structure> NO_GEODES = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "no_geodes"));

    public static TagKey<Structure> SMARTER_SNOW_PLACING = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "smarter_snow_placing"));

    public static TagKey<Structure> LARGER_LOCATE_SEARCH = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "larger_locate_search"));


    public static TagKey<Block> MINESHAFT_SUPPORT_REPLACEABLES = TagKey.create(Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "mineshaft_support_replaceables"));

    public static TagKey<Block> DEAD_CORALS = TagKey.create(Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dead_corals"));
}
