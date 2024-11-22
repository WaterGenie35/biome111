package genie.biome111.mixin;

import java.util.function.Predicate;

import org.apache.commons.lang3.mutable.MutableInt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.command.FillBiomeCommand;
import net.minecraft.util.math.BlockBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSupplier;
import net.minecraft.world.chunk.Chunk;

@Mixin(FillBiomeCommand.class)
public abstract class ModifiedFillBiomeCommandMixin {
    
    @Inject(method="createBiomeSupplier(Lorg/apache/commons/lang3/mutable/MutableInt;Lnet/minecraft/world/chunk/Chunk;Lnet/minecraft/util/math/BlockBox;Lnet/minecraft/registry/entry/RegistryEntry;Ljava/util/function/Predicate;)Lnet/minecraft/world/biome/source/BiomeSupplier;", at=@At("HEAD"), cancellable=true)
    private static void forceCreateBiome(MutableInt counter, Chunk chunk, BlockBox box, RegistryEntry<Biome> biome, Predicate<RegistryEntry<Biome>> filter, CallbackInfoReturnable<BiomeSupplier> cir) {
        cir.setReturnValue((x, y, z, noise) -> {
            counter.increment();
            return biome;
        });
    }

}
