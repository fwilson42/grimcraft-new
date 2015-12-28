/*
* modified from code generated by MrPonyCaptain's
* .schematic to .java converting tool v2.0
*/

package us.thinkplank.grimcraft;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenNetherLair extends WorldGenerator implements IWorldGenerator {
	
	//WeightedRandomChestContent(Item, meta, min stack size, max stack size, freq)
    public static final WeightedRandomChestContent[] loot = new WeightedRandomChestContent[] {
    	new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 10), 
    	new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 4, 10), 
    	new WeightedRandomChestContent(Items.bread, 0, 1, 1, 10), 
    	new WeightedRandomChestContent(Items.wheat, 0, 1, 4, 10), 
    	new WeightedRandomChestContent(Items.gunpowder, 0, 1, 4, 10), 
    	new WeightedRandomChestContent(Items.string, 0, 1, 4, 10), 
    	new WeightedRandomChestContent(Items.bucket, 0, 1, 1, 10), 
    	new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 1), 
    	new WeightedRandomChestContent(Items.redstone, 0, 1, 4, 10), 
    	new WeightedRandomChestContent(Items.record_13, 0, 1, 1, 10), 
    	new WeightedRandomChestContent(Items.record_cat, 0, 1, 1, 10), 
    	new WeightedRandomChestContent(Items.name_tag, 0, 1, 1, 10), 
    	new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 2), 
    	new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 5), 
    	new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1)
    };
	
	Block air = Blocks.air;
	Block brick = Blocks.nether_brick;
	Block tnt = Blocks.tnt;
	Block sand = Blocks.soul_sand;
	Block lava = Blocks.lava;
	Block torch = Blocks.redstone_torch;
	Block chest = Blocks.trapped_chest;
	Block wart = Blocks.nether_wart;
	
	Block[][] layer7 = {
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, brick, air, air, air, air, air, brick, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
	};
	
	Block[][] layer6 = {
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{brick, brick, brick, air, brick, air, brick, brick, brick},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
	};
	
	Block[][] layer5 = {
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, brick, brick, brick, brick, brick, brick, brick, air},
		{air, brick, brick, brick, brick, brick, brick, brick, air},
		{air, brick, brick, brick, brick, brick, brick, brick, air},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, lava, brick, brick, brick, brick, brick, lava, brick},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
	};
	
	Block[][] layer4 = {
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{air, air, air, brick, air, brick, air, air, air},
		{air, air, air, air, air, air, air, air, air}
	};
	
	Block[][] layer3 = {
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, brick, torch, brick, brick, brick, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, brick, brick, brick, air, brick, brick, brick, brick},
		{air, air, air, brick, air, brick, air, air, air},
		{air, air, air, air, air, air, air, air, air}
	};
	
	Block[][] layer2 = {
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, torch, chest, torch, brick, brick, brick},
		{brick, wart, wart, air, air, air, wart, wart, brick},
		{brick, wart, air, air, air, air, air, wart, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, brick, brick, brick, air, brick, brick, brick, brick},
		{air, air, air, brick, air, brick, air, air, air},
		{air, air, air, air, air, air, air, air, air}
	};
	
	Block[][] layer1 = {
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, brick, tnt, brick, brick, brick, brick},
		{brick, sand, sand, brick, brick, brick, sand, sand, brick},
		{brick, sand, brick, brick, brick, brick, brick, sand, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, air, brick, brick, brick, brick, brick, air, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick}
	};
	
	Block[][] layer0 = {
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, brick, air, air, air, air, air, brick, air},
		{air, air, air, air, air, air, air, air, air},
	};
	
	protected Block[] getValidSpawnBlocks() {
		return new Block[] {
			Blocks.netherrack,
			Blocks.soul_sand
		};
	}

	public boolean locationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		Block check = world.getBlock(i, j, k);

		while (check != Blocks.air){
			if (distanceToAir > 3) {
				return false;
			}

			distanceToAir++;
			check = world.getBlock(i, j + distanceToAir, k);
		}

		j += distanceToAir - 1;

		Block block = world.getBlock(i, j, k);
		Block blockAbove = world.getBlock(i, j+1, k);
		Block blockBelow = world.getBlock(i, j-1, k);
		
		for (Block x : getValidSpawnBlocks()){
			if (blockAbove != Blocks.air){
				return false;
			}
			if (block == x) {
				return true;
			} else if (block == Blocks.snow && blockBelow == x) {
				return true;
			}
		}
		
		return false;
	}

	public WorldGenNetherLair() {
		
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
	}
	
	private void fillChest(World world, Random rand, int x, int y, int z) {
		TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y, z);
		
		if (chest != null) {
			//8 = number of stacks to put in the chest
			WeightedRandomChestContent.generateChestContents(rand, loot, chest, 8);
		}
	}
	
	private void setBlocksInArray(Block[][] array, int height, int i, int j, int k, World world, Random rand, int rotateNum) {
		for (int x = 0; x < rotateNum; x++) {
			array = rotateMatrix(array);
		}
		
		for (int x = 0; x < array.length; x++) {
			for (int z = 0; z < array[0].length; z++) {
				world.setBlock(i + x, j + height, k + z, array[x][z]);
				
				if (array[x][z] == chest) {
					fillChest(world, rand, i + x, j + height, k + z);
				}
			}
		}
	}
	
	private Block[][] rotateMatrix(Block[][] matrix) {
	    /* W and H are already swapped */
	    int w = matrix.length;
	    int h = matrix[0].length;   
	    Block[][] ret = new Block[h][w];
	    for (int i = 0; i < h; ++i) {
	        for (int j = 0; j < w; ++j) {
	            ret[i][j] = matrix[j][h - i - 1];
	        }
	    }
	    return ret;
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!locationIsValidSpawn(world, i, j, k) || !locationIsValidSpawn(world, i + 8, j, k) || !locationIsValidSpawn(world, i + 8, j, k + 8) || !locationIsValidSpawn(world, i, j, k + 8)) {
			return false;
		}

		k = k - 10;
		i = i - 10;
		
		// for debugging and finding the durn things
		for (int q = 0; q < 20; q++) {
			world.setBlock(i, j + q + 7, k, Blocks.diamond_block, 0, 0);
		}
		
		int rotateNum = (int) Math.floor(rand.nextDouble() * 4);
		
		setBlocksInArray(layer0, 0, i, j, k, world, rand, rotateNum);
		setBlocksInArray(layer1, 1, i, j, k, world, rand, rotateNum);
		setBlocksInArray(layer2, 2, i, j, k, world, rand, rotateNum);
		setBlocksInArray(layer3, 3, i, j, k, world, rand, rotateNum);
		setBlocksInArray(layer4, 4, i, j, k, world, rand, rotateNum);
		setBlocksInArray(layer5, 5, i, j, k, world, rand, rotateNum);
		setBlocksInArray(layer6, 6, i, j, k, world, rand, rotateNum);
		setBlocksInArray(layer7, 7, i, j, k, world, rand, rotateNum);
		
		return true;
	}
}