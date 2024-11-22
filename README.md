# Biome111

The original goal was to modify the minecraft region file to store biome in 16x16x16 blocks per subchunk instead of the vanilla 4x4x4.
Things get complicated and this repo just hijacks when the biome is accessed instead since this will be a one-off use anyway.

Relevant mixins:
 - [`BiomeAccess`](https://github.com/WaterGenie35/biome111/blob/main/src/client/java/genie/biome111/mixin/client/CustomBiomePatternBiomeAccessMixin.java)
 - [`OctaveSimplexNoiseSampler`](https://github.com/WaterGenie35/biome111/blob/main/src/main/java/genie/biome111/mixin/CustomTemperaturePatternOctaveSimplexNoiseSampler.java)
