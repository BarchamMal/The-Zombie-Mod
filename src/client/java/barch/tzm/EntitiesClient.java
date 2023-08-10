package barch.tzm;

import barch.tzm.Entities.ModdedZombieEntity;
import barch.tzm.render.ZombieRendererFactory;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

import static barch.tzm.Entities.Entities.*;
import static barch.tzm.TheZombieMod.NAMESPACE;

public class EntitiesClient {

    public static final EntitiesClient INSTANCE = new EntitiesClient();


    // -------------------- model layers

    public static final EntityModelLayer MODEL_SOGGY_ZOMBIE_LAYER = CreateModel("soggy_zombie");
    public static final EntityModelLayer MODEL_FROZEN_ZOMBIE_LAYER = CreateModel("frozen_zombie");
    public static final EntityModelLayer MODEL_SCORCHED_ZOMBIE_LAYER = CreateModel("scorched_zombie");
    public static final EntityModelLayer MODEL_DRY_ZOMBIE_LAYER = CreateModel("dry_zombie");
    public static final EntityModelLayer MODEL_FOOLISH_ZOMBIE_LAYER = CreateModel("foolish_zombie");
    public static final EntityModelLayer MODEL_FIERY_ZOMBIE_LAYER = CreateModel("fiery_zombie");
    public static final EntityModelLayer MODEL_FUNGAL_ZOMBIE_LAYER = CreateModel("fungal_zombie");
    public static final EntityModelLayer MODEL_RICH_ZOMBIE_LAYER = CreateModel("rich_zombie");
    public static final EntityModelLayer MODEL_SMART_ZOMBIE_LAYER = CreateModel("smart_zombie");
    public static final EntityModelLayer MODEL_STUPID_ZOMBIE_LAYER = CreateModel("stupid_zombie");

    // -------------------- model layers



    public static EntityModelLayer CreateModel(String name) {

        return new EntityModelLayer(new Identifier(NAMESPACE, name), "main");

    }

    public static void RegisterAll() {

        ZombieRendererFactory.BuildAndRegisterRenderer("soggy_zombie", (EntityType<ModdedZombieEntity>) SOGGY_ZOMBIE);
        ZombieRendererFactory.BuildAndRegisterRenderer("frozen_zombie", (EntityType<ModdedZombieEntity>) FROZEN_ZOMBIE);
        ZombieRendererFactory.BuildAndRegisterRenderer("scorched_zombie", (EntityType<ModdedZombieEntity>) SCORCHED_ZOMBIE);
        ZombieRendererFactory.BuildAndRegisterRenderer("dry_zombie", (EntityType<ModdedZombieEntity>) DRY_ZOMBIE);
        ZombieRendererFactory.BuildAndRegisterRenderer("foolish_zombie", (EntityType<ModdedZombieEntity>) FOOLISH_ZOMBIE);
        ZombieRendererFactory.BuildAndRegisterRenderer("fiery_zombie", (EntityType<ModdedZombieEntity>) FIERY_ZOMBIE);
        ZombieRendererFactory.BuildAndRegisterRenderer("fungal_zombie", (EntityType<ModdedZombieEntity>) FUNGAL_ZOMBIE);
        ZombieRendererFactory.BuildAndRegisterRenderer("rich_zombie", (EntityType<ModdedZombieEntity>) RICH_ZOMBIE);
        ZombieRendererFactory.BuildAndRegisterRenderer("smart_zombie", (EntityType<ModdedZombieEntity>) SMART_ZOMBIE);
        ZombieRendererFactory.BuildAndRegisterRenderer("stupid_zombie", (EntityType<ModdedZombieEntity>) STUPID_ZOMBIE);

        EntityModelLayerRegistry.registerModelLayer(MODEL_SOGGY_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_FROZEN_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SCORCHED_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_DRY_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_FOOLISH_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_FIERY_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_FUNGAL_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_RICH_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SMART_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_STUPID_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);

    }

}
