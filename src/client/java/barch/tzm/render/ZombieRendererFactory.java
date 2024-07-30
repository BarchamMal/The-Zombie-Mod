package barch.tzm.render;

import barch.tzm.Entities.ModdedZombieEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

import static barch.tzm.TheZombieMod.NAMESPACE;

public class ZombieRendererFactory {

    public static void BuildAndRegisterRenderer(String name, EntityType<ModdedZombieEntity> entityType) {

        String NAME = name;

         class Renderer extends net.minecraft.client.render.entity.ZombieEntityRenderer {
            public Renderer(EntityRendererFactory.Context context) {
                super(context);
            }

            private Identifier TEXTURE = Identifier.of(NAMESPACE, "textures/entity/zombies/"+NAME+".png");


            public Identifier getTexture(ZombieEntity zombieEntity) {
                return TEXTURE;
            }

        }

        EntityRendererRegistry.register(entityType, Renderer::new);

    }


}
