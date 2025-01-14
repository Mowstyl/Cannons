package at.pavlov.cannons.container;

import at.pavlov.cannons.Enum.FakeBlockType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.UUID;

public class FakeBlockEntry implements Cloneable {

    private final int locX;
    private final int locY;
    private final int locZ;
    private final UUID world;
    //how long the block stays in ticks
    private final long duration;
    //fake block will only be shown to this player
    private final UUID player;
    //only one type effect will be shown (aiming, explosion,...)
    private final FakeBlockType type;
    private long startTime;


    public FakeBlockEntry(int x, int y, int z, UUID worldUUID, UUID playerUUID, FakeBlockType type, long duration) {
        this.locX = x;
        this.locY = y;
        this.locZ = z;
        this.world = worldUUID;

        this.player = playerUUID;
        this.type = type;

        this.startTime = System.currentTimeMillis();
        this.duration = duration;
    }

    public FakeBlockEntry(Location loc, Player player, FakeBlockType type, long duration) {
        this(loc.getBlockX(),
             loc.getBlockY(),
             loc.getBlockZ(),
             loc.getWorld().getUID(),
             player.getUniqueId(),
             type,
             duration);
    }


    public int getLocX() {
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    public int getLocZ() {
        return locZ;
    }

    public UUID getWorld() {
        return world;
    }

    public World getWorldBukkit() {
        return Bukkit.getWorld(getWorld());
    }

    public Location getLocation() {
        World world = getWorldBukkit();
        if (world != null) {
            return new Location(world, getLocX(), getLocY(), getLocZ());
        } else {
            return null;
        }
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getDuration() {
        return duration;
    }

    public boolean isExpired() {
        return (System.currentTimeMillis() > getStartTime() + getDuration() * 50);
    }

    public UUID getPlayer() {
        return player;
    }

    public Player getPlayerBukkit() {
        return Bukkit.getPlayer(getPlayer());
    }

    @Override
    public int hashCode() {
        int hash = 3;

        hash = 19 * hash + (this.world != null ? this.world.hashCode() : 0);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.locX) ^ (Double.doubleToLongBits(this.locX) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.locY) ^ (Double.doubleToLongBits(this.locY) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.locZ) ^ (Double.doubleToLongBits(this.locZ) >>> 32));
        hash = 19 * hash + player.hashCode();
        hash = 19 * hash + type.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof final FakeBlockEntry obj2)) {
            return false;
        }
        return this.locX == obj2.getLocX() && this.locY == obj2.getLocY() && this.locZ == obj2.getLocZ() && this.world.equals(obj2.getWorld())
                && this.player.equals(obj2.getPlayer())
                && this.type == obj2.getType();
    }

    public FakeBlockType getType() {
        return type;
    }

    @Override
    public FakeBlockEntry clone() {
        FakeBlockEntry theClone = new FakeBlockEntry(
                this.locX,
                this.locY,
                this.locZ,
                this.world,
                this.player,
                this.type,
                this.duration);
        theClone.startTime = this.startTime;
        return theClone;
    }

}
