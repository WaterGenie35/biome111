package genie.biome111.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Force biome palette to be the same size as blocks.
 */
@Mixin(targets="net.minecraft.world.chunk.PalettedContainer$PaletteProvider")
public abstract class ExpandedBiomePaletteProviderMixin {

    @Shadow public int edgeBits = 4;

}
