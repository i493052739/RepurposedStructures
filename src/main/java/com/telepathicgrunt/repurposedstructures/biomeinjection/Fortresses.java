package com.telepathicgrunt.repurposedstructures.biomeinjection;

import com.telepathicgrunt.repurposedstructures.RepurposedStructures;
import com.telepathicgrunt.repurposedstructures.modinit.RSConfiguredStructures;
import com.telepathicgrunt.repurposedstructures.modinit.RSStructures;
import com.telepathicgrunt.repurposedstructures.utils.BiomeSelection;
import com.telepathicgrunt.repurposedstructures.utils.GeneralUtils;
import net.minecraft.world.biome.Biome.Category;

public class Fortresses {

    public static void addJungleFortress() {

        GeneralUtils.addToBiome("jungle_fortress",
                (context) -> BiomeSelection.isBiomeAllowed(context, RSStructures.JUNGLE_FORTRESS,
                            () -> BiomeSelection.haveCategories(context, Category.JUNGLE))
                        && RepurposedStructures.RSAllConfig.RSFortressesConfig.jungleFortress.jungleFortressAverageChunkDistance != 1001,
                context -> context.getGenerationSettings().addBuiltInStructure(RSConfiguredStructures.JUNGLE_FORTRESS));
    }
}
