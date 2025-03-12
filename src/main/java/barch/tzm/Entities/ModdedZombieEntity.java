package barch.tzm.Entities;

import barch.tzm.Config.TheZombieModConfigManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import static barch.tzm.Entities.Entities.SOGGY_ZOMBIE;

public class ModdedZombieEntity extends ZombieEntity {


    public ModdedZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createModdedZombieAttributes() {
        return HostileEntity.createHostileAttributes().add(
                EntityAttributes.FOLLOW_RANGE, 96)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.ATTACK_DAMAGE, 2)
                .add(EntityAttributes.ARMOR, 0.0)
                .add(EntityAttributes.SPAWN_REINFORCEMENTS, 0)
                .add(EntityAttributes.MAX_HEALTH, TheZombieModConfigManager.getConfig().zombieHealth);
    }

    protected void convertInWater() {
        this.convertTo(SOGGY_ZOMBIE);
        if (!this.isSilent()) {
            this.getWorld().syncWorldEvent((PlayerEntity)null, 1040, this.getBlockPos(), 0);
        }
    }

    @Override
    protected boolean canConvertInWater() {
        return super.canConvertInWater();
    }

    @Override
    public boolean isConvertingInWater() {
        return super.isConvertingInWater();
    }
}
