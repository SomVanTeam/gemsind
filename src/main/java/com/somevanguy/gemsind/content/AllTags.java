package com.somevanguy.gemsind.content;

import com.somevanguy.gemsind.GemstoneIndustryMod;
import com.somevanguy.gemsind.content.items.GemItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class AllTags {
    public static class Blocks {
        public static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(GemstoneIndustryMod.MODID, name));
        }
    }

    public static class Items {
        public static Map<String, TagKey<Item>> elementTags = new HashMap<>();
        public static TagKey<Item> getElementTag(String element) {
            return elementTags.get(GemItem.safeElementName(element));
        }

        public static TagKey<Item> createElementTag(String element) {
            element = GemItem.safeElementName(element);
            var tag = createTag("has_element/"+element);
            elementTags.put(element, tag);
            return tag;
        }

        public static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(GemstoneIndustryMod.MODID, name));
        }

        public static void createProminentTags() {
            for (String element : GemItem.prominentElements) {
                createElementTag(element);
            }
        }

        public static final TagKey<Item> GEMSTONE = createTag("gemstone");
        public static final TagKey<Item> GEODE = createTag("geode");
        public static final TagKey<Item> FLUX = createTag("flux");
        public static final TagKey<Item> ACID = createTag("contains_acid");
        public static final TagKey<Item> ALLOY = createTag("alloy");
    }
}
