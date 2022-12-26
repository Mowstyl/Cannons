package at.pavlov.cannons.event;

import java.util.UUID;

import at.pavlov.cannons.projectile.FlyingProjectile;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import at.pavlov.cannons.projectile.Projectile;
import org.jetbrains.annotations.Nullable;

public class ProjectileImpactEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Projectile projectile;
    private Location impactLocation;
    private final UUID shooter;
    private boolean cancelled;
    private FlyingProjectile flyingProjectile;
    @Nullable
    private BlockFace hitBlockFace;

    public ProjectileImpactEvent(Projectile projectile, Location impactLocation, UUID shooter, FlyingProjectile flyingProjectile, BlockFace hitBlockFace) {
	this.projectile = projectile;
	this.impactLocation = impactLocation;
	this.shooter = shooter;
	this.cancelled = false;
    this.flyingProjectile = flyingProjectile;
    this.hitBlockFace = hitBlockFace;
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
    public HandlerList getHandlers() {
	return handlers;
    }

    public static HandlerList getHandlerList() {
	return handlers;
    }
}
