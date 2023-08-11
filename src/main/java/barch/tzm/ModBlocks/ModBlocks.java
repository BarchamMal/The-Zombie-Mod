package barch.tzm.ModBlocks;

import barch.tzm.Glue.BlockBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static barch.tzm.TheZombieMod.NAMESPACE;

public class ModBlocks {

    public static final ModBlocks INSTANCE = new ModBlocks();


    public static final Block SLIME_LAYER = new SnowBlock(BlockBuilder.CloneBlock(Blocks.SNOW).notSolid().sounds(BlockSoundGroup.SLIME));


    public static void RegisterAll() {

        RegisterBlocks();

    }

    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "slime_layer"), SLIME_LAYER);
    }
}
