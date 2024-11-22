package genie.biome111.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.world.chunk.ChunkSection;

@Mixin(ChunkSection.class)
public abstract class ExpandedBiomeChunkSectionMixin {
    
    /**
     * Loop through 16x16x16 instead of 4x4x4
     */
    @ModifyConstant(method="populateBiomes(Lnet/minecraft/world/biome/source/BiomeSupplier;Lnet/minecraft/world/biome/source/util/MultiNoiseUtil$MultiNoiseSampler;III)V", constant=@Constant(intValue=4))
    private int expandedBiomeVoxel(int originalVoxel) {
        return 16;
    }

}
