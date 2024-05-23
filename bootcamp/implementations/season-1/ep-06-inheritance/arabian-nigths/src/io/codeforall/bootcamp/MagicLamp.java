package io.codeforall.bootcamp;

import io.codeforall.bootcamp.genie.FriendlyGenie;
import io.codeforall.bootcamp.genie.Genie;
import io.codeforall.bootcamp.genie.GrumpyGenie;
import io.codeforall.bootcamp.genie.RecyclableDemon;

/**
 * A Magic Lamp, capable of providing Geniuses when rubbed
 */
public class MagicLamp {

    private int genieLimit; // Maximum number of genies the lamp can generate
    private int rubs; // Number of times the lamp has been rubbed since the last recharge
    private int timesRecharged; // Number of times the lamp has been recharged with demons

    /**
     * Constructs Magic Lamps capable of providing a maximum number of geniuses
     *
     * @param genieLimit the maximum number of genies
     */
    public MagicLamp(int genieLimit) {
        this.genieLimit = genieLimit;
    }

    public int getGenieLimit() {
        return genieLimit;
    }

    public int getTimesRecharged() {
        return timesRecharged;
    }

    /**
     * Calculates the number of genies the lamp is able to create before needing a demon recharge
     *
     * @return the number of available genies
     */
    public int getAvailableGenies() {
        return genieLimit - rubs;
    }

    /**
     * Get a Genie by rubbing the lamp
     *
     * @param wishes number of wishes to ask to the generated Genie
     * @return the generated Genie
     */
    public Genie rub(int wishes) {

        if (getAvailableGenies() == 0) {
            return new RecyclableDemon(wishes);
        }

        Genie genie;
        if (rubs % 2 == 0) {
            genie = new FriendlyGenie(wishes);
        } else {
            genie = new GrumpyGenie(wishes);
        }

        rubs++;
        return genie;

    }

    /**
     * Recharge the lamp by feeding it with a demon
     *
     * @param demon the RecyclableDemon to feed the lamp with
     */
    public void recharge(RecyclableDemon demon) {

        if (demon.isRecycled()) {
            return;
        }

        demon.recycle();
        rubs = 0;
        timesRecharged++;
    }

    /**
     * Tests two lamps for equality
     *
     * @param lamp the lamp to test against
     * @return if both lamps have same number of available genies, demon recharges and genie limits
     */
    public boolean equals(MagicLamp lamp) {

        return getGenieLimit() == lamp.getGenieLimit() &&
                getAvailableGenies() == lamp.getAvailableGenies() &&
                getTimesRecharged() == lamp.getTimesRecharged();

    }

}
