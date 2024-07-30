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
        public static final TagKey<Biome> WOODS = ofBiome(NAMESPACE,"woods");
        public static final TagKey<Biome> ZOMBIES_SPAWN_IN = ofBiome(NAMESPACE,"zombies_spawn_in");
        public static final TagKey<Biome> GOLD = ofBiome(NAMESPACE,"gold");
        public static final TagKey<Biome> MUSHROOM = ofBiome(NAMESPACE,"mushroom");


    }

    private static TagKey<Biome> ofBiome(String namespace, String path) {
        return TagKey.of(RegistryKeys.BIOME, Identifier.of(namespace, path));
    }
    private static TagKey<Block> ofBlock(String namespace, String path) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(namespace, path));
    }
    private static TagKey<Item> ofItem(String namespace, String path) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(namespace, path));
    }

}
