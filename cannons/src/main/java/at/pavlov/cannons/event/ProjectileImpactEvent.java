package at.pavlov.cannons.event;

import at.pavlov.cannons.projectile.FlyingProjectile;
import at.pavlov.cannons.projectile.Projectile;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ProjectileImpactEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final UUID shooter;
    private Projectile projectile;
    private Location impactLocation;
    private boolean cancelled;
    private FlyingProjectile flyingProjectile;
    @Nullable
    private BlockFace hitBlockFace;

    public ProjectileImpactEvent(
            Projectile projectile,
            Location impactLocation,
            UUID shooter,
            FlyingProjectile flyingProjectile,
            @Nullable BlockFace hitBlockFace
    ) {
        this.projectile = projectile;
        this.impactLocation = impactLocation;
        this.shooter = shooter;
        this.cancelled = false;
        this.flyingProjectile = flyingProjectile;
        this.hitBlockFace = hitBlockFace;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public UUID getShooterUID() {
        return this.shooter;
    }

    public Location getImpactLocation() {
        return this.impactLocation;
    }

    public void setImpactLocation(Location impactLocation) {
        this.impactLocation = impactLocation;
    }

    public Projectile getProjectile() {
        return this.projectile;
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }

    // CCNet - expose FlyingProjectile
    public FlyingProjectile getFlyingProjectile() {
        return this.flyingProjectile;
    }

    public void setFlyingProjectile(FlyingProjectile flyingProjectile) {
        this.flyingProjectile = flyingProjectile;
    }

    // CCNet - hit BlockFace
    @Nullable
    public BlockFace getHitBlockFace() {
        return this.hitBlockFace;
    }

    public void setHitBlockFace(@Nullable BlockFace face) {
        this.hitBlockFace = face;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

}
