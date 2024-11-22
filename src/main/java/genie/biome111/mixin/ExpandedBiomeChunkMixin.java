package genie.biome111.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import net.minecraft.world.chunk.Chunk;

@Mixin(Chunk.class)
public abstract class ExpandedBiomeChunkMixin {

    @ModifyConstant(method="getBiomeForNoiseGen(III)Lnet/minecraft/registry/entry/RegistryEntry;", constant=@Constant(intValue=3))
    private int expandedBiomeVoxel(int originalMod) {
        // results in 0-15
        return 15;
    }
}
