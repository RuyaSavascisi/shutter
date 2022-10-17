package net.stehschnitzel.shutter.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stehschnitzel.shutter.shutter.Shutter;

@Mixin(Block.class)
public class FenceMixins {

	@Inject(method = "isExceptionForConnection", at = @At("HEAD"))
	protected boolean isExceptionForConnection(BlockState pState) {
		if (pState.getBlock() instanceof Shutter) {
			return true;
		} else {
			return Block.isExceptionForConnection(pState);
		}
		
	}
	
}
