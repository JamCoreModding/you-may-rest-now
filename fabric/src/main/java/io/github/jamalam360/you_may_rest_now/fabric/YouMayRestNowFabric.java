package io.github.jamalam360.you_may_rest_now.fabric;

import io.github.jamalam360.you_may_rest_now.YouMayRestNow;
import net.fabricmc.api.ModInitializer;

public class YouMayRestNowFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        YouMayRestNow.init();
    }
}
