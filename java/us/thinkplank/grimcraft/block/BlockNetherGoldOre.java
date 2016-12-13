package us.thinkplank.grimcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNetherGoldOre extends Block {
    public BlockNetherGoldOre () {
        super(Material.ROCK);
        setHardness(3F);
        setSoundType(SoundType.STONE);
        setRegistryName("nether_gold_ore");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHarvestLevel("pickaxe", 1);
    }
}
