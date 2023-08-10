package barch.tzm.Entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class FireZombieEntity extends ModdedZombieEntity{
    public FireZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean tryAttack(Entity target) {
        boolean bl = super.tryAttack(target);
        if (bl) {
            float f = this.getWorld().getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
            target.setOnFireFor(2 * (int)f);
        }

        return bl;
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (!this.getWorld().isClient) {

            boolean bl = this.burnsInDaylight() && this.isAffectedByDaylight();

            if (!this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                return;
            }

            BlockState blockState = Blocks.FIRE.getDefaultState();

            if  (random.nextBetween(1,2000) == 1) {

                for (int i = 0; i < 4; ++i) {
                    int j = MathHelper.floor(this.getX() + (double) ((float) (i % 2 * 2 - 1) * 0.25F));
                    int k = MathHelper.floor(this.getY());
                    int l = MathHelper.floor(this.getZ() + (double) ((float) (i / 2 % 2 * 2 - 1) * 0.25F));
                    BlockPos blockPos = new BlockPos(j, k, l);
                    if (this.getWorld().getBlockState(blockPos).isAir() && blockState.canPlaceAt(this.getWorld(), blockPos)) {
                        this.getWorld().setBlockState(blockPos, blockState);
                        this.getWorld().emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(this, blockState));

                    }
                }
            }
        }

    }

}

