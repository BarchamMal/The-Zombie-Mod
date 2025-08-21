package barch.tzm.Entities;

import barch.tzm.Config.TheZombieModConfigManager;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Objects;

import static barch.tzm.Entities.Tags.BiomeTags.*;
import static barch.tzm.TheZombieMod.NAMESPACE;
import static barch.tzm.TheZombieMod.THE_ZOMBIE_MOD;
import static barch.tzm.TheZombieMod.LOGGER;

public class Entities {

    // -------------- Entities

    public static final EntityType<? extends ZombieEntity> SOGGY_ZOMBIE = CreateZombieEntity("soggy", "slime");
    public static final EntityType<? extends ZombieEntity> FROZEN_ZOMBIE = CreateZombieEntity("frozen", "cold");
    public static final EntityType<? extends ZombieEntity> SCORCHED_ZOMBIE = CreateZombieEntity("scorched", "fire");
    public static final EntityType<? extends ZombieEntity> DRY_ZOMBIE = CreateZombieEntity("dry", "norm");
    public static final EntityType<? extends ZombieEntity> FOOLISH_ZOMBIE = CreateZombieEntity("foolish", "norm");
    public static final EntityType<? extends ZombieEntity> FIERY_ZOMBIE = CreateZombieEntity("fiery", "fire");
    public static final EntityType<? extends ZombieEntity> FUNGAL_ZOMBIE = CreateZombieEntity("fungal", "slime");
    public static final EntityType<? extends ZombieEntity> RICH_ZOMBIE = CreateZombieEntity("rich", "norm");
    public static final EntityType<? extends ZombieEntity> SMART_ZOMBIE = CreateZombieEntity("smart", "norm");
    public static final EntityType<? extends ZombieEntity> STUPID_ZOMBIE = CreateZombieEntity("stupid", "norm");
    public static final EntityType<? extends ZombieEntity> HUNGRY_ZOMBIE = CreateZombieEntity("hungry", "norm");

    // -------------- Entities




    // -------------- Items



    public static final Item SOGGY_ZOMBIE_SPAWN_EGG = register("soggy", SOGGY_ZOMBIE);
    public static final Item FROZEN_ZOMBIE_SPAWN_EGG = register("frozen", FROZEN_ZOMBIE);
    public static final Item SCORCHED_ZOMBIE_SPAWN_EGG = register("scorched", SCORCHED_ZOMBIE);
    public static final Item DRY_ZOMBIE_SPAWN_EGG = register("dry", DRY_ZOMBIE);
    public static final Item FOOLISH_ZOMBIE_SPAWN_EGG = register("foolish", FOOLISH_ZOMBIE);
    public static final Item FIERY_ZOMBIE_SPAWN_EGG = register("fiery", FIERY_ZOMBIE);
    public static final Item FUNGAL_ZOMBIE_SPAWN_EGG = register("fungal", FUNGAL_ZOMBIE);
    public static final Item RICH_ZOMBIE_SPAWN_EGG = register("rich", RICH_ZOMBIE);
    public static final Item SMART_ZOMBIE_SPAWN_EGG = register("smart", SMART_ZOMBIE);
    public static final Item STUPID_ZOMBIE_SPAWN_EGG = register("stupid", STUPID_ZOMBIE);
    public static final Item HUNGRY_ZOMBIE_SPAWN_EGG = register("hungry", HUNGRY_ZOMBIE);

    // -------------- Items

    private static EntityType<? extends ZombieEntity> CreateZombieEntity(String name, String type) {
        Identifier id = Identifier.of(NAMESPACE, name+"_zombie");
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE,  id);


        if (Objects.equals(type, "fire")) {

            return Registry.register(
                    Registries.ENTITY_TYPE,
                    key,
                    EntityType.Builder.create(FireZombieEntity::new, SpawnGroup.MONSTER).dimensions(.6f, 1.99f).maxTrackingRange(96).build(key)
            );

        }

        if (Objects.equals(type, "cold")) {

            return Registry.register(
                    Registries.ENTITY_TYPE,
                    key,
                    EntityType.Builder.create(ColdZombieEntity::new, SpawnGroup.MONSTER).dimensions(.6f, 1.99f).maxTrackingRange(96).build(key)
            );

        }

        if (Objects.equals(type, "slime")) {

            return Registry.register(
                    Registries.ENTITY_TYPE,
                    key,
                    EntityType.Builder.create(SlimeZombieEntity::new, SpawnGroup.MONSTER).dimensions(.6f, 1.99f).maxTrackingRange(96).build(key)
            );

        }

        return Registry.register(
                Registries.ENTITY_TYPE,
                key,
                EntityType.Builder.create(ModdedZombieEntity::new, SpawnGroup.MONSTER).dimensions(.6f, 1.99f).maxTrackingRange(96).build(key)
        );

    }

    public static void doSomething() {
        RegisterEntities();
        GroupItems();
    }

    public static Item register(String name, EntityType<? extends MobEntity> type) {
        Identifier id = Identifier.of(NAMESPACE, name+"_zombie_spawn_egg");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                key,
                new SpawnEggItem(type, new Item.Settings().registryKey(key))
        );
    }

    public static void GroupItems() {

        addToGroup(SOGGY_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        addToGroup(FROZEN_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        addToGroup(SCORCHED_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        addToGroup(DRY_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        addToGroup(FOOLISH_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        addToGroup(FIERY_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        addToGroup(FUNGAL_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        addToGroup(RICH_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        addToGroup(SMART_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        addToGroup(STUPID_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        addToGroup(HUNGRY_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);

    }

    public static void RegisterEntities() {
        int weight;

        if (TheZombieModConfigManager.getConfig().zombiesTakeOver) {
            weight = 100000;
        }
        else {
            weight = 2;
        }

        FabricDefaultAttributeRegistry.register(SOGGY_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(SCORCHED_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(DRY_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(FOOLISH_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(FIERY_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(FUNGAL_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(RICH_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(SMART_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(STUPID_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());
        FabricDefaultAttributeRegistry.register(HUNGRY_ZOMBIE, ModdedZombieEntity.createModdedZombieAttributes());


        BiomeModifications.addSpawn(BiomeSelectors.tag(HUMID_HOT), SpawnGroup.MONSTER, SOGGY_ZOMBIE, weight, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(COLD), SpawnGroup.MONSTER, FROZEN_ZOMBIE, weight, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, SCORCHED_ZOMBIE, weight, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(HOT_DRY), SpawnGroup.MONSTER, DRY_ZOMBIE, weight, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(GOLD), SpawnGroup.MONSTER, FOOLISH_ZOMBIE, weight, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, FIERY_ZOMBIE, weight, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(MUSHROOM), SpawnGroup.MONSTER, FUNGAL_ZOMBIE, weight, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, RICH_ZOMBIE, weight, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, SMART_ZOMBIE, weight, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, STUPID_ZOMBIE, weight, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, HUNGRY_ZOMBIE, weight, 1, 4);

        LOGGER.info("Registered zombie spawning with a weight of " + weight);

    }

    private static void addToGroup(Item item, Item before, RegistryKey<ItemGroup> group) {

        ItemGroupEvents.modifyEntriesEvent(THE_ZOMBIE_MOD).register(content -> {
            content.add(item);
        });
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            content.addAfter(before, item);
        });

    }

}
