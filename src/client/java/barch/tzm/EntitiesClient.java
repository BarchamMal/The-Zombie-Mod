package barch.tzm;

import barch.tzm.render.ZombieRendererFactory;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.util.Identifier;

import static barch.tzm.Entities.Entities.FROZEN_ZOMBIE;
import static barch.tzm.Entities.Entities.SOGGY_ZOMBIE;
import static barch.tzm.TheZombieMod.NAMESPACE;

public class EntitiesClient {

    public static final EntitiesClient INSTANCE = new EntitiesClient();


    // -------------------- model layers

    public static final EntityModelLayer MODEL_SOGGY_ZOMBIE_LAYER = CreateModel("soggy_zombie");
    public static final EntityModelLayer MODEL_FROZEN_ZOMBIE_LAYER = CreateModel("frozen_zombie");

    // -------------------- model layers



    public static EntityModelLayer CreateModel(String name) {

        return new EntityModelLayer(new Identifier(NAMESPACE, name), "main");

    }

    public static void RegisterAll() {

        ZombieRendererFactory.BuildAndRegisterRenderer("soggy_zombie", SOGGY_ZOMBIE);
        ZombieRendererFactory.BuildAndRegisterRenderer("frozen_zombie", FROZEN_ZOMBIE);

        EntityModelLayerRegistry.registerModelLayer(MODEL_SOGGY_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);

        EntityModelLayerRegistry.registerModelLayer(MODEL_FROZEN_ZOMBIE_LAYER, ModdedZombieModel::getTexturedModelData);

    }

}
