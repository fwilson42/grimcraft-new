package us.thinkplank.grimcraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import us.thinkplank.grimcraft.mobs.EntityPhoenix;

public class ItemPhoenixEgg extends Item {
    public ItemPhoenixEgg() {
        super();
        setRegistryName("phoenix_egg");
        setUnlocalizedName("phoenix_egg");
    }
    
    @Override
    public EnumActionResult onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (itemStack == null) {
			return EnumActionResult.FAIL;
		} else if (player.canPlayerEdit(pos, facing, itemStack)) {
			Block block = world.getBlockState(pos).getBlock();
			
			if (block.equals(Blocks.GRAVEL)) {
				if (!world.isRemote) {
					world.setBlockState(pos, Blocks.AIR.getDefaultState());
					world.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0F, (1.0F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F) * 0.7F);
					EntityPhoenix phoenix = new EntityPhoenix(world);
					phoenix.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
					world.spawnEntityInWorld(phoenix);
				} else {
					world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, pos.getX(), pos.getY(), pos.getZ(), 0.0D, 0.0D, 0.0D, new int[0]);
				}
			}
		}
    	return EnumActionResult.SUCCESS;
    }
}
