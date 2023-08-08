package barch.tzm.Entities;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import static barch.tzm.TheZombieMod.NAMESPACE;

public class Tags {

    public static class BiomeTags {


        public static final TagKey<Biome> HUMID_HOT = ofBiome(NAMESPACE,"humid_hot");
        public static final TagKey<Biome> HOT_DRY = ofBiome(NAMESPACE,"hot_dry");
        public static final TagKey<Biome> COLD = ofBiome(NAMESPACE,"cold");


    }

    private static TagKey<Biome> ofBiome(String namespace, String path) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(namespace, path));
    }
    private static TagKey<Block> ofBlock(String namespace, String path) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(namespace, path));
    }
    private static TagKey<Item> ofItem(String namespace, String path) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(namespace, path));
    }

}
