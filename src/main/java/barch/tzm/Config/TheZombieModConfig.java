package barch.tzm.Config;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

public class TheZombieModConfig {
    @Comment("The amount of health zombies have. DEFAULT: [5]")
    public int zombieHealth = 5;

    @Comment("Zombies replace normal enemies. If true, they will spawn practically replacing all normal overworld enemies. If false, they will spawn often but only like most normal mobs. DEFAULT [true]")
    public Boolean zombiesTakeOver = true;

}