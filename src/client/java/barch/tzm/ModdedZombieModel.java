package barch.tzm;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.ZombieEntityModel;

public class ModdedZombieModel extends ZombieEntityModel {

    public ModdedZombieModel(ModelPart modelPart) {
        super(modelPart);
    }


    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(getModelData(Dilation.NONE, 0), 64, 64);
    }
}
