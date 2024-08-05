package barch.tzm.Config;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

public class TheZombieModConfig {
    @Comment("The amount of health zombies have. DEFAULT: [5]")
    public int zombieHealth = 5;

    @Comment("Zombies replace normal enemies. If true, they will spawn practicaly replacing all normal overworld enemies. If false, they will spawn ofter butonly like most nermal mobs. DEFAULT [true]")
    public Boolean zombiesTakeOver = true;

}