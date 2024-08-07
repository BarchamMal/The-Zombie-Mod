package barch.tzm.Entities;

import barch.tzm.Config.TheZombieModConfigManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class ModdedZombieEntity extends ZombieEntity {

    public ModdedZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createModdedZombieAttributes() {
        return HostileEntity.createHostileAttributes().add(
                EntityAttributes.GENERIC_FOLLOW_RANGE, 96)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2)
                .add(EntityAttributes.GENERIC_ARMOR, 0.0)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, TheZombieModConfigManager.getConfig().zombieHealth);
    }


}
