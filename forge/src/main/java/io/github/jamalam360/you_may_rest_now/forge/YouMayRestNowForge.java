package io.github.jamalam360.you_may_rest_now.forge;

import io.github.jamalam360.you_may_rest_now.YouMayRestNow;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(YouMayRestNow.MOD_ID)
public class YouMayRestNowForge {
    public YouMayRestNowForge() {
        EventBuses.registerModEventBus(YouMayRestNow.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        YouMayRestNow.init();
    }
}
