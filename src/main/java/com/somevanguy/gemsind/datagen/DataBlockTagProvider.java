package com.somevanguy.gemsind.datagen;

import com.somevanguy.gemsind.GemstoneIndustryMod;
import com.somevanguy.gemsind.content.AllBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DataBlockTagProvider extends BlockTagsProvider {
    public DataBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GemstoneIndustryMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addAll(List.of(
                        AllBlocks.COUNTER.getKey(),
                        AllBlocks.ACID_PURIFIER.getKey(),
                        AllBlocks.CENTRIFUGE.getKey(),
                        AllBlocks.TUMBLER.getKey(),
                        AllBlocks.ALLOYING_FURNACE.getKey()
                ));

        tag(BlockTags.NEEDS_STONE_TOOL)
                .addAll(List.of(
                        AllBlocks.COUNTER.getKey()
                ));

        tag(BlockTags.NEEDS_IRON_TOOL)
                .addAll(List.of(
                        AllBlocks.ACID_PURIFIER.getKey(),
                        AllBlocks.CENTRIFUGE.getKey()
                ));

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .addAll(List.of(
                        AllBlocks.TUMBLER.getKey(),
                        AllBlocks.ALLOYING_FURNACE.getKey()
                ));
    }
}
