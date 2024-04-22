package io.github.jamalam360.you_may_rest_now;

import dev.architectury.event.events.common.TickEvent;
import dev.architectury.platform.Platform;
import io.github.jamalam360.jamlib.JamLib;
import io.github.jamalam360.jamlib.JamLibPlatform;
import io.github.jamalam360.jamlib.config.ConfigManager;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YouMayRestNow {

    public static final String MOD_ID = "you_may_rest_now";
    public static final String MOD_NAME = "You May Rest Now";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static final ConfigManager<Config> CONFIG = new ConfigManager<>(MOD_ID, Config.class);

    public static void init() {
        JamLib.checkForJarRenaming(YouMayRestNow.class);

        if (Platform.isDevelopmentEnvironment()) {
            TickEvent.SERVER_LEVEL_POST.register((level) -> {
                if (level.getGameTime() % 20 == 0) {
                    ServerPlayer player = level.getRandomPlayer();

                    if (player == null) {
                        return;
                    }

                    List<Monster> monsters = level.getEntitiesOfClass(Monster.class, new AABB(player.position().x() - 8.0, player.position().y() - 5.0, player.position().z() - 8.0, player.position().x() + 8.0, player.position().y() + 5.0, player.position().z() + 8.0), monster -> monster.isPreventingPlayerRest(player));
                    player.sendSystemMessage(Component.literal(canSleep(monsters, player.position()) ? "Can Sleep" : "Can't Sleep"), true);
                }
            });
        }

        LOGGER.info("Initialized " + MOD_NAME + " on " + JamLibPlatform.getPlatform());
    }

    public static boolean canSleep(List<Monster> nearbyMonsters, Vec3 bedPosition) {
        Config config = CONFIG.get();

        switch (config.mode) {
            case VANILLA -> {
                return nearbyMonsters.isEmpty();
            }
            case DENY_IF_PATHFINDABLE -> {
                return nearbyMonsters.stream().noneMatch(monster -> {
                    Path path = monster.getNavigation().createPath(BlockPos.containing(bedPosition), 0);
                    return path != null && path.canReach();
                });
            }
            default -> {
                return true;
            }
        }
    }
}
