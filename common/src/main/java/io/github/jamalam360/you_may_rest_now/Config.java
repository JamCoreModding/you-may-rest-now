package io.github.jamalam360.you_may_rest_now;

import io.github.jamalam360.jamlib.config.ConfigExtensions;
import java.util.List;
import net.minecraft.network.chat.Component;

public class Config implements ConfigExtensions<Config> {

    public Mode mode = Mode.DENY_IF_PATHFINDABLE;

    @Override
    public List<Link> getLinks() {
        return List.of(new Link(Link.DISCORD, "https://jamalam.tech/discord", Component.translatable("config.you_may_rest_now.discord")), new Link(Link.GITHUB, "https://github.com/JamCoreModding/you-may-rest-now", Component.translatable("config.you_may_rest_now.github")), new Link(Link.GENERIC_LINK, "https://modrinth.com/mod/you-may-rest-now", Component.translatable("config.you_may_rest_now.modrinth")));
    }

    public enum Mode {
        VANILLA,
        DENY_IF_PATHFINDABLE,
        DISABLE
    }
}
