package genie.biome111.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.biome.source.BiomeCoords;

/**
 * Use block coordinates instead of converting to/from 4x4x4 voxels.
 */
@Mixin(BiomeCoords.class)
public abstract class NullBiomeCoordsMixin {
    
    @Inject(method="fromBlock(I)I", at=@At("HEAD"), cancellable=true)
    private static void nullifyFromBlock(int blockCoord, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(blockCoord);
    }

    @Inject(method="method_39920(I)I", at=@At("HEAD"), cancellable=true)
    private static void nullifyMethod39920(int i, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(i);
    }

    @Inject(method="toBlock(I)I", at=@At("HEAD"), cancellable=true)
    private static void nullifyToBlock(int biomeCoord, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(biomeCoord);
    }

    @Inject(method="fromChunk(I)I", at=@At("HEAD"), cancellable=true)
    private static void nullifyFromChunk(int chunkCoord, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(chunkCoord);
    }

    @Inject(method="toChunk(I)I", at=@At("HEAD"), cancellable=true)
    private static void nullifyToChunk(int biomeCoord, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(biomeCoord);
    }
}
