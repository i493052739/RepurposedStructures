package com.telepathicgrunt.repurposedstructures.world.features;

import com.telepathicgrunt.repurposedstructures.utils.GeneralUtils;
import com.telepathicgrunt.repurposedstructures.world.features.configs.GenericMobConfig;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;


public class SkeletonHorseman extends Feature<GenericMobConfig> {

    public SkeletonHorseman() {
        super(GenericMobConfig.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<GenericMobConfig> context) {

        SkeletonHorse skeletonHorseEntity = EntityType.SKELETON_HORSE.create(context.level().getLevel());
        skeletonHorseEntity.setPersistenceRequired();
        skeletonHorseEntity.moveTo(
                (double)context.origin().getX() + 0.5D,
                context.origin().getY(),
                (double)context.origin().getZ() + 0.5D,
                0.0F,
                0.0F);
        skeletonHorseEntity.finalizeSpawn(context.level(), context.level().getCurrentDifficultyAt(context.origin()), MobSpawnType.STRUCTURE, null);
        Skeleton skeletonEntity = EntityType.SKELETON.create(context.level().getLevel());

        // Do this first as this attaches a bow automatically. We may want to override the bow later.
        skeletonEntity.finalizeSpawn(context.level(), context.level().getCurrentDifficultyAt(context.origin()), MobSpawnType.STRUCTURE, null);

        context.config().heldItem.ifPresent(item -> {
            ItemStack heldItem = new ItemStack(item);
            skeletonEntity.setItemInHand(InteractionHand.MAIN_HAND, GeneralUtils.enchantRandomly(context.random(), heldItem, 0.1F));
            skeletonEntity.setLeftHanded(context.random().nextFloat() < 0.05F);
        });
        context.config().helmet.ifPresent(item -> skeletonEntity.setItemSlot(EquipmentSlot.HEAD, GeneralUtils.enchantRandomly(context.random(), item.getDefaultInstance(), 0.075F)));
        context.config().chestplate.ifPresent(item -> skeletonEntity.setItemSlot(EquipmentSlot.CHEST, GeneralUtils.enchantRandomly(context.random(), item.getDefaultInstance(), 0.075F)));
        context.config().leggings.ifPresent(item -> skeletonEntity.setItemSlot(EquipmentSlot.LEGS, GeneralUtils.enchantRandomly(context.random(), item.getDefaultInstance(), 0.075F)));
        context.config().boots.ifPresent(item -> skeletonEntity.setItemSlot(EquipmentSlot.FEET, GeneralUtils.enchantRandomly(context.random(), item.getDefaultInstance(), 0.075F)));

        skeletonEntity.setPersistenceRequired();
        skeletonEntity.setHealth(context.config().health);
        skeletonEntity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(context.config().health);
        skeletonEntity.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(context.config().speedModifier);
        skeletonEntity.moveTo(
                (double)context.origin().getX() + 0.5D,
                context.origin().getY() + 1,
                (double)context.origin().getZ() + 0.5D,
                0.0F,
                0.0F);
        skeletonEntity.startRiding(skeletonHorseEntity);

        context.level().addFreshEntityWithPassengers(skeletonHorseEntity);
        return true;
    }
}