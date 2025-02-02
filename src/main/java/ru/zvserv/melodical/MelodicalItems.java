package ru.zvserv.melodical;

//import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import ru.zvserv.melodical.mixin.BrewingRecipeRegistryMixin;


public class MelodicalItems {

	public static final Item FLUTE = new Item(new QuiltItemSettings());
	public static final Item SIEVE = new Item(new QuiltItemSettings());
	public static final Item SKYSHARDS = new Item(new QuiltItemSettings());
	//public static final Item VINGARDIUM = new Item(new QuiltItemSettings());
	public static final Potion VINGARDIUM_LEVIOSSA = new Potion("levitation_potion", new StatusEffectInstance(StatusEffects.LEVITATION, 1200, 0));
	public static final Potion VINGARDIUM_LEVIOSSA_LONG = new Potion("levitation_potion_long", new StatusEffectInstance(StatusEffects.LEVITATION, 1800, 0));
	public static final Potion BAD_BASE = new Potion("strange_potion", new StatusEffectInstance(StatusEffects.POISON, 100, 0));


	public static void registerAll() {
		Registry.register(Registries.ITEM, new Identifier(Melodical.MOD_ID, "flute"), FLUTE);
		Registry.register(Registries.ITEM, new Identifier(Melodical.MOD_ID, "sieve"), SIEVE);
		Registry.register(Registries.ITEM, new Identifier(Melodical.MOD_ID, "skyshards"), SKYSHARDS);
		//Registry.register(Registries.ITEM, new Identifier(Melodical.MOD_ID, "vingardium"), VINGARDIUM);
		Registry.register(Registries.POTION, new Identifier(Melodical.MOD_ID, "levitation_potion"), VINGARDIUM_LEVIOSSA);
		registerRecipe(Potions.THICK, Items.DRAGON_BREATH, VINGARDIUM_LEVIOSSA);
		Registry.register(Registries.POTION, new Identifier(Melodical.MOD_ID, "levitation_potion_long"), VINGARDIUM_LEVIOSSA_LONG);
		registerRecipe(VINGARDIUM_LEVIOSSA, Items.REDSTONE, VINGARDIUM_LEVIOSSA_LONG);
		Registry.register(Registries.POTION, new Identifier(Melodical.MOD_ID, "strange_potion"), BAD_BASE);
		registerRecipe(Potions.WATER, Items.ROTTEN_FLESH, BAD_BASE);
	}

	private static void registerRecipe(Potion input, Item item, Potion output){
		if(output != null){
			BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(input, item, output);
		}
	}

}
