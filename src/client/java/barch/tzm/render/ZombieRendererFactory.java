package barch.tzm.render;

import barch.tzm.Entities.ModdedZombieEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

import static barch.tzm.TheZombieMod.NAMESPACE;

public class ZombieRendererFactory {

    public static void BuildAndRegisterRenderer(String name, EntityType<ModdedZombieEntity> entityType) {

        String NAME = name;

         class Renderer extends ZombieEntityRenderer {
            public Renderer(EntityRendererFactory.Context context) {
                super(context);
            }

            private Identifier TEXTURE = Identifier.of(NAMESPACE, "textures/entity/zombie/"+NAME+".png");


             @Override
             public Identifier getTexture(ZombieEntityRenderState zombieEntityRenderState) {
                 return TEXTURE;
             }

             public ZombieEntityRenderState createRenderState() {
                return new ZombieEntityRenderState();
            }

        }

        EntityRendererRegistry.register(entityType, Renderer::new);

    }


}
