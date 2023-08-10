package barch.tzm.Entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class ColdZombieEntity extends ModdedZombieEntity{
    public ColdZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (!this.getWorld().isClient) {

            if (!this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                return;
            }

            BlockState blockState = Blocks.SNOW.getDefaultState();

            for(int i = 0; i < 4; ++i) {
                int j = MathHelper.floor(this.getX() + (double)((float)(i % 2 * 2 - 1) * 0.25F));
                int k = MathHelper.floor(this.getY());
                int l = MathHelper.floor(this.getZ() + (double)((float)(i / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockPos = new BlockPos(j, k, l);
                if (this.getWorld().getBlockState(blockPos).isAir() && blockState.canPlaceAt(this.getWorld(), blockPos)) {
                    this.getWorld().setBlockState(blockPos, blockState);
                    this.getWorld().emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(this, blockState));
                }
            }
        }

    }

}
