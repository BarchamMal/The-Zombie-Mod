package barch.tzm.ModBlocks;

import net.barch.barch_lib.Blocks.BlockBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static barch.tzm.TheZombieMod.NAMESPACE;

public class ModBlocks {

    public static final Block SLIME_LAYER = register("slime_layer", SnowBlock::new, BlockBuilder.CloneBlock(Blocks.SNOW).notSolid().sounds(BlockSoundGroup.SLIME));


    public static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(NAMESPACE, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        return Registry.register(
                Registries.BLOCK,
                key,
                factory.apply(settings.registryKey(key))
        );
    }

    public static void doNothing() {

    }
}
