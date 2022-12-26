package at.pavlov.cannons.container;

import org.bukkit.Sound;

import java.util.Locale;
import java.util.Scanner;

public class SoundHolder {

    private Sound soundenum;
    private String soundstr;
    private Float volume;
    private Float pitch;

    public SoundHolder(String str) {
        // data structure:
        // 'IRON_GOLEM_WALK:1:0.5'
        try {
            soundenum = null;
            soundstr = null;
            volume = 1.0F;
            pitch = 1.0F;
            Scanner s = new Scanner(str).useDelimiter("\\s*:\\s*");

            // use US locale to be able to identify floats in the string
            s.useLocale(Locale.US);

            if (s.hasNext()) {
                String scan = s.next();
                if (scan != null && !scan.equalsIgnoreCase("none")) {
                    try {
                        soundenum = Sound.valueOf(scan);
                    } catch (Exception e) {
                        soundstr = scan;
                    }
                }
            } else {
                System.out.println("missing sound value in: " + str);
            }

            if (s.hasNextFloat()) {
                volume = s.nextFloat();
            } else {
                System.out.println("missing volume value in: " + str);
            }
            if (s.hasNextFloat()) {
                pitch = s.nextFloat();
            } else {
                System.out.println("missing pitch value in: " + str);
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Error while converting " + str + ". Formatting: 'IRON_GOLEM_WALK:1:0.5'" + e);
        }
    }

    public SoundHolder(Sound sound, float volume, float pitch) {
        this.soundenum = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    public SoundHolder(String sound, float volume, float pitch) {
        this.soundstr = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    public Sound getSoundEnum() {
        return soundenum;
    }

    public String getSoundString() {
        return soundstr;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Float getPitch() {
        return pitch;
    }

    public void setPitch(Float pitch) {
        this.pitch = pitch;
    }

    public boolean isValid() {
        return this.soundenum != null || this.soundstr != null;
    }

    public boolean isSoundString() {
        return this.soundstr != null;
    }

    public void setSoundString(String sound) {
        this.soundstr = sound;
    }

    public boolean isSoundEnum() {
        return this.soundenum != null;
    }

    public void setSoundEnum(Sound sound) {
        this.soundenum = sound;
    }

    public String toString() {
        if (this.soundenum != null) {
            return this.soundenum + ":" + volume + ":" + pitch;
        } else if (this.soundstr != null) {
            return this.soundstr + ":" + volume + ":" + pitch;
        } else {
            return "Sound not found";
        }
    }

}
