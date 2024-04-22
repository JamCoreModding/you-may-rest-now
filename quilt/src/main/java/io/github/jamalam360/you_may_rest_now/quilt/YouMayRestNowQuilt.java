package io.github.jamalam360.you_may_rest_now.quilt;

import io.github.jamalam360.you_may_rest_now.YouMayRestNow;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class YouMayRestNowQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        YouMayRestNow.init();
    }
}
