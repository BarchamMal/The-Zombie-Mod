package barch.tzm.Entities;

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
                EntityAttributes.GENERIC_FOLLOW_RANGE, 512)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
                .add(EntityAttributes.GENERIC_ARMOR, 0.0)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5);
    }

}
