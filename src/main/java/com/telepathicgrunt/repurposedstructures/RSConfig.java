package com.telepathicgrunt.repurposedstructures;

import com.telepathicgrunt.repurposedstructures.utils.ConfigHelper;
import com.telepathicgrunt.repurposedstructures.utils.ConfigHelper.ConfigValueListener;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class RSConfig
{
	public static class RSConfigValues
	{
		public ConfigValueListener<Boolean> addDungeonsToModdedBiomes;
		public ConfigValueListener<Integer> badlandsDungeonSpawnrate;
		public ConfigValueListener<Integer> darkForestDungeonSpawnrate;
		public ConfigValueListener<Integer> desertDungeonSpawnrate;
		public ConfigValueListener<Integer> jungleDungeonSpawnrate;
		public ConfigValueListener<Integer> mushroomDungeonSpawnrate;
		public ConfigValueListener<Integer> snowDungeonSpawnrate;
		public ConfigValueListener<Integer> swampDungeonSpawnrate;
		public ConfigValueListener<Integer> endDungeonSpawnrate;
		public ConfigValueListener<Integer> netherDungeonSpawnrate;
		public ConfigValueListener<Integer> oceanDungeonSpawnrate;

		public ConfigValueListener<Boolean> addWellsToModdedBiomes;
		public ConfigValueListener<Integer> wellSpawnrate;
		public ConfigValueListener<Boolean> canHaveBells;
		public ConfigValueListener<Boolean> badlandsWells;
		public ConfigValueListener<Boolean> netherWells;
		public ConfigValueListener<Boolean> snowWells;
		public ConfigValueListener<Boolean> mossyStoneWells;
		public ConfigValueListener<Boolean> forestWells;

		public ConfigValueListener<Boolean> addMiscToModdedBiomes;
		public ConfigValueListener<Boolean> boulderTiny;
		public ConfigValueListener<Boolean> boulderGiant;
		public ConfigValueListener<Boolean> hornedSwampTree;
		
		public ConfigValueListener<Boolean> lootChestsMS;
		public ConfigValueListener<Boolean> addMineshaftsToModdedBiomes;
		public ConfigValueListener<Integer> birchMineshaftSpawnrate;
		public ConfigValueListener<Integer> jungleMineshaftSpawnrate;
		public ConfigValueListener<Integer> desertMineshaftSpawnrate;
		public ConfigValueListener<Integer> stoneMineshaftSpawnrate;
		public ConfigValueListener<Integer> savannaMineshaftSpawnrate;
		public ConfigValueListener<Integer> icyMineshaftSpawnrate;
		public ConfigValueListener<Integer> oceanMineshaftSpawnrate;
		public ConfigValueListener<Integer> taigaMineshaftSpawnrate;;
		public ConfigValueListener<Integer> swampAndDarkForestMineshaftSpawnrate;
		public ConfigValueListener<Integer> endMineshaftSpawnrate;
		public ConfigValueListener<Integer> netherMineshaftSpawnrate;

		public ConfigValueListener<Boolean> useVanillaStronghold;
		public ConfigValueListener<Boolean> allowStonebrickStronghold;
		public ConfigValueListener<Boolean> allowNetherStronghold;
		public ConfigValueListener<Integer> strongholdSpawnrate;
		public ConfigValueListener<Double> silverfishSpawnrateSH;
		public ConfigValueListener<Boolean> allowExtraSpawnersSH;
		public ConfigValueListener<Double> strongholdSizeSH;
		public ConfigValueListener<Boolean> lootChestsSH;
		
		public ConfigValueListener<Integer> jungleFortressSpawnrate;
		public ConfigValueListener<Double> silverfishSpawnrateJF;
		public ConfigValueListener<Boolean> allowSilverfishSpawnerJF;
		public ConfigValueListener<Boolean> lootChestsJF;
		public ConfigValueListener<Boolean> addJungleFortressToModdedBiomes;
		
		public ConfigValueListener<Integer> netherTempleSpawnrate;
		public ConfigValueListener<Boolean> lootChestsNT;
		public ConfigValueListener<Boolean> addNetherTempleToModdedBiomes;
		
		public ConfigValueListener<Integer> badlandsTempleSpawnrate;
		public ConfigValueListener<Boolean> lootChestsBT;
		public ConfigValueListener<Boolean> addBadlandsTempleToModdedBiomes;

		public ConfigValueListener<Integer> grassyIglooSpawnrate;
		public ConfigValueListener<Boolean> addGrassyIglooToModdedBiomes;
		public ConfigValueListener<Integer> stoneIglooSpawnrate;
		public ConfigValueListener<Boolean> addStoneIglooToModdedBiomes;

		RSConfigValues(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber)
		{
			builder.push("Feature Options");

				builder.push("Dungeons");
				
					addDungeonsToModdedBiomes = subscriber.subscribe(builder
							.comment("\r\n Add the custom dungeons to modded biomes of the same categories/type.")
						.translation("repurposedstructures.config.feature.dungeons.adddungeonstomoddedbiomes")
						.define("addDungeonsToModdedBiomes", false));
					
					badlandsDungeonSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace vanilla dungeon in Badlands biomes with Badlands themed dungeon.\r\n"
								+" How often dungeons will attempt to spawn per chunk.\r\n " 
								+" 0 for no Dungeons at all and 1000 for max Dungeon spawnrate.\r\n"
								+" Note: Vanilla Dungeons will spawn again when this is set to 0.")
						.translation("repurposedstructures.config.feature.dungeons.badlandsDungeonSpawnrate")
						.defineInRange("badlandsDungeonSpawnrate", 8, 0, 1000));
				
					darkForestDungeonSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace vanilla dungeon in Dark Forest biomes with Dark Forest themed dungeon.\r\n"
								+" How often dungeons will attempt to spawn per chunk.\r\n " 
								+" 0 for no Dungeons at all and 1000 for max Dungeon spawnrate.\r\n"
								+" Note: Vanilla Dungeons will spawn again when this is set to 0.")
						.translation("repurposedstructures.config.feature.dungeons.darkforestDungeonSpawnrate")
						.defineInRange("darkForestDungeonSpawnrate", 8, 0, 1000));
				
					desertDungeonSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace vanilla dungeon in Desert biomes with Desert themed dungeon.\r\n"
								+" How often dungeons will attempt to spawn per chunk.\r\n " 
								+" 0 for no Dungeons at all and 1000 for max Dungeon spawnrate.\r\n"
								+" Note: Vanilla Dungeons will spawn again when this is set to 0.")
						.translation("repurposedstructures.config.feature.dungeons.desertDungeonSpawnrate")
						.defineInRange("desertDungeonSpawnrate", 8, 0, 1000));
				
					jungleDungeonSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace vanilla dungeon in Jungle biomes with Jungle themed dungeon.\r\n"
								+" How often dungeons will attempt to spawn per chunk.\r\n " 
								+" 0 for no Dungeons at all and 1000 for max Dungeon spawnrate.\r\n"
								+" Note: Vanilla Dungeons will spawn again when this is set to 0.")
						.translation("repurposedstructures.config.feature.dungeons.jungleDungeonSpawnrate")
						.defineInRange("jungleDungeonSpawnrate", 8, 0, 1000));
				
					mushroomDungeonSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace vanilla dungeon in Mushroom biomes with Mushroom themed dungeon.\r\n"
								+" How often dungeons will attempt to spawn per chunk.\r\n " 
								+" 0 for no Dungeons at all and 1000 for max Dungeon spawnrate.\r\n"
								+" Note: Vanilla Dungeons will spawn again when this is set to 0.")
						.translation("repurposedstructures.config.feature.dungeons.mushroomDungeonSpawnrate")
						.defineInRange("mushroomDungeonSpawnrate", 8, 0, 1000));
				
					snowDungeonSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace vanilla dungeon in icy/snow biomes with icy/snow themed dungeon.\r\n"
								+" How often dungeons will attempt to spawn per chunk.\r\n " 
								+" 0 for no Dungeons at all and 1000 for max Dungeon spawnrate.\r\n"
								+" Note: Vanilla Dungeons will spawn again when this is set to 0.")
						.translation("repurposedstructures.config.feature.dungeons.snowDungeonSpawnrate")
						.defineInRange("snowDungeonSpawnrate", 8, 0, 1000));
				
					swampDungeonSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace vanilla dungeon in Swamp biomes with Swamp themed dungeon.\r\n"
								+" How often dungeons will attempt to spawn per chunk.\r\n " 
								+" 0 for no Dungeons at all and 1000 for max Dungeon spawnrate.\r\n"
								+" Note: Vanilla Dungeons will spawn again when this is set to 0.")
						.translation("repurposedstructures.config.feature.dungeons.swampDungeonSpawnrate")
						.defineInRange("swampDungeonSpawnrate", 8, 0, 1000));
				
					endDungeonSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Add End themed dungeon to End biomes outside the Enderdragon island.\r\n"
								+" How often dungeons will attempt to spawn per chunk.\r\n " 
								+" 0 for no Dungeons at all and 1000 for max Dungeon spawnrate.")
						.translation("repurposedstructures.config.feature.dungeons.endDungeonSpawnrate")
						.defineInRange("endDungeonSpawnrate", 8, 0, 1000));

					netherDungeonSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Add Nether themed dungeon to Nether biomes.\r\n"
								+" How often dungeons will attempt to spawn per chunk.\r\n " 
								+" 0 for no Dungeons at all and 1000 for max Dungeon spawnrate.")
						.translation("repurposedstructures.config.feature.dungeons.netherDungeonSpawnrate")
						.defineInRange("netherDungeonSpawnrate", 8, 0, 1000));

    					oceanDungeonSpawnrate = subscriber.subscribe(builder
    							.comment("\r\n Add ocean themed dungeon to ocean biomes. These will spawn on"
    								+"\r\n the ocean's floor and inside water filled caves and ravines.\r\n"
    								+"\r\n"
    								+" How often dungeons will attempt to spawn per chunk.\r\n " 
    								+" 0 for no dungeons at all and 1000 for max dungeon spawnrate."
    								+"\r\n"
    								+"\r\n Note: Vanilla Dungeons will still generate if the biome has "
    								+"\r\n them which is unlike the other modded dungeons from this mod"
    								+"\r\n as those would normally replace the Vanilla Dungeons.")
						.translation("repurposedstructures.config.feature.dungeons.oceanDungeonSpawnrate")
						.defineInRange("oceanDungeonSpawnrate", 8, 0, 1000));
					
				builder.pop();

				builder.push("Small Wells");
				
					addWellsToModdedBiomes = subscriber.subscribe(builder
							.comment("\r\n Add the custom wells to modded biomes of the same categories/type.")
						.translation("repurposedstructures.config.feature.smallwells.addwellstomoddedbiomes")
						.define("addWellsToModdedBiomes", false));

					wellSpawnrate = subscriber.subscribe(builder
							.comment( "\r\n How often wells will attempt to spawn per chunk." 
									+ "\r\n The chance of a well generating at a chunk is 1/spawnrate."
									+ "\r\n 1 for wells spawning in every chunk and 10000 for extremely rare wells.")
							.translation("repurposedstructures.config.feature.smallwells.wellSpawnrate")
							.defineInRange("wellSpawnrate", 350, 1, 10000));

					canHaveBells = subscriber.subscribe(builder
							.comment("\r\n Determines if Wells can have a chance of spawning a Bell.")
						.translation("repurposedstructures.config.feature.smallwells.canhavebells")
						.define("canHaveBells", true));
					
					badlandsWells = subscriber.subscribe(builder
							.comment("\r\n Add Badlands themed wells to Badlands biomes.")
						.translation("repurposedstructures.config.feature.smallwells.badlandswells")
						.define("badlandsWells", true));
					
					netherWells = subscriber.subscribe(builder
							.comment("\r\n Add Nether themed wells to Nether biomes.")
						.translation("repurposedstructures.config.feature.smallwells.netherwells")
						.define("netherWells", true));
					
					snowWells = subscriber.subscribe(builder
							.comment("\r\n Add Snow themed wells to snowy and icy biomes.")
						.translation("repurposedstructures.config.feature.smallwells.snowwells")
						.define("snowWells", true));
					
					mossyStoneWells = subscriber.subscribe(builder
							.comment("\r\n Add mossy stone themed wells to Jungles, Dark Oak, and Swamp biomes.")
						.translation("repurposedstructures.config.feature.smallwells.mossystonewells")
						.define("mossyStoneWells", true));

					forestWells = subscriber.subscribe(builder
							.comment("\r\n Add a wood themed wells to Forest and Birch Forest biomes.")
						.translation("repurposedstructures.config.feature.smallwells.forestwells")
						.define("forestWells", true));
					
				builder.pop();
				
				builder.push("Misc");
				
					addMiscToModdedBiomes = subscriber.subscribe(builder
							.comment("\r\n Add the custom features to modded biomes of the same categories/type.")
						.translation("repurposedstructures.config.feature.misc.addmisctomoddedbiomes")
						.define("addMiscToModdedBiomes", false));

					boulderTiny = subscriber.subscribe(builder
							.comment("\r\n Adds tiny boulders to Taiga Mountains and Snowy Taiga Mountains biomes "
									+"\r\n that can contain small amounts of Coal and Iron ores.")
						.translation("repurposedstructures.config.feature.misc.bouldertiny")
						.define("boulderTiny", true));
					
					boulderGiant = subscriber.subscribe(builder
							.comment("\r\n Replaces boulders in Giant Tree Taiga Hills and Giant Spruce Taiga Hills"
									+"\r\n biomes with a larger boulder that can contain Coal, Iron, and extremely"
									+"\r\n rarely, can also have Diamond Ores.")
						.translation("repurposedstructures.config.feature.misc.netherdungeons")
						.define("boulderGiant", true));
					
					hornedSwampTree = subscriber.subscribe(builder
							.comment("\r\n Adds a large tree somewhat uncommonly to Swamp biome and replaces"
									+"\r\n all vanilla trees in Swamp Hills biome with the larger tree.")
						.translation("repurposedstructures.config.feature.misc.hornedSwampTree")
						.define("hornedSwampTree", true));
					
				builder.pop();
				
			builder.pop();

			builder.push("Structure Options");

				builder.push("Mineshaft");

					lootChestsMS = subscriber.subscribe(builder
							.comment("\r\n Controls whether loot chests spawn or not in modded Mineshafts.")
						.translation("repurposedstructures.config.structure.mineshaft.lootchestsms")
						.define("lootChestsMS", true));

					addMineshaftsToModdedBiomes = subscriber.subscribe(builder
							.comment("\r\n Add the custom Mineshafts to modded biomes of the same categories/type.")
						.translation("repurposedstructures.config.feature.dungeons.addmineshaftstomoddedbiomes")
						.define("addMineshaftsToModdedBiomes", false));
					
					birchMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace Mineshafts in Birch biomes with a Birch themed Mineshaft."
								+"\r\n How often Mineshafts will spawn.\r\n " 
								+ "0 for no Mineshafts and 1000 for max spawnrate."
								+"\r\n Note: Vanilla Mineshafts will spawn again when this is set to 0 and game is restarted.")
						.translation("repurposedstructures.config.feature.mineshaft.birchmineshaftspawnrate")
						.defineInRange("birchMineshaftSpawnrate", 40, 0, 1000));

					jungleMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace Mineshafts in Jungle biomes with a Jungle themed Mineshaft."
								+"\r\n How often Mineshafts will spawn.\r\n " 
								+ "0 for no Mineshafts and 1000 for max spawnrate."
								+"\r\n Note: Vanilla Mineshafts will spawn again when this is set to 0 and game is restarted.")
						.translation("repurposedstructures.config.feature.mineshaft.junglemineshaftspawnrate")
						.defineInRange("jungleMineshaftSpawnrate", 40, 0, 1000));

					desertMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace Mineshafts in Desert biomes with a Desert themed Mineshaft."
								+"\r\n How often Mineshafts will spawn.\r\n " 
								+ "0 for no Mineshafts and 1000 for max spawnrate."
								+"\r\n Note: Vanilla Mineshafts will spawn again when this is set to 0 and game is restarted.")
						.translation("repurposedstructures.config.feature.mineshaft.desertmineshaftspawnrate")
						.defineInRange("desertMineshaftSpawnrate", 40, 0, 1000));

					stoneMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace Mineshafts in Mountain (Extreme Hills) biomes with a Stone themed Mineshaft."
								+"\r\n How often Mineshafts will spawn.\r\n " 
								+ "0 for no Mineshafts and 1000 for max spawnrate."
								+"\r\n Note: Vanilla Mineshafts will spawn again when this is set to 0 and game is restarted.")
						.translation("repurposedstructures.config.feature.mineshaft.stonemineshaftspawnrate")
						.defineInRange("stoneMineshaftSpawnrate", 40, 0, 1000));

					savannaMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace Mineshafts in Savanna biomes with a Savanna themed Mineshaft."
								+"\r\n How often Mineshafts will spawn.\r\n " 
								+ "0 for no Mineshafts and 1000 for max spawnrate."
								+"\r\n Note: Vanilla Mineshafts will spawn again when this is set to 0 and game is restarted.")
						.translation("repurposedstructures.config.feature.mineshaft.savannamineshaftspawnrate")
						.defineInRange("savannaMineshaftSpawnrate", 40, 0, 1000));

					icyMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace Mineshafts in Snowy/Icy biomes with an Ice themed Mineshaft."
									+"\r\n Note: Snowy Taiga Biomes will get Ice Mineshaft instead of Taiga theme."
									+"\r\n How often Mineshafts will spawn.\r\n " 
									+ "0 for no Mineshafts and 1000 for max spawnrate."
									+"\r\n Note: Vanilla Mineshafts will spawn again when this is set to 0 and game is restarted.")
						.translation("repurposedstructures.config.feature.mineshaft.icymineshaftspawnrate")
						.defineInRange("icyMineshaftSpawnrate", 40, 0, 1000));

					oceanMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace Mineshafts in Ocean biomes with an Ocean themed Mineshaft."
								+"\r\n How often Mineshafts will spawn.\r\n " 
								+ "0 for no Mineshafts and 1000 for max spawnrate."
								+"\r\n Note: Vanilla Mineshafts will spawn again when this is set to 0 and game is restarted.")
						.translation("repurposedstructures.config.feature.mineshaft.oceanmineshaftspawnrate")
						.defineInRange("oceanMineshaftSpawnrate", 40, 0, 1000));

					taigaMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace Mineshafts in Taiga biomes with a Taiga themed Mineshaft."
								+"\r\n How often Mineshafts will spawn.\r\n " 
								+ "0 for no Mineshafts and 1000 for max spawnrate."
								+" Note: Vanilla Mineshafts will spawn again when this is set to 0 and game is restarted.")
						.translation("repurposedstructures.config.feature.mineshaft.taigamineshaftspawnrate")
						.defineInRange("taigaMineshaftSpawnrate", 40, 0, 1000));
					
					swampAndDarkForestMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Replace Mineshafts in Swamps and Dark Forests with a"
								+"\r\n swampy/dark oak themed Mineshaft."
								+"\r\n Note: Vanilla Mineshafts will spawn again when this is set to 0 and game is restarted.")
						.translation("repurposedstructures.config.feature.mineshaft.swampanddarkforestmineshaftspawnrate"
							+"\r\n How often Mineshafts will spawn.\r\n " 
							+ "0 for no Mineshafts and 1000 for max spawnrate.")
						.defineInRange("swampAndDarkForestMineshaftSpawnrate", 40, 0, 1000));
					
					endMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Add End themed Mineshafts to End biomes outside the Enderdragon island."
								+"\r\n How often Mineshafts will spawn.\r\n " 
								+ "0 for no Mineshafts and 1000 for max spawnrate.")
						.translation("repurposedstructures.config.feature.mineshaft.endmineshaftspawnrate")
						.defineInRange("endMineshaftSpawnrate", 40, 0, 1000));
					
					netherMineshaftSpawnrate = subscriber.subscribe(builder
							.comment("\r\n Add Nether themed Mineshafts to Nether biomes."
								+"\r\n How often Mineshafts will spawn.\r\n " 
								+ "0 for no Mineshafts and 1000 for max spawnrate.")
						.translation("repurposedstructures.config.feature.mineshaft.nethermineshaftspawnrate")
						.defineInRange("netherMineshaftSpawnrate", 40, 0, 1000));
					
				builder.pop();

				builder.push("Stronghold");

					useVanillaStronghold = subscriber.subscribe(builder
						.comment("\r\n Use vanilla Stronghold instead of using this mod's modded version.\r\n"
								+" Note: The other Stronghold configs here will have no effect on vanilla Strongholds. \r\n"
								+" WARNING: Nether Strongholds will be turned off too when this option is on.")
						.translation("repurposedstructures.config.structure.stronghold.usevanillastronghold")
						.define("useVanillaStronghold", false));

					allowStonebrickStronghold = subscriber.subscribe(builder
						.comment("\r\n Allow Stonebrick styled Stronghold to generate in non-Nether biomes.")
						.translation("repurposedstructures.config.structure.stronghold.allowstonebrickstronghold")
						.define("allowStonebrickStronghold", true));

					allowNetherStronghold = subscriber.subscribe(builder
						.comment("\r\n Allow Nether-styled Strongholds to spawn in Nether category biomes."
								+ "\r\n Note: Eyes of Ender will work and show the closest Nether Stronghold too.")
						.translation("repurposedstructures.config.structure.stronghold.allownetherstronghold")
						.define("allowNetherStronghold", true));
				
					strongholdSpawnrate = subscriber.subscribe(builder
							.comment("\r\n How rare are Strongholds." 
									+ "\n " 
									+ "1 for spawning in most chunks and 1001 for no spawn.")
							.translation("repurposedstructures.config.structure.stronghold.strongholdspawnrate")
							.defineInRange("strongholdSpawnrate", 85, 1, 1001));
		
					silverfishSpawnrateSH = subscriber.subscribe(builder
							.comment("\r\n How often Silverfish Blocks will generate in Strongholds as a percentage." 
									+ "\r\n Note: Mossy Stone Bricks block cannot be infected by Silverfish"
									+ "\n "
									+ "0 for no Silverfish Blocks and 100 for max spawnrate.")
							.translation("repurposedstructures.config.structure.stronghold.silverfishspawnratesh")
							.defineInRange("silverfishSpawnrateSH", 0.8D, 0, 100));
		
					allowExtraSpawnersSH = subscriber.subscribe(builder
							.comment("\r\n Make Mob Spawners generate in rooms other than the Portal Room in Strongholds.\r\n"
									+" Note: Spawners in Portal Room will always remain.")
							.translation("repurposedstructures.config.structure.stronghold.allowextraspawnerssh")
							.define("allowExtraSpawnersSH", true));
		
					strongholdSizeSH = subscriber.subscribe(builder
							.comment("\r\n How large the Stronghold is on average as a percentage." 
									+ "\r\n Note: The Stonghold is much larger by default. To get something "
									+ "\r\n closer to vanilla stronghold size, use the value of 60."
									+ "\n "
									+ "10 for supertiny Strongholds and 2000 for supermassive Strongholds.")
							.translation("repurposedstructures.config.structure.stronghold.strongholdsizesh")
							.defineInRange("strongholdSizeSH", 100D, 10, 2000));
					
					lootChestsSH = subscriber.subscribe(builder
							.comment("\r\n Controls whether loot chests spawn or not in the Stronghold.")
						.translation("repurposedstructures.config.structure.stronghold.lootchestssh")
						.define("lootChestsSH", true));
	
				builder.pop();
	
				builder.push("Jungle Fortress");
	
					jungleFortressSpawnrate = subscriber.subscribe(builder
							.comment("\r\n How rare are Jungle Fortresses." 
									+ "\n "
									+ "1 for spawning in most chunks and 1001 for no spawn.")
							.translation("repurposedstructures.config.structure.junglefortress.junglefortressspawnrate")
							.defineInRange("jungleFortressSpawnrate", 32, 1, 1001));

					silverfishSpawnrateJF = subscriber.subscribe(builder
							.comment("\r\n How often Silverfish Blocks will generate in Jungle Fortress as a percentage."
									+ "\r\n Note: Mossy Stone Bricks block cannot be infected by Silverfish"
									+ "\n "
									+ "0 for no Silverfish Blocks and 100 for max spawnrate.")
							.translation("repurposedstructures.config.structure.junglefortress.silverfishspawnratejf")
							.defineInRange("silverfishSpawnrateJF", 0.5D, 0, 100));
					
					allowSilverfishSpawnerJF = subscriber.subscribe(builder
							.comment("\r\n Silverfish Mob Spawners generate in Stone Fortresses."
									+"\r\n If turned off, the spawners will become Skeleton spawners.")
							.translation("repurposedstructures.config.structure.junglefortress.allowsilverfishspawnerjf")
							.define("allowSilverfishSpawnerJF", true));

					lootChestsJF = subscriber.subscribe(builder
							.comment("\r\n Controls whether loot chests spawn or not in Jungle Fortresses.")
						.translation("repurposedstructures.config.structure.junglefortress.lootchestsjf")
						.define("lootChestsJF", true));

					addJungleFortressToModdedBiomes = subscriber.subscribe(builder
							.comment("\r\n Add Jungle Fortress to modded jungle biomes.")
						.translation("repurposedstructures.config.structure.junglefortress.addjunglefortresstomoddedbiomes")
						.define("addJungleFortressToModdedBiomes", false));

				builder.pop();
				
				builder.push("Nether Temple");
	
					netherTempleSpawnrate = subscriber.subscribe(builder
							.comment("\r\n How rare are Nether Temples in Nether." 
									+ "\n "
									+ "1 for spawning in most chunks and 1001 for no spawn.")
							.translation("repurposedstructures.config.structure.nethertemple.nethertemplespawnrate")
							.defineInRange("netherTempleSpawnrate", 20, 1, 1001));

					lootChestsNT = subscriber.subscribe(builder
							.comment("\r\n Controls whether loot chests spawn or not in Nether Temples.")
						.translation("repurposedstructures.config.structure.nethertemple.lootchestsnt")
						.define("lootChestsNT", true));

					addNetherTempleToModdedBiomes = subscriber.subscribe(builder
							.comment("\r\n Add Jungle Fortress to modded jungle biomes.")
						.translation("repurposedstructures.config.structure.nethertemple.addnethertempletomoddedbiomes")
						.define("addNetherTempleToModdedBiomes", false));
					
				builder.pop();
				
				builder.push("Badlands Temple");
				
					badlandsTempleSpawnrate = subscriber.subscribe(builder
							.comment("\r\n How rare are Nether Temples in Nether." 
									+ "\n "
									+ "1 for spawning in most chunks and 1001 for no spawn.")
							.translation("repurposedstructures.config.structure.badlandstemple.badlandstemplespawnrate")
							.defineInRange("badlandsTempleSpawnrate", 20, 1, 1001));
	
					lootChestsBT = subscriber.subscribe(builder
							.comment("\r\n Controls whether loot chests spawn or not in Badlands Temples.")
						.translation("repurposedstructures.config.structure.badlandstemple.lootchestsbt")
						.define("lootChestsBT", true));
	
					addBadlandsTempleToModdedBiomes = subscriber.subscribe(builder
							.comment("\r\n Add Jungle Fortress to modded jungle biomes.")
						.translation("repurposedstructures.config.structure.badlandstemple.addbadlandstempletomoddedbiomes")
						.define("addBadlandsTempleToModdedBiomes", false));
				
				builder.pop();
				
				builder.push("Igloos");
				
					grassyIglooSpawnrate = subscriber.subscribe(builder
						.comment("\r\n How rare are Grassy Igloos in Plains and Forests." 
								+ "\n "
								+ "1 for spawning in most chunks and 1001 for no spawn.")
						.translation("repurposedstructures.config.structure.igloo.grassyigloospawnrate")
						.defineInRange("grassyIglooSpawnrate", 20, 1, 1001));
	
					addGrassyIglooToModdedBiomes = subscriber.subscribe(builder
							.comment("\r\n Add Grassy Igloos to modded biomes that are\r\n"
									+" most likely grassy fields or temperate forests.")
						.translation("repurposedstructures.config.structure.igloo.addgrassyiglootomoddedbiomes")
						.define("addGrassyIglooToModdedBiomes", false));

					stoneIglooSpawnrate = subscriber.subscribe(builder
						.comment("\r\n How rare are Stone Igloos in Giant Tree Taiga biomes." 
								+ "\n "
								+ "1 for spawning in most chunks and 1001 for no spawn.")
						.translation("repurposedstructures.config.structure.igloo.stoneigloospawnrate")
						.defineInRange("stoneIglooSpawnrate", 20, 1, 1001));
	
					addStoneIglooToModdedBiomes = subscriber.subscribe(builder
							.comment("\r\n Add Stone Igloos to modded biomes that are\r\n"
									+" most likely Giant Tree Taiga variants.")
						.translation("repurposedstructures.config.structure.igloo.addstoneiglootomoddedbiomes")
						.define("addStoneIglooToModdedBiomes", false));
				builder.pop();
			builder.pop();
		}
	}
}
