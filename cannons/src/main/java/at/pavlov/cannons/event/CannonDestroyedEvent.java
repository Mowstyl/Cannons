package at.pavlov.cannons.event;

import at.pavlov.cannons.Enum.BreakCause;
import at.pavlov.cannons.cannon.Cannon;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CannonDestroyedEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final Cannon cannon;
    private final BreakCause breakCause;

    public CannonDestroyedEvent(Cannon cannon, BreakCause breakCause) {
        this.cannon = cannon;
        this.breakCause = breakCause;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public Cannon getCannon() {
        return cannon;
    }

    public BreakCause getBreakCause() {
        return breakCause;
    }

}
