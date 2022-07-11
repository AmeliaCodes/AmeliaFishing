package tech.amelia.fishing.events;

import lombok.Data;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import tech.amelia.fishing.reward.FishingReward;

@Data
public final class CustomFishEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final FishingReward reward;
    private boolean cancelled;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public CustomFishEvent(final FishingReward reward) {
        this.reward = reward;
        this.cancelled = false;
    }
}
