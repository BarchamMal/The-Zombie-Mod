package barch.tzm.Entities;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static barch.tzm.Entities.Tags.BiomeTags.COLD;
import static barch.tzm.Entities.Tags.BiomeTags.HUMID_HOT;
import static barch.tzm.TheZombieMod.NAMESPACE;
import static barch.tzm.TheZombieMod.THE_ZOMBIE_MOD;

public class Entities {

    public static final Entities INSTANCE = new Entities();

    // -------------- Entities

    // soggy_zombie
    public static final EntityType<ModdedZombieEntity> SOGGY_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "soggy_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
    );

    // frozen_zombie
    public static final EntityType<ModdedZombieEntity> FROZEN_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "frozen_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
    );

    // -------------- Entities




    // -------------- Items

    public static final Item SOGGY_ZOMBIE_SPAWN_EGG = new SpawnEggItem(SOGGY_ZOMBIE, 0x00CCA7, 0x79AE65, new FabricItemSettings());
    public static final Item FROZEN_ZOMBIE_SPAWN_EGG = new SpawnEggItem(FROZEN_ZOMBIE, 0x00AAC9, 0x799C87, new FabricItemSettings());

    // -------------- Items


    public static void RegisterAll() {

        RegisterEntities();
        RegisterItems();
        GroupItems();

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "soggy_zombie_spawn_egg"), SOGGY_ZOMBIE_SPAWN_EGG);

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "frozen_zombie_spawn_egg"), FROZEN_ZOMBIE_SPAWN_EGG);

    }

    public static void GroupItems() {

        INSTANCE.addToGroup(SOGGY_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        INSTANCE.addToGroup(FROZEN_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);

    }

    public static void RegisterEntities() {

        FabricDefaultAttributeRegistry.register(SOGGY_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());


        BiomeModifications.addSpawn(BiomeSelectors.tag(HUMID_HOT), SpawnGroup.MONSTER, SOGGY_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(COLD), SpawnGroup.MONSTER, FROZEN_ZOMBIE, 1000, 1, 4);


    }

    private void addToGroup(Item item, Item before, RegistryKey<ItemGroup> group) {

        ItemGroupEvents.modifyEntriesEvent(THE_ZOMBIE_MOD).register(content -> {
            content.add(item);
        });
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            content.addAfter(before, item);
        });

    }

}
