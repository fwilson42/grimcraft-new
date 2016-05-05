/*
 * Grimcraft.java 1.0.0 8-13-2015
 * Made with love by Lapiman and Fox
 * Licensed under whatever we decide
 * 
 * to do:
 * hunt down any Block == Block and replace with .equals()
 */

package us.thinkplank.grimcraft;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import us.thinkplank.grimcraft.block.GrimcraftBlocks;
import us.thinkplank.grimcraft.item.GrimcraftItems;
import us.thinkplank.grimcraft.mobs.EntityBoar;
import us.thinkplank.grimcraft.mobs.EntityPhoenix;
import us.thinkplank.grimcraft.mobs.ModelBoar;
import us.thinkplank.grimcraft.mobs.ModelPhoenix;
import us.thinkplank.grimcraft.mobs.RenderBoar;
import us.thinkplank.grimcraft.mobs.RenderPhoenix;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="grimcraft", name="grimcraft", version="1.0.0")
public class Grimcraft {
    @Instance("Grimcraft")
    public Configuration config;
	
    public static Grimcraft instance;

    @SidedProxy(clientSide="us.thinkplank.grimcraft.client.ClientProxy", serverSide="us.thinkplank.grimcraft.CommonProxy")
        public static CommonProxy proxy;
	

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	this.config = new Configuration(event.getSuggestedConfigurationFile());
    	GrimcraftBlocks.register();
        GrimcraftItems.register();
        GrimcraftRecipes.register();
        GameRegistry.registerFuelHandler(new GrimcraftFuelHandler());
        GameRegistry.registerWorldGenerator(new GrimcraftWorldGenerator(), 20);
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
    	MinecraftForge.EVENT_BUS.register(new GrimcraftEventHandler());
    	
    	OreDictionary.registerOre("oreFossilstone", GrimcraftBlocks.fossilstone_ore);
    	OreDictionary.registerOre("oreCoal", GrimcraftBlocks.nether_coal_ore);
    	OreDictionary.registerOre("oreGold", GrimcraftBlocks.nether_gold_ore);
    	OreDictionary.registerOre("oreRedstone", GrimcraftBlocks.nether_redstone_ore);
    	OreDictionary.registerOre("oreSulfur", GrimcraftBlocks.brimstone_ore); //makes brimstone work as sulfur
    	
    	//TODO do boars spawn at all...?
    
    	EntityRegistry.registerGlobalEntityID(EntityBoar.class, "boar", EntityRegistry.findGlobalUniqueEntityId(), 0xA26C60, 0x8C3519);
    	EntityRegistry.registerModEntity(EntityBoar.class, "boar", EntityRegistry.findGlobalUniqueEntityId(), this, 80, 1, true);
    	RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new RenderBoar(new ModelBoar(), 0.5F));
    	
    	EntityRegistry.registerGlobalEntityID(EntityPhoenix.class, "phoenix", EntityRegistry.findGlobalUniqueEntityId(), 0x383838, 0x9e2d08);
    	EntityRegistry.registerModEntity(EntityPhoenix.class, "phoenix", EntityRegistry.findGlobalUniqueEntityId(), this, 80, 1, true);
    	RenderingRegistry.registerEntityRenderingHandler(EntityPhoenix.class, new RenderPhoenix(new ModelPhoenix(), 0.5F));
    	
    	EntityRegistry.addSpawn(EntityCaveSpider.class, 75, 1, 3, EnumCreatureType.monster, BiomeGenBase.hell);
    	EntityRegistry.addSpawn(EntityEnderman.class, 75, 1, 1, EnumCreatureType.monster, BiomeGenBase.hell);
    	EntityRegistry.addSpawn(EntityBoar.class, 100, 1, 3, EnumCreatureType.monster, BiomeGenBase.hell);
    	EntityRegistry.addSpawn(EntityPhoenix.class, 100, 1, 3, EnumCreatureType.monster, BiomeGenBase.hell);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
}
