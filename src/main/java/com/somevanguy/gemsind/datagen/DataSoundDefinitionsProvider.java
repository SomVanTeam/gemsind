package com.somevanguy.gemsind.datagen;

import com.somevanguy.gemsind.GemstoneIndustryMod;
import com.somevanguy.gemsind.content.AllSoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class DataSoundDefinitionsProvider extends SoundDefinitionsProvider {
    protected DataSoundDefinitionsProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, GemstoneIndustryMod.MODID, helper);
    }

    @Override
    public void registerSounds() {
        for (String originName : AllSoundEvents.SoundOrigins.keySet()) {
            var soundOrigin = AllSoundEvents.SoundOrigins.get(originName);
            var soundList = soundOrigin.locations();
            var definition = SoundDefinition.definition().subtitle("sounds.gemsind."+originName).replace(true);
            for (ResourceLocation soundLocation : soundList) {
                definition.with(sound(soundLocation, SoundDefinition.SoundType.SOUND));
            }
            add(soundOrigin.soundEventSupplier(), definition);
        }
    }
}
