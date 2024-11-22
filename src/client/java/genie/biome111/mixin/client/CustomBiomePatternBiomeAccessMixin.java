package genie.biome111.mixin.client;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;

@Mixin(BiomeAccess.class)
public abstract class CustomBiomePatternBiomeAccessMixin {
    
    @Inject(method="getBiome(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/registry/entry/RegistryEntry;", at=@At("HEAD"), cancellable=true)
    public void getCustomBiomePattern(BlockPos pos, CallbackInfoReturnable<RegistryEntry<Biome>> cir) {
        // Just strips of biome for testing
        String[] biomePattern = {
            "swamp",
            "dark_forest",
            "swamp",
            "badlands",
            "desert",
            "cherry_grove",
            "stony_peaks",
            "plains",
            "the_void",
            "windswept_hills",
            "snowy_plains",
            "snowy_beach",
            "taiga",
            "old_growth_pine_taiga",
            "meadow",
            "birch_forest",
            "forest",
            "sparse_jungle",
            "jungle",
            "mushroom_fields"
        };
        double scale = 2.0;
        int index = Math.floorMod((int)Math.floor(pos.getX() / scale), biomePattern.length);
        String biomeString = biomePattern[index];

        MinecraftClient client = MinecraftClient.getInstance();
        DynamicRegistryManager registryManager = client.world.getRegistryManager();
        Optional<RegistryEntry.Reference<Biome>> biome_reference = registryManager.getOrThrow(RegistryKeys.BIOME).getEntry(Identifier.ofVanilla(biomeString));
        if (biome_reference.isPresent()) {
            cir.setReturnValue(biome_reference.get());
        }
    }

}
