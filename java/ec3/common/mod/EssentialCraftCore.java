package ec3.common.mod;


import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.command.CommandHandler;
import net.minecraft.server.MinecraftServer;
import DummyCore.Core.Core;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ec3.common.block.BlocksCore;
import ec3.common.entity.EntitiesCore;
import ec3.common.item.ItemsCore;
import ec3.common.registry.AchievementRegistry;
import ec3.common.registry.BiomeRegistry;
import ec3.common.registry.BloodMagicRegistry;
import ec3.common.registry.CoreRegistry;
import ec3.common.registry.DimensionRegistry;
import ec3.common.registry.EnchantRegistry;
import ec3.common.registry.PotionRegistry;
import ec3.common.registry.RecipeRegistry;
import ec3.common.registry.ResearchRegistry;
import ec3.common.registry.SpellRegistry;
import ec3.common.registry.StructureRegistry;
import ec3.common.registry.VillagersRegistry;
import ec3.common.world.WorldGenManager;
import ec3.integration.versionChecker.Check;
import ec3.integration.waila.WailaInitialiser;
import ec3.network.proxy.CommonProxy;
import ec3.utils.cfg.Config;
import ec3.utils.common.CommandCreateMRUCU;
import ec3.utils.common.CommandSetBalance;
import ec3.utils.common.CommandSetMRU;

@Mod(
		modid = EssentialCraftCore.modid,
		name = "EssentialCraftIII",
		version = EssentialCraftCore.version,
		dependencies = "required-after:DummyCore@[1.10,);",
		guiFactory = "ec3.client.regular.ModConfigGuiHandler"
	)
public class EssentialCraftCore {

//============================================CORE START=================================================//
	
//============================================CORE VARS==================================================//
	//TODO Variables
	public static EssentialCraftCore core;
	@SidedProxy(clientSide = "ec3.network.proxy.ClientProxy", serverSide = "ec3.network.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static Config cfg = new Config();
	public static final String version = "4.4.1710.37";
	public static final String modid = "essentialcraft";
//============================================CORE FUNCTIONS=============================================//

	
//============================================CORE MOD===================================================//
	//TODO Mod
	@EventHandler
	public void serverStart(FMLServerStartingEvent event)
    {
        MinecraftServer mcserver = event.getServer();
        ((CommandHandler)mcserver.getCommandManager()).registerCommand(new CommandSetMRU());
        ((CommandHandler)mcserver.getCommandManager()).registerCommand(new CommandSetBalance());
        ((CommandHandler)mcserver.getCommandManager()).registerCommand(new CommandCreateMRUCU());
        
    }
	
	@EventHandler
	public void beforeMinecraftLoaded(FMLPreInitializationEvent event)
	{
		event.getModMetadata().autogenerated=false;
		event.getModMetadata().modId="essentialcraft";
		event.getModMetadata().name="Essential Craft 3";
		event.getModMetadata().credits="Author: Modbder";
		event.getModMetadata().authorList=Arrays.asList(new String[]{"Modbder"});
		event.getModMetadata().description="Essential Craft 3 is a huge magic-themed mod, that adds lots of end-game content. [WARNING] This is a test version of the mod so it can break your world! Please, submit all the bugs to MCForum!";
		event.getModMetadata().url="http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2286105-1-7-10-forge-open-source-dummythinking-mods";
		event.getModMetadata().updateUrl="http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2286105-1-7-10-forge-open-source-dummythinking-mods";
		event.getModMetadata().logoFile="assets/essentialcraft/textures/special/logo.png";
		
		core = this;
		try
		{
			Core.registerModAbsolute(getClass(), "Essential Craft 3", event.getModConfigurationDirectory().getAbsolutePath(), cfg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return;
		}
		CoreRegistry.register();
		Check.checkerCommit();
		WailaInitialiser.sendIMC();
	}
	
	@EventHandler
	public void onMinecraftLoading(FMLInitializationEvent event)
	{
		DimensionRegistry.core.registerDimensionMagic();
		BlocksCore.instance.loadBlocks();
		ItemsCore.instance.loadItems();
		RecipeRegistry.instance.main();
		
		EnchantRegistry.register();
		VillagersRegistry.instance.register();
		BiomeRegistry.core.register();
		BlocksCore.postInitLoad();
		StructureRegistry.register();
		proxy.registerRenderInformation();
		proxy.registerTileEntitySpecialRenderer();
	}
	
	public static boolean clazzExists(String clazzName)
	{
		try
		{
			Class clazz = Class.forName(clazzName);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@EventHandler
	public void onMinecraftLoadingFinished(FMLPostInitializationEvent event)
	{
		EntitiesCore.registerEntities();
		BloodMagicRegistry.register();
		AchievementRegistry.register();
		PotionRegistry.registerPotions();
		GameRegistry.registerWorldGenerator(new WorldGenManager(), 16);
		cfg.postInitParseDecorativeBlocks();
		ResearchRegistry.init();
	}
}
