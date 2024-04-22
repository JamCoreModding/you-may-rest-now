package io.github.jamalam360.you_may_rest_now.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import io.github.jamalam360.you_may_rest_now.YouMayRestNow;
import java.util.List;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin {

    @ModifyExpressionValue(method = "startSleepInBed", at = @At(value = "INVOKE", target = "Ljava/util/List;isEmpty()Z"))
    private boolean youmayrestnow$modifySleepValue(boolean original, @Local Vec3 vec3, @Local List<Monster> monsters) {
        return YouMayRestNow.canSleep(monsters, vec3);
    }
}
