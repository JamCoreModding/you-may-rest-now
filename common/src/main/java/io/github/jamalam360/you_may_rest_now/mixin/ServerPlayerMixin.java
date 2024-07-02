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

    @ModifyExpressionValue(method = "method_26283", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Monster;isPreventingPlayerRest(Lnet/minecraft/world/entity/player/Player;)Z"))
    private boolean youmayrestnow$modifySleepValue(boolean original, Monster monster) {
        return YouMayRestNow.isMonsterPreventingPlayerRest(monster, (ServerPlayer) (Object) this);
    }
}
