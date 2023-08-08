package barch.tzm;

import net.fabricmc.api.ClientModInitializer;

public class TheZombieModClient implements ClientModInitializer {

	public static final EntitiesClient ENTITIES = EntitiesClient.INSTANCE;

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		ENTITIES.RegisterAll();

	}
}