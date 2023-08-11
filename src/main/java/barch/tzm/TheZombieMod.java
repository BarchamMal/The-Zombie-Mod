package barch.tzm;

import barch.tzm.Entities.Entities;
import barch.tzm.ModBlocks.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheZombieMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("the-zombie-mod");

	public static final String NAMESPACE = "the-zombie-mod";

	// MC-Extended
	public static final RegistryKey<ItemGroup> THE_ZOMBIE_MOD = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(NAMESPACE, "the-zombie-mod"));


	public static final Entities ENTITIES = Entities.INSTANCE;
	public static final ModBlocks MOD_BLOCKS = ModBlocks.INSTANCE;


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		// register the item groups
		Registry.register(Registries.ITEM_GROUP, THE_ZOMBIE_MOD, FabricItemGroup.builder()
				.icon(() -> new ItemStack(ENTITIES.SOGGY_ZOMBIE_SPAWN_EGG))
				.displayName(Text.translatable("itemGroup."+NAMESPACE+".the-zombie-mod"))
				.build());

		ENTITIES.RegisterAll();
		MOD_BLOCKS.RegisterAll();

	}
}