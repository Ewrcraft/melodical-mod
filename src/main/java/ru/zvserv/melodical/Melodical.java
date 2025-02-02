package ru.zvserv.melodical;

import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;


public class Melodical implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Melodical");

	public static final String MOD_ID = "melodical";

    @Override
    public void onInitialize(ModContainer mod) {
        LOGGER.info("Hello Quilt world from {}! Stay fresh!", mod.metadata().name());
		MelodicalItems.registerAll();
    }
}
