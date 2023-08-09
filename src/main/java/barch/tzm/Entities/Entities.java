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

import static barch.tzm.Entities.Tags.BiomeTags.*;
import static barch.tzm.TheZombieMod.NAMESPACE;
import static barch.tzm.TheZombieMod.THE_ZOMBIE_MOD;

public class Entities {

    public static final Entities INSTANCE = new Entities();

    // -------------- Entities

    public static final EntityType<ModdedZombieEntity> SOGGY_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "soggy_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
    );
    public static final EntityType<ModdedZombieEntity> FROZEN_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "frozen_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
    );
    public static final EntityType<ModdedZombieEntity> SCORCHED_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "scorched_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
    );
    public static final EntityType<ModdedZombieEntity> DRY_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "dry_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
    );
    public static final EntityType<ModdedZombieEntity> FOOLISH_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "foolish_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
    );
    public static final EntityType<ModdedZombieEntity> FIERY_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "fiery_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
    );
    public static final EntityType<ModdedZombieEntity> FUNGAL_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "fungal_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
    );
    public static final EntityType<ModdedZombieEntity> RICH_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NAMESPACE, "rich_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ModdedZombieEntity::new).dimensions(EntityDimensions.changing(.6f, 1.99f)).build()
    );

    // -------------- Entities




    // -------------- Items

    // zombie colors are 0x00AAA7, 0x799C65

    public static final Item SOGGY_ZOMBIE_SPAWN_EGG = new SpawnEggItem(SOGGY_ZOMBIE, 0x00CCA7, 0x79AE65, new FabricItemSettings());
    public static final Item FROZEN_ZOMBIE_SPAWN_EGG = new SpawnEggItem(FROZEN_ZOMBIE, 0x00AAC9, 0x799C87, new FabricItemSettings());
    public static final Item SCORCHED_ZOMBIE_SPAWN_EGG = new SpawnEggItem(SCORCHED_ZOMBIE, 0x009A77, 0x496C35, new FabricItemSettings());
    public static final Item DRY_ZOMBIE_SPAWN_EGG = new SpawnEggItem(DRY_ZOMBIE, 0x40EAA7, 0xB9DC65, new FabricItemSettings());
    public static final Item FOOLISH_ZOMBIE_SPAWN_EGG = new SpawnEggItem(FOOLISH_ZOMBIE, 0x208A87, 0x997C45, new FabricItemSettings());
    public static final Item FIERY_ZOMBIE_SPAWN_EGG = new SpawnEggItem(FIERY_ZOMBIE, 0x406A67, 0xA95C25, new FabricItemSettings());
    public static final Item FUNGAL_ZOMBIE_SPAWN_EGG = new SpawnEggItem(FUNGAL_ZOMBIE, 0xBE2321, 0x977251, new FabricItemSettings());
    public static final Item RICH_ZOMBIE_SPAWN_EGG = new SpawnEggItem(RICH_ZOMBIE, 0x00AAA7, 0xB9DC65, new FabricItemSettings());

    // -------------- Items


    public static void RegisterAll() {

        RegisterEntities();
        RegisterItems();
        GroupItems();

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "soggy_zombie_spawn_egg"), SOGGY_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "frozen_zombie_spawn_egg"), FROZEN_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "scorched_zombie_spawn_egg"), SCORCHED_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "dry_zombie_spawn_egg"), DRY_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "foolish_zombie_spawn_egg"), FOOLISH_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "fiery_zombie_spawn_egg"), FIERY_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "fungal_zombie_spawn_egg"), FUNGAL_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "rich_zombie_spawn_egg"), RICH_ZOMBIE_SPAWN_EGG);

    }

    public static void GroupItems() {

        INSTANCE.addToGroup(SOGGY_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        INSTANCE.addToGroup(FROZEN_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        INSTANCE.addToGroup(SCORCHED_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        INSTANCE.addToGroup(DRY_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        INSTANCE.addToGroup(FOOLISH_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        INSTANCE.addToGroup(FIERY_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        INSTANCE.addToGroup(FUNGAL_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);
        INSTANCE.addToGroup(RICH_ZOMBIE_SPAWN_EGG,Items.ZOMBIE_SPAWN_EGG,ItemGroups.SPAWN_EGGS);

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


        BiomeModifications.addSpawn(BiomeSelectors.tag(HUMID_HOT), SpawnGroup.MONSTER, SOGGY_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(COLD), SpawnGroup.MONSTER, FROZEN_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, SCORCHED_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(HOT_DRY), SpawnGroup.MONSTER, DRY_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(GOLD), SpawnGroup.MONSTER, FOOLISH_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, FIERY_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(MUSHROOM), SpawnGroup.MONSTER, FUNGAL_ZOMBIE, 1000, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ZOMBIES_SPAWN_IN), SpawnGroup.MONSTER, RICH_ZOMBIE, 1000, 1, 4);


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
