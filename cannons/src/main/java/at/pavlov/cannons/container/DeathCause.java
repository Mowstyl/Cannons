package at.pavlov.cannons.container;

import at.pavlov.cannons.projectile.Projectile;

import java.util.UUID;

public record DeathCause(Projectile projectile, UUID cannonUID, UUID shooterUID) {

}
