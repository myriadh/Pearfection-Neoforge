package net.digitalpear.pearfection;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.digitalpear.pearfection.block.ModBlocks;
import net.digitalpear.pearfection.item.ModItems;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion.MOD_ID;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Pearfection.MOD_ID)
public class Pearfection {
    public static final String MOD_ID = "pearfection";
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Pearfection(@NotNull IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (Pearfection) to respond directly to events.

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.CALLERY_PLANKS);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.CALLERY_LOG);
        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.CALLERY_LOG);

        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModItems.PEAR_TART);

        }

    }

}
