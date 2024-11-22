package genie.biome111.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.math.noise.OctaveSimplexNoiseSampler;

@Mixin(OctaveSimplexNoiseSampler.class)
public abstract class CustomTemperaturePatternOctaveSimplexNoiseSampler {
    
    @Inject(method="sample(DDB)D", at=@At("HEAD"), cancellable=true)
    public void sampleCustomTemperaturePattern(double x, double y, boolean useOrigin, CallbackInfoReturnable<Double> cir) {
        // Undo the scaling
        int originalX = (int)(x / 0.0225);
        double scale = 2.0;
        int index = Math.floorMod((int)Math.floor(originalX / scale), 20);
        if (index == 0) {
            // Anything strictly less than -0.1
            cir.setReturnValue(-0.2);
        } else {
            // Anything greater than or equal to -0.1
            cir.setReturnValue(0.0);
        }
    }

}
