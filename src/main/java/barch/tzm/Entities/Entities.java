package barch.tzm.Entities;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.Objects;

import static barch.tzm.Entities.Tags.BiomeTags.*;
import static barch.tzm.TheZombieMod.NAMESPACE;
import static barch.tzm.TheZombieMod.THE_ZOMBIE_MOD;

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

    // zombie colors are 0x00AAA7, 0x799C65

    public static final Item SOGGY_ZOMBIE_SPAWN_EGG = new SpawnEggItem(SOGGY_ZOMBIE, 0x00CCA7, 0x79AE65, new Item.Settings());
    public static final Item FROZEN_ZOMBIE_SPAWN_EGG = new SpawnEggItem(FROZEN_ZOMBIE, 0x00AAC9, 0x799C87, new Item.Settings());
    public static final Item SCORCHED_ZOMBIE_SPAWN_EGG = new SpawnEggItem(SCORCHED_ZOMBIE, 0x009A77, 0x496C35, new Item.Settings());
    public static final Item DRY_ZOMBIE_SPAWN_EGG = new SpawnEggItem(DRY_ZOMBIE, 0x40EAA7, 0xB9DC65, new Item.Settings());
    public static final Item FOOLISH_ZOMBIE_SPAWN_EGG = new SpawnEggItem(FOOLISH_ZOMBIE, 0x208A87, 0x997C45, new Item.Settings());
    public static final Item FIERY_ZOMBIE_SPAWN_EGG = new SpawnEggItem(FIERY_ZOMBIE, 0x406A67, 0xA95C25, new Item.Settings());
    public static final Item FUNGAL_ZOMBIE_SPAWN_EGG = new SpawnEggItem(FUNGAL_ZOMBIE, 0xBE2321, 0x977251, new Item.Settings());
    public static final Item RICH_ZOMBIE_SPAWN_EGG = new SpawnEggItem(RICH_ZOMBIE, 0x00AAA7, 0xB9DC65, new Item.Settings());
    public static final Item SMART_ZOMBIE_SPAWN_EGG = new SpawnEggItem(SMART_ZOMBIE, 0x00AAA7, 0xFFEBB7, new Item.Settings());
    public static final Item STUPID_ZOMBIE_SPAWN_EGG = new SpawnEggItem(STUPID_ZOMBIE, 0x00AAA7, 0x444444, new Item.Settings());
    public static final Item HUNGRY_ZOMBIE_SPAWN_EGG = new SpawnEggItem(HUNGRY_ZOMBIE, 0x006663, 0x355821, new Item.Settings());

    // -------------- Items


    private static EntityType<? extends ZombieEntity> CreateZombieEntity(String name, String type) {

        if (Objects.equals(type, "fire")) {

            return Registry.register(
                    Registries.ENTITY_TYPE,
                    Identifier.of(NAMESPACE, name + "_zombie"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
            );

        }

        if (Objects.equals(type, "cold")) {

            return Registry.register(
                    Registries.ENTITY_TYPE,
                    Identifier.of(NAMESPACE, name + "_zombie"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ColdZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
            );

        }

        if (Objects.equals(type, "slime")) {

            return Registry.register(
                    Registries.ENTITY_TYPE,
                    Identifier.of(NAMESPACE, name + "_zombie"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SlimeZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
            );

        }

        return Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(NAMESPACE, name + "_zombie"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
        );

    }

    public static void RegisterAll() {

        RegisterEntities();
        RegisterItems();
        GroupItems();

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "soggy_zombie_spawn_egg"), SOGGY_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "frozen_zombie_spawn_egg"), FROZEN_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "scorched_zombie_spawn_egg"), SCORCHED_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "dry_zombie_spawn_egg"), DRY_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "foolish_zombie_spawn_egg"), FOOLISH_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "fiery_zombie_spawn_egg"), FIERY_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "fungal_zombie_spawn_egg"), FUNGAL_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "rich_zombie_spawn_egg"), RICH_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "smart_zombie_spawn_egg"), SMART_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "stupid_zombie_spawn_egg"), STUPID_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "hungry_zombie_spawn_egg"), HUNGRY_ZOMBIE_SPAWN_EGG);

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


        BiomeModifications.addSpawn(BiomeSelectors.tag(HUMID_HOT), SpawnGroup.MONSTER, SOGGY_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(COLD), SpawnGroup.MONSTER, FROZEN_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, SCORCHED_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(HOT_DRY), SpawnGroup.MONSTER, DRY_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(GOLD), SpawnGroup.MONSTER, FOOLISH_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, FIERY_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(MUSHROOM), SpawnGroup.MONSTER, FUNGAL_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, RICH_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, SMART_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, STUPID_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, HUNGRY_ZOMBIE, 1000, 1, 4);


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
